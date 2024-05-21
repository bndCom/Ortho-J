package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.*;
import com.example.orthoj.Model.Enumeration.*;


import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestWork {
    public static void main(String[] args) throws InvalidResponse, InvalidQuestion, InvalidAnamQuestionType, QuestionNotAnswered {

        testAnes();
    }
    static void testAnes() throws InvalidResponse, InvalidAnamQuestionType, QuestionNotAnswered {
        List<String> questions = new ArrayList<>();
        questions.add("how many your family members");
        questions.add("your family is it beautiful");
        QLAnamEnfant qlEnfant = new QLAnamEnfant(TypeQLAnamEnfant.STRUCTURE_FAMILIALE, questions);
        questions.clear();
        questions.add(" what is your history");
        questions.add("from how long you were sick");
        QLAnamAdulte qlAdulte = new QLAnamAdulte(TypeQLAnamAdulte.HISTOIRE, questions);
        // answering questions -------------------------
        List<String> answers = new ArrayList<>();
        answers.add("6");
        answers.add("yes");
        qlEnfant.setReponsesChoisis(answers);
        answers.clear();
        answers.add("i was sick one time");
        answers.add("time ago");
        qlAdulte.setReponsesChoisis(answers);

        AnamneseEnfant anam = new AnamneseEnfant();
        AnamneseAdulte anam2 = new AnamneseAdulte();

        anam.setQLStructureFamilale((QLAnamEnfant) qlEnfant);
        anam2.setQLHistoire((QLAnamAdulte) qlAdulte);


        // getting the questions
        QLAnamEnfant qlOutEnfant = anam.getQLStructureFamilale();
        QLAnamAdulte qlOutAdulte = anam2.getQLHistoire();

        System.out.println("the form of enfant is: "+qlOutEnfant.getType());
        System.out.println(qlOutEnfant.getForm());

        System.out.println("the form of adulte is: "+qlOutAdulte.getType());
        System.out.println(qlOutAdulte.getForm());


    }
}