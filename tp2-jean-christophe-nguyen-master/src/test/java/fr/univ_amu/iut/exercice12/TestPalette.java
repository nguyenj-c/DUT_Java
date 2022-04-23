package fr.univ_amu.iut.exercice12;

import fr.univ_amu.iut.exercice10.HelloBeautifulUsefulButton;
import fr.univ_amu.iut.exercice10.TestHelloBeautifulUsefulButton;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testfx.api.FxAssert.verifyThat;


@ExtendWith(ApplicationExtension.class)
public class TestPalette {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TestPalette.this.stage = new Stage(StageStyle.UNDECORATED);
                try {
                    FxToolkit.setupStage((sta) -> {
                        try {
                            new Palette().start(TestPalette.this.stage);
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

    @AfterEach
    public void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    @Test
    public void should_initialize_stage_with_correct_title() { assertEquals("Palette", stage.getTitle()); }

    @Test
    public void should_initialize_stage_with_height_of_100() { assertEquals(400, stage.getHeight()); }

    @Test
    public void should_initialize_stage_with_width_of_250() { assertEquals(400, stage.getWidth()); }

}