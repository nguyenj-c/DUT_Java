package fr.univ_amu.iut.exercice3;

import javafx.application.Application;
import javafx.stage.Stage;

public class WhoIsWho extends Application {

    public WhoIsWho() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + " constructeur WhoIsWho()");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("[" + Thread.currentThread().getName() + "]" + " init()");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("[" + Thread.currentThread().getName() + "]" + " stop()");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WhoIsWho");
        System.out.println("[" + Thread.currentThread().getName() + "]" + " start() : avant show stage");
        primaryStage.show();
        System.out.println("[" + Thread.currentThread().getName() + "]" + " start() : après show stage");
    }
}
