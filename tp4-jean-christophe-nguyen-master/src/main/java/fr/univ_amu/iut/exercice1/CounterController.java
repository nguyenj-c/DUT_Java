package java.fr.univ_amu.iut.exercice1;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    IntegerProperty counter = new SimpleIntegerProperty(0);

    @FXML
    Label counterLabel;

    @FXML
    Button incrementButton;

    @FXML
    public void decrement(ActionEvent actionEvent) {
        counter.set(counter.get() - 1);
    }

    @FXML
    public void increment(ActionEvent actionEvent) {
        counter.set(counter.get() + 1);
    }

    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int counter) {
        this.counter.set(counter);
    }

    public IntegerProperty counterProperty() {
        return counter;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing SayHelloController...");
        System.out.println("Location = " + location);
        System.out.println("Resources = " + resources);
        counterLabel.textProperty().bind(counter.asString());
    }
}
