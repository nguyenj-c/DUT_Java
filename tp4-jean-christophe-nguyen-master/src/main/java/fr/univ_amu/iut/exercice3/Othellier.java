package fr.univ_amu.iut.exercice3;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;


public class Othellier extends GridPane {

    private static final Point2D[] directions = {
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(0, 1),
            new Point2D(-1, 1),
            new Point2D(-1, 0),
            new Point2D(-1, -1),
            new Point2D(0, -1),
            new Point2D(1, -1)
    };
    private final EventHandler<ActionEvent> caseListener = event -> {
        throw new RuntimeException("Not yet implemented !");
    };
    private int taille;
    private Case[][] cases;
    private ObjectProperty<Joueur> joueurCourant = new SimpleObjectProperty<>(Joueur.NOIR);

    public Othellier() {
        throw new RuntimeException("Not yet implemented !");
    }

    public ObjectProperty<Joueur> joueurCourantProperty() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void remplirOthelier(int taille) {
        throw new RuntimeException("Not yet implemented !");
    }

    private void adapterLesLignesEtColonnes() {
        for (int i = 0; i < taille; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            getColumnConstraints().add(column);
        }

        for (int i = 0; i < taille; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            getRowConstraints().add(row);
        }
    }

    private void positionnerPionsDebutPartie() {
        throw new RuntimeException("Not yet implemented !");
    }


    public void nouvellePartie() {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean peutJouer() {
        throw new RuntimeException("Not yet implemented !");
    }

    private List<Case> casesJouables() {
        throw new RuntimeException("Not yet implemented !");
    }

    private List<Case> casesCapturable(Case caseSelectionnee) {
        List<Case> casesCapturable = new ArrayList<>();

        for (Point2D direction : directions) {
            casesCapturable.addAll(casesCapturable(caseSelectionnee, direction));
        }

        return casesCapturable;
    }

    private List<Case> casesCapturable(Case caseSelectionnee, Point2D direction) {
        List<Case> casesCapturable = new ArrayList<>();

        int indiceLigne = caseSelectionnee.getLigne() + (int) direction.getY();
        int indiceColonne = caseSelectionnee.getColonne() + (int) direction.getX();

        while (estIndicesValides(indiceLigne, indiceColonne)) {
            if (cases[indiceLigne][indiceColonne].getPossesseur() != joueurCourant.get().suivant())
                break;

            casesCapturable.add(cases[indiceLigne][indiceColonne]);

            indiceLigne += direction.getY();
            indiceColonne += direction.getX();
        }

        if (estIndicesValides(indiceLigne, indiceColonne) &&
                cases[indiceLigne][indiceColonne].getPossesseur() == joueurCourant.get())
            return casesCapturable;
        return new ArrayList<>();
    }

    private boolean estIndicesValides(int indiceLigne, int indiceColonne) {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean estIndiceValide(int indiceColonne) {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean estPositionJouable(Case caseSelectionnee) {
        throw new RuntimeException("Not yet implemented !");
    }

    private void capturer(Case caseCapturee) {
        throw new RuntimeException("Not yet implemented !");
    }

    public Joueur getJoueurCourant() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void tourSuivant() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void vider() {
        throw new RuntimeException("Not yet implemented !");
    }
}
