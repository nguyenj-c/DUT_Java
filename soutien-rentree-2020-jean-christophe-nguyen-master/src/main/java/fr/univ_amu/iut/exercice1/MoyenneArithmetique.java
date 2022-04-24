package fr.univ_amu.iut.exercice1;

public class MoyenneArithmetique {

    public double calculer(TableauDeNotes tableau){
        double decimal = 0;
        for(int i=0; i<tableau.size();++i){
            decimal+=(double) tableau.get(i);
        }
        return decimal;
    }
}
