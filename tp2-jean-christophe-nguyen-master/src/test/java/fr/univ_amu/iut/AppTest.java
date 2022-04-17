package fr.univ_amu.iut;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@Disabled
@ExtendWith(ApplicationExtension.class)
public class AppTest extends ApplicationTest {

    @Test
    public void should_initialize_button_with_text_click() {
        verifyThat("#buttonClick", hasText("Click !"));
    }

    @Test
    public void should_increment_nbClick_when_click_on_button() {
        clickOn("#buttonClick");
        verifyThat("#buttonClick", hasText("1"));
    }

    @Test
    public void should_increment_nbClick_when_click_on_button_again() {
        clickOn("#buttonClick").clickOn("#buttonClick");
        verifyThat("#buttonClick", hasText("2"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new App().start(primaryStage);
    }
}
