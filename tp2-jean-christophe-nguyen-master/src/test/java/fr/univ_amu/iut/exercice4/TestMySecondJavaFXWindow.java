package java.fr.univ_amu.iut.exercice4;

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

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestMySecondJavaFXWindow {

    Stage stage;

    @BeforeEach
    public void setUpClass() throws Exception {
        ApplicationTest.launch(MySecondJavaFXWindow.class);
    }

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    @AfterEach
    public void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    @Disabled
    @Test
    public void should_initialize_stage_with_correct_title() {
        assertEquals("Second Useless JavaFX Window", stage.getTitle());
    }

    @Disabled
    @Test
    public void should_initialize_stage_is_always_on_top() {
        assertTrue(stage.alwaysOnTopProperty().get());
    }

    @Disabled
    @Test
    public void should_initialize_stage_is_not_resizable() {
        assertFalse(stage.resizableProperty().get());
    }

    @Disabled
    @Test
    public void should_initialize_stage_with_height_of_400() {
        assertEquals(400, stage.getHeight());
    }

    @Disabled
    @Test
    public void should_initialize_stage_with_width_of_800() {
        assertEquals(800, stage.getWidth());
    }

    @Disabled
    @Test
    public void should_initialize_stage_is_showing() {
        assertTrue(stage.isShowing());
    }

}
