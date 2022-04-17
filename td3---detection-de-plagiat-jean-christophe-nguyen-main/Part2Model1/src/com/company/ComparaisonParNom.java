package com.company;

public class ComparaisonParNom implements ComparaisonEtudiant{

    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        return o1.getMyNom().compareTo(o2.getMyNom());
    }
}

