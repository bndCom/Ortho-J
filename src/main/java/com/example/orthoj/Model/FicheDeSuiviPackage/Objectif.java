    package com.example.orthoj.Model.FicheDeSuiviPackage;

    import java.io.Serializable;
    import java.lang.reflect.Type;
    import java.util.LinkedList;

    public class Objectif implements Serializable {
        private String nom ;
        private TypeObjectifs typeObjectifs ;

        private String lol = "--";

        public void setLol(String lol) {
            this.lol = lol;
        }

        public String getLol() {
            return lol;
        }

        private LinkedList<Integer> notes = new LinkedList<Integer>() ;




        public  Objectif (String nom , TypeObjectifs typeObjectifs){

            this.nom = nom;

            this.typeObjectifs = typeObjectifs;

        }
        public TypeObjectifs getTypeObjectifs() {
            return typeObjectifs;
        }

        public String getTypeObjectifString(){return typeObjectifs.toString();}

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setTypeObjectifs(TypeObjectifs typeObjectifs) {
            this.typeObjectifs = typeObjectifs;
        }


        public void addNote(int n){
            notes.add(n);
            lol = "" + n  ;

        }

    }

