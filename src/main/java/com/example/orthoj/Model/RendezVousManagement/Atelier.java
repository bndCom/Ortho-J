package com.example.orthoj.Model.RendezVousManagement;


import com.example.orthoj.Model.DossierManagementPackage.Dossier;

import java.util.LinkedList;

public class Atelier extends RendezVous{
    public String type(){
        return "Atelier";
    }
    private String Theme ;
    LinkedList<Dossier> list = new LinkedList<Dossier>();

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public LinkedList<Dossier> getList() {
        return list;
    }

    public void setList(LinkedList<Dossier> list) {
        this.list = list;
    }
}
