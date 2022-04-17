package fr.univ_amu.iut.exercice1;

public class MoyenneArithmetique {
    public void calculer(TableauDeNotes tableau){
        double decimal;
        for(int i=0; i<tableau.size();++i){
            decimal+=tableau.get(i);

        }

        return decimal;
    }
}
