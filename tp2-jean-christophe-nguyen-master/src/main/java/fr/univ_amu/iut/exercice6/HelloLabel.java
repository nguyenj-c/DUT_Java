package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.*;

public class HelloLabel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        int width = 250;
        primaryStage.setHeight(100);
        primaryStage.setWidth(width);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, width, 100);
        Label label = new Label();
        label.setText("Hello !");
        root.setCenter(label);
        label.setId("labelHello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
