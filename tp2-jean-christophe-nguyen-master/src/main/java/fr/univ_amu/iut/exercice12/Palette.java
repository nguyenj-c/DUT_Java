package fr.univ_amu.iut.exercice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.text.Font.font;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label label=new Label();

    private Button vert=new Button("Vert");
    private Button rouge=new Button("Rouge");
    private Button bleu=new Button("Bleu");

    private BorderPane root=new BorderPane();
    private HBox haut=new HBox(10);
    private Pane panneau=new Pane();
    private HBox bas=new HBox(5);

    EventHandler<ActionEvent> ecouteurbleu = event -> {
        label.setText("Le bouton bleu a ete clique "+ ++nbBleu+" fois");
        panneau.setStyle("-fx-background-color: blue");
    };
    EventHandler<ActionEvent> ecouteurvert = event -> {
        label.setText("Le bouton vert a ete clique "+ ++nbVert+" fois");
        panneau.setStyle("-fx-background-color: green");
    };
    EventHandler<ActionEvent> ecouteurrouge = event -> {
        label.setText("Le bouton rouge a ete clique "+ ++nbRouge+" fois");
        panneau.setStyle("-fx-background-color: red");
    };


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Palette");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        Scene scene= new Scene(root, 400,400);
        primaryStage.setScene(scene);
        panneau.setPrefSize(400,200);
        bas.setAlignment(Pos.CENTER);
        haut.setAlignment(Pos.CENTER);
        vert.setVisible(true);
        vert.setId("btnVert");
        bleu.setVisible(true);
        bleu.setId("btnBleu");
        rouge.setVisible(true);
        rouge.setId("btnRouge");
        bleu.setOnAction(ecouteurbleu);
        vert.setOnAction(ecouteurvert);
        rouge.setOnAction(ecouteurrouge);
        root.setTop(haut);
        root.setBottom(bas);
        root.setCenter(panneau);
        haut.setPadding(new Insets(10));
        bas.setPadding(new Insets(5,0,0,5));
        label.setFont(Font.font("Tahoma",20));
        haut.getChildren().addAll(vert,bleu,rouge);
        bas.getChildren().add(0,label);
        primaryStage.show();
    }
}