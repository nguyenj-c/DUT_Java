package fr.univ_amu.iut.exercice1;


public class Etudiant {

    public String nom;
    private TableauDeNotes tableau;
    public Etudiant(String nom) {
        this.nom = nom;
        tableau= new TableauDeNotes();
    }

    public void noter(Matiere matiere, double valeur) {
        Note note = new Note(matiere, valeur);
        tableau.ajouter(note);
    }

    public void listerNotes() {
        System.out.println(nom);
        for (int i = 0; i < tableau.size(); ++i) {
            System.out.println(tableau.get(i)+"\n");
        }
    }
}