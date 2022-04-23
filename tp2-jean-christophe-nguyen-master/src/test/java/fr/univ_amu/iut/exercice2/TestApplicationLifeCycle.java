package fr.univ_amu.iut.exercice2;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.verify;

//@Disabled
@ExtendWith(ApplicationExtension.class)
public class TestApplicationLifeCycle {

    @Mock PrintStream out;

    @BeforeEach
    public void setUpClass() throws Exception {
        MockitoAnnotations.initMocks(this);
        System.setOut(out);
        ApplicationTest.launch(ApplicationLifeCycle.class);
    }

    @Start
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    @AfterEach
    public void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }
    //@Disabled
    @Test
    public void constructor() throws Exception {
        verify(out).println("constructeur ApplicationLifeCycle()");
    }

    //@Disabled
    @Test
    public void init() {
        verify(out).println("init()");
    }

    //@Disabled
    @Test
    public void test_stop() throws Exception {
        FxToolkit.setupApplication(ApplicationLifeCycle.class).stop();
        verify(out).println("stop()");
    }

    //@Disabled
    @Test
    public void test_life_cycle_output() {
        verify(out).println("constructeur ApplicationLifeCycle()");
        verify(out).println("start() : avant show stage");
        verify(out).println("start() : après show stage");
    }

}