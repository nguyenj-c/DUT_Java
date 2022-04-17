package com.company;

import java.util.Comparator;

public class Etudiant implements Comparator {
    private String myNom;
    private  String myPrenom;
    private int myId;

    public Etudiant(String nom, String prenom, int id) {
        myNom = nom;
        myPrenom = prenom;
        myId = id;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "myNom='" + myNom + '\'' +
                ", myPrenom='" + myPrenom + '\'' +
                ", myId='" + myId +
                "}";
    }
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public String getMyNom() {
        return myNom;
    }

    public String getMyPrenom() {
        return myPrenom;
    }

    public int getMyId() {
        return myId;
    }



}
