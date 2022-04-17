package fr.univ_amu.iut.exercice8;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {
    private DoubleProperty paddleY = new SimpleDoubleProperty();

    private double initPaddleTranslateY;
    private double paddleDragAnchorY;

    public Paddle(double x) {
        throw new RuntimeException("Not yet implemented !");
    }
}
