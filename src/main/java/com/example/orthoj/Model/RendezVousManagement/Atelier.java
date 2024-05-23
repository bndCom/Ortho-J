package com.example.orthoj.Model.RendezVousManagement;


import java.util.LinkedList;

public class Atelier {
    private String Theme ;
    LinkedList<Integer> list = new LinkedList<Integer>();

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public void setList(LinkedList<Integer> list) {
        this.list = list;
    }
}
