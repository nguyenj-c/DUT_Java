package com.company;

public class ComparaisonParId implements ComparaisonEtudiant {

    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        Integer numEtu1 = Integer.valueOf(o1.getMyId());
        Integer numEtu2 = Integer.valueOf(o2.getMyId());
        //return numEtu1.compareTo(numEtu2);
        return Integer.compare(o1.getMyId(),o2.getMyId());
    }
}
