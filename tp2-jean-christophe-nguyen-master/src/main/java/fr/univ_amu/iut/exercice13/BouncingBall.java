package fr.univ_amu.iut.exercice13;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Slider slider;
    private Circle circle;
    private VBox root;
    private HBox commands;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) {
        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        resumeButton = new Button("Resume");
        stopButton = new Button("Stop");

        commands = new HBox(5);
        commands.setPadding(new Insets(5));
        commands.getChildren().addAll(startButton, pauseButton, resumeButton, stopButton);

        slider = new Slider(0.1, 5, 1);
        slider.setPadding(new Insets(0, 5, 5, 5));

        VBox controls = new VBox(5);
        controls.getChildren().addAll(commands, slider);

        circle = new Circle(12);
        circle.setFill(Color.WHITE);

        pane = new Pane();
        pane.setPrefSize(500,500);
        pane.getChildren().add(circle);
        pane.setStyle("-fx-background-color: #555");

        root = new VBox();
        root.getChildren().addAll(controls, pane);

        stage.setScene(new Scene(root));
        stage.setTitle("Bouncing Ball");
        stage.setResizable(false);
        stage.show();

        setupTransition();
        setupListeners();
    }

    private void setupTransition() {
        transition = new TranslateTransition(Duration.seconds(1), circle);
        transition.setFromX(pane.getWidth() / 2);
        transition.setFromY(circle.getRadius() + 16);
        transition.setToY(pane.getHeight() - circle.getRadius());
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setInterpolator(Interpolator.EASE_IN);
        transition.setRate(0.5);
        transition.play();
    }

    private void setupListeners() {
        startButton.setOnAction(actionEvent -> transition.playFromStart());
        pauseButton.setOnAction(actionEvent -> transition.pause());
        resumeButton.setOnAction(actionEvent -> transition.play());
        stopButton.setOnAction(actionEvent -> transition.stop());

        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> transition.setRate(newValue.doubleValue())
        );
    }
}
