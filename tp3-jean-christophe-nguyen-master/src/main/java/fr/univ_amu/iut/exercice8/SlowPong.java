package fr.univ_amu.iut.exercice8;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SlowPong extends Application {

    private BooleanProperty startVisible = new SimpleBooleanProperty(true);
    private Ball ball;
    private Pane pongPane;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Button startButton;
    private AnimationTimer pongAnimation;

    private BooleanExpression isBouncingOffVerticalWall;
    private BooleanExpression isBouncingOffHorizontalWall;

    @Override
    public void start(Stage stage) {
        pongAnimation = createAnimation();

        ball = new Ball();

        leftPaddle = new Paddle(10);
        rightPaddle = new Paddle(470);

        startButton = createStartButton();
        pongPane = createPongPane();

        configureStage(stage);

        createBindings();
    }

    private void configureStage(Stage stage) {
        throw new RuntimeException("Not yet implemented !");
    }

    private Pane createPongPane() {
        throw new RuntimeException("Not yet implemented !");
    }

    private Button createStartButton() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void createBindings() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void updatePong(long elapsedTimeInNanoseconds) {
        checkBouncing();
        moveBall(elapsedTimeInNanoseconds);
    }

    private boolean isBouncingOffPaddles() {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean isBouncingOffLeftPaddle() {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean isBouncingOffRightPaddle() {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean isBouncingOffVerticalWall() {
        throw new RuntimeException("Not yet implemented !");
    }

    private boolean isBouncingOffHorizontalWall() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void checkBouncing() {
        throw new RuntimeException("Not yet implemented !");
    }

    private void moveBall(long elapsedTimeInNanoseconds) {
        throw new RuntimeException("Not yet implemented !");
    }

    private void startNewGame() {
        throw new RuntimeException("Not yet implemented !");
    }

    private AnimationTimer createAnimation() {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);

        return new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() > 0) {
                    long elapsedTimeInNanoseconds = timestamp - lastUpdateTime.get();
                    updatePong(elapsedTimeInNanoseconds);
                }
                lastUpdateTime.set(timestamp);
            }

            @Override
            public void start() {
                lastUpdateTime.set(System.nanoTime());
                startVisible.set(false);
                super.start();
            }

            @Override
            public void stop() {
                lastUpdateTime.set(System.nanoTime());
                startVisible.set(true);
                super.stop();
            }
        };
    }
}