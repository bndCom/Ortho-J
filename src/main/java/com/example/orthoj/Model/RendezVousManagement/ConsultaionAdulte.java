package com.example.orthoj.Model.RendezVousManagement;
//import org.checkerframework.checker.units.qual.C;

import java.time.*;

public class ConsultaionAdulte  extends Consultaion {
    final Duration duration = Duration.ofHours(1).plusMinutes(30);

    @Override
    public Duration getDuration() {
        return duration;
    }
}
