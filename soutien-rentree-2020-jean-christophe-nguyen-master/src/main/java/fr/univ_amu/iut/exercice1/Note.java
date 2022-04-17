package fr.univ_amu.iut.exercice1;


public class Note {
   private double note;
   private Matiere refmatiere;
    public Note(Matiere refmatiere, double note){
        this.refmatiere=refmatiere;
        this.note=note;
    }

    public double getNote() {
        return note;
    }

    public Matiere getRefmatiere() {
        return refmatiere;
    }

    public String toString(){

        return "Note "+refmatiere+": "+note;
    }
}
