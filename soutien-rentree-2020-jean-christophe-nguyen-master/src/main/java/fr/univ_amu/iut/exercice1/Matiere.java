package java.fr.univ_amu.iut.exercice1;


public class Matiere {
    private String matiere;
    private double coeff;

    public Matiere(String matiere, double coeff) {
        this.matiere = matiere;
        this.coeff = coeff;
        if ( matiere == null || matiere.isEmpty()) {
            throw new IllegalArgumentException("L'intitulé d'une matière ne peut être vide");
        }
    }
     public String toString(){

        return "Matiere : "+matiere+", coeff="+coeff;
    }

    public String getMatiere() {
        return matiere;
    }

    public double getCoeff() {
        return coeff;
    }
}

