package fr.univ_amu.iut.exercice13;

import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestBouncingBall {

    @Start
    public void start(Stage stage) throws Exception {
        new BouncingBall().start(stage);
    }

}