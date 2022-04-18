package java.fr.univ_amu.iut.exercice7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setHeight(100);
        primaryStage.setWidth(250);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 100);
        Button btn = new Button();
        btn.setText("Hello !");
        root.setCenter(btn);
        btn.setId("buttonHello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
