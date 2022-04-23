package fr.univ_amu.iut.exercice13;

import fr.univ_amu.iut.exercice12.Palette;
import fr.univ_amu.iut.exercice12.TestPalette;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestBouncingBall {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TestBouncingBall.this.stage = new Stage(StageStyle.UNDECORATED);
                try {
                    FxToolkit.setupStage((sta) -> {
                        try {
                            new BouncingBall().start(TestBouncingBall.this.stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void should_initialize_stage_with_correct_title() { assertEquals("Bouncing Ball", stage.getTitle()); }

    @Test
    public void should_initialize_stage_with_height_of_100() { assertEquals(500, stage.getHeight()); }

    @Test
    public void should_initialize_stage_with_width_of_250() { assertEquals(500, stage.getWidth()); }
}