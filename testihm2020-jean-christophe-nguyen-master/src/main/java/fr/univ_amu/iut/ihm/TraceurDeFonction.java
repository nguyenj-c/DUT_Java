package fr.univ_amu.iut.ihm;

import fr.univ_amu.iut.utilitaires.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class TraceurDeFonction {

  void calculCoeffTransformationsAffines() {
  }
  	
  int transformationAffineY(double y) {
    return 0;
  }

  int transformationAffineX(double x) {
    return 0;
  }
  public void start(Stage stage) throws IOException, ErreurDeSyntaxe {
    stage.setTitle("Traceur de fonction");
    stage.setAlwaysOnTop(true);
    stage.setResizable(false);
    stage.setHeight(650);
    stage.setWidth(600);
    Label label=new Label("exp(-x * 0.2) * sin(x)");
    label.getText();
    System.out.println("Expression : exp(-x * 0.2) * sin(x)");
    Analyseur analyse=new Analyseur("exp(-x * 0.2) * sin(x)");
    analyse.analyser();
    if (analyse!=IOException){
      System.out.println("Expression analysée : f(x) = (exp(0.0 - ((x) * (0.2)))) * (sin(x))");
    }
    else{
      System.out.println("si : identificateur inconnu");
    }
    BorderPane root=new BorderPane();
    root.setStyle("-fx-background-color: white");
    Line axeX=new Line();
    Line axeY=new Line();
    TilePane axe=new TilePane();
    axe.setStyle("-fx-color: lightgrey");
    axe.setHgap(1/4);
    axe.setVgap(1/2);
    root.getChildren().addAll(axeX,axeY);
    //CalculateurPointsFonction;
    }
  private void setIds() {

/*      votreIdentificateur.setId("texteAAnalyser");
      votreIdentificateur.setId("resultatAnalyse");
      votreIdentificateur.setId("demandeAnalyser");
      votreIdentificateur.setId("demandeTracer");
      votreIdentificateur.setId("demandeEffacer");
      votreIdentificateur.setId("zoneTraceCourbe");
      votreIdentificateur.setId("choixXMin");
      votreIdentificateur.setId("choixXMax");
      votreIdentificateur.setId("choixEspacementX_v1");
      votreIdentificateur.setId("choixEspacementX_v2");
      votreIdentificateur.setId("choixEspacementY_v1");
      votreIdentificateur.setId("choixEspacementY_v2");
      votreIdentificateur.setId("choixCouleur");
      votreIdentificateur.setId("choixEpaisseur");
      votreIdentificateur.setId("segmentsATracer");
      votreIdentificateur.setId("quadrillage");
      votreIdentificateur.setId("axeX");
      votreIdentificateur.setId("axeY");*/
  }

}