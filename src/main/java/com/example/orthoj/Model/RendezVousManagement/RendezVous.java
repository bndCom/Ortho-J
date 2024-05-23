package com.example.orthoj.Model.RendezVousManagement;

import java.time.*;
import java.util.*;


abstract public class RendezVous {
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

