package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.InvalidResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QCM extends Question{
    // attributes
    /*
    the attribute form is in this format:
    {
        "question1": {
                        "answer1": true; // true if the response is true (true by who made the question, doesn't mean the patient have chose it)
                        "answer2": false;
                     }
        ...
    }
     */
    private Map<String, Map<String, Boolean>> form;
    private List<Set<String>> reponsesChoisis;

    //constructure
    public QCM(Map<String, Map<String, Boolean>> form) {
        super(); // to initialize the score and the state of the question
        this.form = form;
    }

    // getters
    public Map<String, Map<String, Boolean>> getForm() {
        return form;
    }

    // setters
    // setting the responses of the patient, they must be in the same order of the questions
    public void setReponsesChoisis(List<Set<String>> reponsesChoisis) throws InvalidResponse {
        if(reponsesChoisis.size() != form.size()){
            throw new InvalidResponse();
        }
        this.reponsesChoisis = reponsesChoisis;
        // calculate the score
        this.calcQstScore();
        this.done = true; // the question is answered
    }

    // abstract method
    // 1 point for each correct question answer, the answers per questions must be the exact correct ones to get a point, if any added one or not chosen one, no point is taken
    @Override
    protected void calcQstScore() {
        Set<String> reponsesChx;
        Set<String> reponses = new HashSet<String>();
        Map<String, Boolean> tmp;

        int i = 0;
        // iterate over all the questions
        for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
            reponsesChx = this.reponsesChoisis.get(i);
            reponses.clear();
            // retrieving all the correct answers of the question
            tmp = entry.getValue(); // map of the responses of the current question
            for(Map.Entry<String, Boolean> entry1 : tmp.entrySet()) {
                boolean value = entry1.getValue();
                if(value){
                    reponses.add(entry1.getKey());
                }
            }

            // comparing the patient answers on the specific question with the question answers
            if(reponses.equals(reponsesChx)){
                this.score++;
            }
            i++;
        }

    }
}
