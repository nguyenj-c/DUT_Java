package java.fr.univ_amu.iut.exercice9;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EcouteurSimple implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = new Button();
        System.out.println("Bouton actionné");
    }
}
