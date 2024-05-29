package com.example.orthoj.Model.RendezVousManagement;


import com.example.orthoj.Model.CustomException.InvalidRendezVousTimeClash;
import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Calendrier {

    TreeMap<LocalDate , LinkedList<RendezVous>> calendrier = new TreeMap<LocalDate , LinkedList<RendezVous>>();

    public TreeMap<LocalDate , LinkedList<RendezVous>> getCalendrier(){
        return calendrier;
    }

    public void AjouterRDV ( RendezVous RDV) throws InvalidRendezVousTimeClash {
        LinkedList<RendezVous> list ;
        // check if the wanted date has any RDV's in the calendar
        if( calendrier.containsKey(RDV.getDateTime().toLocalDate()) ){
            // making sure that no time interval clashes are happening
            boolean valid = true ;
            LocalTime startTime , endTime , time ;
            time = RDV.getDateTime().toLocalTime();
            RendezVous RDVTest ;
            LinkedList<RendezVous> linkedList = calendrier.get(RDV.getDateTime().toLocalDate());
           Iterator<RendezVous> iterator = linkedList.iterator();

            while (iterator.hasNext() && valid){
                RDVTest = iterator.next();
                startTime = RDVTest.dateTime.toLocalTime();
                endTime = startTime.plus(RDV.getDuration());
                
                valid = !IsInInterval(startTime , endTime , time);



            }
            if (valid){
                linkedList.add(RDV);
            }

            if (!valid){
                throw new InvalidRendezVousTimeClash();
            }


        }else {
            list = new LinkedList<RendezVous>();
            list.add(RDV);
            calendrier.put(RDV.getDateTime().toLocalDate() ,list );
        }


    }

    public boolean RendezVousExist(RendezVous RDV){
        if (calendrier.containsKey(RDV.getDateTime().toLocalDate())){
            return isInList(calendrier.get(RDV.getDateTime().toLocalDate()) , RDV);

        }else{
           return false;
        }
    }
    public boolean RendezVousExist(LocalDateTime dateTime){
        if (calendrier.containsKey(dateTime.toLocalDate())){
            return isInList(calendrier.get(dateTime.toLocalDate()) , dateTime.toLocalTime());

        }else{
            return false;
        }
    }

    public RendezVous GetRendezVous(RendezVous RDV) {
        LocalDate date = RDV.getDateTime().toLocalDate();
        LinkedList<RendezVous> list = calendrier.get(date);
        if (list != null) {
            for (RendezVous rendezVous : list) {
                if (rendezVous.equals(RDV)) {
                    return rendezVous;
                }
            }
        }
        return null;
    }


    public boolean IsInInterval(LocalTime StartTime , LocalTime EndTime , LocalTime time){
        return time.isAfter(StartTime) && time.isBefore(EndTime);
    }

    public boolean isInList(LinkedList<RendezVous> list , RendezVous RDV){
        boolean find = false ;

        for ( RendezVous rdv : list){
            if (rdv.equals(RDV)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInList(LinkedList<RendezVous> list , LocalTime time ){
        boolean find = false ;

        for ( RendezVous rdv : list){
            if (rdv.getDateTime().toLocalTime() == time) {
                return true;
            }
        }
        return false;
    }

    public void deleteRDV(RendezVous rendezVous){
        calendrier.get(rendezVous.getDateTime().toLocalDate()).remove(rendezVous);
    }
}
