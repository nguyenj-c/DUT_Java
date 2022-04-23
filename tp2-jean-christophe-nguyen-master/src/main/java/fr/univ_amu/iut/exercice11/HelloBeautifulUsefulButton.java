package fr.univ_amu.iut.exercice11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.concurrent.Flow;

public class HelloBeautifulUsefulButton extends Application {
    private int nbAction = 0;

    EventHandler<ActionEvent> ecouteur2 = event -> {
        this.nbAction += 1;
        System.out.println("Bouton actionne " + this.nbAction + " fois");
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setHeight(250);
        primaryStage.setWidth(250);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 250);
        Button btn = new Button();
        btn.setText("Hello !");
        root.setCenter(btn);
        btn.setId("buttonHello");
        btn.setOnAction(ecouteur2);
        primaryStage.setScene(scene);
        primaryStage.show();
        ImageView view = new ImageView("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png");
        view.getImage();
        btn.setGraphic(view);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("DarkTheme.css").toExternalForm());
        primaryStage.show();

    }
}
