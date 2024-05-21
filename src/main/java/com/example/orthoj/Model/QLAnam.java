package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.InvalidResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class QLAnam {
    // the difference with the QL of epreuve is that this QL is not noted, and also has a specific category
    // attributes
    protected Map<String, String> form ;
    protected boolean done;
    // constructure
    public QLAnam(List<String> questions){
        this.done = false;
        this.form = new HashMap<String, String>();
        // adding the questions to the form
        for(String question : questions){
            form.put(question, null);
        }
    }

    // setters
    // set the chosen responses, they must be in the same order of the questions
    public void setReponsesChoisis(List<String> reponsesChoisis) throws InvalidResponse {
        if(reponsesChoisis.size() != form.size()) {
            throw new InvalidResponse();
        }
        int i = 0;
        this.done = true;
        // iterate over the questions and set their responses
        for(Map.Entry<String, String> reponse : form.entrySet()){
            this.form.put(reponse.getKey(), reponsesChoisis.get(i));
            i++;
        }
    }

    // getters
    // get the state of the question
    public boolean getState(){
        return this.done;
    }

    // get the form (questions + answers)
    public Map<String, String> getForm(){
        return this.form;
    }

    abstract public Object getType();
}
