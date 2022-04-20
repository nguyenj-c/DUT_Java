package fr.univ_amu.iut.exercice1;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestMyFirstJavaFXWindow {

    Stage stage;

    @BeforeEach
    public void setUpClass() throws Exception {
        ApplicationTest.launch(MyFirstJavaFXWindow.class);
    }

    @Start
    public void onStart(Stage stage) throws Exception {
        this.stage = stage;
    }

    @AfterEach
    public void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    @Test
    public void should_initialize_stage_with_correct_title() {
        assertEquals("A Useless JavaFX Window", stage.getTitle());
    }

}
