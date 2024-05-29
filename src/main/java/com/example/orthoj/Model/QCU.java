package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.CustomException.InvalidQuestion;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;

import java.util.*;

public class QCU extends Question{
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
    private List<String> reponsesChoisis;
    private List<CompteRenduQCM> compteRendusQCM;


    // constructure
    public QCU(Map<String, Map<String, Boolean>> form) throws InvalidQuestion{
        super(); // to initialize the score and the state of the question
        if(validQst(form)){
            this.form = form;
        }else {
            throw new InvalidQuestion();
        }
    }

    //getters
    public Map<String, Map<String, Boolean>> getForm(){
        return this.form;
    }

    // setters
    // setting the responses of the patient, they must be in the same order of the questions
    public void setReponsesChoisis(List<String> reponsesChoisis) throws InvalidResponse {
        if(reponsesChoisis.size() != form.size()){
            throw new InvalidResponse();
        }
        this.reponsesChoisis = reponsesChoisis;
        this.calcQstScore(); // calculate the score
        this.done = true; // the question is answered

    }

    // getters
    public List<CompteRenduQCM> getCompteRendus() throws QuestionNotAnswered {
        if(!this.done){
            throw new QuestionNotAnswered();
        }
        // setting questions and choix
        compteRendusQCM = new LinkedList<>();
        Iterator<String> itr = reponsesChoisis.iterator();
        for(Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()){
            CompteRenduQCM compteRenduQCM = new CompteRenduQCM();
            // setting question
            compteRenduQCM.setQuestion(entry.getKey());
            String choisi = itr.next(); // chosen answers in that question
            String choix = new String();
            String correctes = new String();
            String choisis = new String();
            int i = 1;
            for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()){
                // setting choices and the correct ones
                choix += i+"- "+entry1.getKey()+"\n";
                if (entry1.getValue()){
                    correctes += i+"- ";
                }
                // checking if the answer is chosen
                if(choisi.contains(entry1.getKey())){
                    choisis += i+"- ";
                }
                i++;
            }

            compteRenduQCM.setChoix(choix);
            compteRenduQCM.setCorrectes(correctes);
            compteRenduQCM.setChoisis(choisis);
            compteRenduQCM.setScore(this.score);
            // adding it to the comptes rendus
            this.compteRendusQCM.add(compteRenduQCM);
        }
        return this.compteRendusQCM;
    }

    // implementation of calcQstScore
    // 1 point for each correct answer
    @Override
    protected void calcQstScore() {
        String reponse;
        Map<String, Boolean> tmp;
        int i = 0;
        // iterate over all the questions
        for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
            reponse = this.reponsesChoisis.get(i);
            tmp = entry.getValue(); // map of the responses of the current question
                if(tmp.get(reponse) != null && tmp.get(reponse)){
                    // if the response chosen by the patient is set to true in the form
                    this.score++;
                }
            i++;
        }
    }

    // check if the form is valid for a QCU ( each question must have only one answer )
    private boolean validQst(Map<String, Map<String, Boolean>> form) {
        int trues = 0;
        for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
            for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()) {
                if(entry1.getValue()) {
                    trues += 1;
                }
            }
        }
        return trues == form.size();
    }

    public boolean equals(QCU qcu){
        return this.form.equals(qcu.getForm());
    }
}
