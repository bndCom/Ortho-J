package com.example.orthoj.Model.RendezVousManagement;

import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.Patient.PatientEnfant;

import java.io.Serializable;
import java.time.*;
import java.util.*;


abstract public class RendezVous implements Serializable {
    public String type(){
        return "";
    }
    Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    boolean online = false;
    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    LocalDateTime dateTime ;
    Duration duration;


    public int compareTo(RendezVous other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVous that = (RendezVous) o;
        return dateTime.toLocalDate().equals(that.dateTime.toLocalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime.toLocalDate());
    }





    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    //setters and getters
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}

