package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.InvalidResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QL extends Question{

    // attributes
    private Map<String, String> form ;
    // this is the list of notes on each answer
    private int[] notes;
    // constructure
    public QL(List<String> questions){
        super(); // to initialize the score and the state of the question
        this.form = new HashMap<String, String>();
        // adding the questions to the form
        for(String question : questions){
            form.put(question, null);
        }
    }

    // getters
    public Map<String, String> getForm(){
        return this.form;
    }
    // setters
    // set the chosen responses, they must be in the same order of the questions
    public void setReponsesChoisis(List<String> reponsesChoisis) throws InvalidResponse{
        if(reponsesChoisis.size() != form.size()) {
            throw new InvalidResponse();
        }
        int i = 0;
        // iterate over the questions and set their responses
        for(Map.Entry<String, String> reponse : form.entrySet()){
            this.form.put(reponse.getKey(), reponsesChoisis.get(i));
            i++;
        }
    }
    public void setNotes(int[] notes) {
        this.notes = notes;
        this.calcQstScore(); // calculate the score
        this.done = true; // the question is answered
    }

    // implementation of abstract method
    @Override
    protected void calcQstScore(){
        for(int note : this.notes){
            this.score += note;
        }

    }

    public boolean equals(QL ql){
        return this.form.equals(ql.getForm());
    }




}
