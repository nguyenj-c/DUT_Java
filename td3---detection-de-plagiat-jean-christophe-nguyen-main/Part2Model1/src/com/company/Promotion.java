package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Promotion {
    private ArrayList<Etudiant> myPromotion = new ArrayList<>();

    public void addEtudiant(Etudiant etudiant){
        myPromotion.add(etudiant);
    }
    public void sort(ComparaisonEtudiant Comparateur){
        Collections.sort(myPromotion,Comparateur);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                myPromotion +
                "}";
    }
}
