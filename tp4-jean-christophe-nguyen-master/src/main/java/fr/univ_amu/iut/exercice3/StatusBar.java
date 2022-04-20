package fr.univ_amu.iut.exercice3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;


public class StatusBar extends BorderPane implements Initializable {
    private static final String MESSAGE_TOUR_NOIR = "Noir joue !";
    private static final String MESSAGE_TOUR_BLANC = "Blanc joue !";
    private static final String SCORE_NOIR = "Noir : ";
    private static final String SCORE_BLANC = "Blanc : ";
    private static final String MESSAGE_TOUR_FIN_PARTIE = "Partie Terminée";

    @FXML
    private Label messageScoreNoir;

    @FXML
    private Label messageScoreBlanc;

    @FXML
    private Label messageTourDeJeu;

    private ObjectProperty<Joueur> joueurCourant = new SimpleObjectProperty<>(Joueur.NOIR);

    public StatusBar() {
        throw new RuntimeException("Not yet implemented !");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new RuntimeException("Not yet implemented !");
    }

    private void createBinding() {
        throw new RuntimeException("Not yet implemented !");
    }

    public Joueur getJoueurCourant() {
        throw new RuntimeException("Not yet implemented !");
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        throw new RuntimeException("Not yet implemented !");
    }

    public ObjectProperty<Joueur> joueurCourantProperty() {
        throw new RuntimeException("Not yet implemented !");
    }


}
