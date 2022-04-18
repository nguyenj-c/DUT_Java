package java.fr.univ_amu.iut.exercice7;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import static javafx.beans.binding.Bindings.when;

public class Ball {

    private final DoubleProperty positionX;
    private final DoubleProperty positionY;
    private final DoubleProperty velocityX; //en pixel par nanosecond
    private final DoubleProperty velocityY; //en pixel par nanosecond
    private final DoubleProperty radius;
    private final Pane parent;
    private Circle ball;

    private BooleanExpression isBouncingOffVerticalWall;
    private BooleanExpression isBouncingOffHorizontalWall;

    private NumberBinding bounceOffVerticalWall;
    private NumberBinding bounceOffHorizontalWall;

    public Ball(Pane parent) {
        this.parent = parent;
        positionX = new SimpleDoubleProperty(100);
        positionY = new SimpleDoubleProperty(100);
        radius = new SimpleDoubleProperty(20);
        velocityX = new SimpleDoubleProperty(150e-9);
        velocityY = new SimpleDoubleProperty(100e-9);
        ball = new Circle();
        parent.getChildren().add(ball);
        createBindings();
    }

    private void createBindings() {
        ball.radiusProperty().bind(radius);
        ball.centerXProperty().bind(positionX);
        ball.centerYProperty().bind(positionY);
        isBouncingOffHorizontalWall = Bindings.or(positionX.add(radius).greaterThan(parent.widthProperty()),
                positionX.lessThan(radius));
        isBouncingOffVerticalWall = Bindings.or(positionY.add(radius).greaterThan(parent.heightProperty()),
                positionY.lessThan(radius));
    }

    public void move(long elapsedTimeInNanoseconds) {
        if (isBouncingOffHorizontalWall.getValue()) {
            velocityX.setValue(velocityX.negate().getValue());
        } else if (isBouncingOffVerticalWall.getValue()) {
            velocityY.setValue(velocityY.negate().getValue());
        }
        positionX.setValue(positionX.getValue() + (velocityX.get()*elapsedTimeInNanoseconds));
        positionY.setValue(positionY.getValue() + (velocityY.get()*elapsedTimeInNanoseconds));
    }
}
