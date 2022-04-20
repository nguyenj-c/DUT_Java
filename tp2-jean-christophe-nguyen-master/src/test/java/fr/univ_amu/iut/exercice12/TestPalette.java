package fr.univ_amu.iut.exercice12;

import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


@ExtendWith(ApplicationExtension.class)
public class TestPalette {

    @Start
    public void start(Stage stage) throws Exception {
        new Palette().start(stage);
    }

}