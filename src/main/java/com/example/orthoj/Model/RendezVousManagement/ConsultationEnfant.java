package com.example.orthoj.Model.RendezVousManagement;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.Patient.PatientEnfant;

import java.time.*;

public class ConsultationEnfant extends Consultaion{


    final Duration duration = Duration.ofHours(2).plusMinutes(30);

    @Override
    public Duration getDuration() {
        return duration;
    }
}
