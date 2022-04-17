package fr.univ_amu.iut.exercice7;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BouncingBall extends Application {

    private Ball ball;
    private BorderPane root;

    private HBox commands;
    private Pane pane;

    private AnimationTimer animation;

    private void initialize() {
        pane = createBouncingBallPane();
        animation = createAnimation();
        commands = createCommandsPane();
        root = createRootPane();
    }

    private BorderPane createRootPane() {
        BorderPane root = new BorderPane();
        BorderPane.setMargin(commands, new Insets(20, 20, 20, 20));
        root.setTop(commands);
        root.setCenter(pane);
        return root;
    }

    private Pane createBouncingBallPane() {
        Pane pane = new Pane();
        pane.setPrefHeight(500);
        pane.setPrefWidth(500);
        ball = new Ball(pane);
        return pane;
    }

    private AnimationTimer createAnimation() {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);

        return new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() > 0) {
                    long elapsedTime = timestamp - lastUpdateTime.get();
                    ball.move(elapsedTime);
                }
                lastUpdateTime.set(timestamp);
            }

            @Override
            public void start() {
                lastUpdateTime.set(System.nanoTime());
                super.start();
            }

            @Override
            public void stop() {
                lastUpdateTime.set(System.nanoTime());
                super.stop();
            }
        };
    }

    private HBox createCommandsPane() {
        return new HBox(10) {
            private Button startButton;
            private Button stopButton;

            {
                startButton = new Button("Start");
                startButton.setOnAction(e -> animation.start());

                stopButton = new Button("Stop");
                stopButton.setOnAction(e -> animation.stop());

                getChildren().addAll(startButton, stopButton);

                setAlignment(Pos.CENTER);
            }
        };
    }

    @Override
    public void start(Stage stage) {
        initialize();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BouncingBall");
        stage.show();
    }
}