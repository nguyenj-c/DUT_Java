package fr.univ_amu.iut.exercice1;


public class Main{

public static void main(String[] args) {
        //Matiere matiere = new Matiere("", 3.0);
        try {
        Matiere intitule = new Matiere(null, 3.0);
        } catch (IllegalArgumentException erreur) {
        System.out.println("Tout est sous contrôle" + erreur.getMessage());
        }

        Matiere IHM = new Matiere("IHM", 2.0);
        Note note=new Note(IHM,3.5);


        Matiere BD= new Matiere("BD",2);
        Note unNote= new Note(BD,12);

        Etudiant Anthony=new Etudiant("VVII");
        TableauDeNotes tabAnthony=new TableauDeNotes();

        tabAnthony.ajouter(note);
        tabAnthony.ajouter(unNote);

        Anthony.noter(BD,18);
        Anthony.noter(IHM,5);
        Anthony.listerNotes();
        }
}

