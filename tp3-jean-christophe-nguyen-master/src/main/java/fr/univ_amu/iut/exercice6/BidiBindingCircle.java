package java.fr.univ_amu.iut.exercice6;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class BidiBindingCircle extends Application {

    private Circle c = new Circle();
    private Slider slider = new Slider(0,250,0);
    private TextField textField = new TextField();

    private Pane pane = new Pane();
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root);

    @Override
    public void start(Stage stage) throws Exception {
        addPane();
        addSlider();
        addTextField();
        createBindings();
        configStage(stage);
        centercircle();
    }

    private void addTextField() {
        textField.setTextFormatter(new TextFormatter<String>(change -> {
            change.setText(change.getText().replace(',', '.'));
            String content = change.getControlNewText();
            if (content.isEmpty() || Double.parseDouble(content) > 250)
                change.setText("");
            return change;
        }));

        root.setBottom(textField);
    }

    private void createBindings() {

        slider.valueProperty().bindBidirectional(c.radiusProperty());
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.when(textField.textProperty().isEqualTo(""))
                .then("1");
        Bindings.when(textField.textProperty().isEqualTo("0"))
                .then("1");
        Bindings.bindBidirectional(textField.textProperty(), c.radiusProperty(), converter);
    }

    private void configStage(Stage stage) {

        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("BidiBindingCircle");
        stage.show();
    }

    private void addSlider() {
        slider.setPadding(new Insets(10));
        root.setTop(slider);
    }

    private void centercircle() {
        c.setRadius(150);
        c.setCenterX(pane.widthProperty().get() / 2);
        c.setCenterY(pane.heightProperty().get() / 2);
    }

    private void addPane() {
        pane.setPrefWidth(500);
        pane.setPrefHeight(500);
        pane.getChildren().add(c);
        root.setCenter(pane);
    }
}
