package java.fr.univ_amu.iut.exercice5;

import java.fr.univ_amu.iut.exercice3.TriangleArea;
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class TriangleAreaCalculatorAndDrawer extends Application {
    private TriangleArea triangleArea = new TriangleArea();

    private Slider x1Slider = new Slider(0, 10, 0);
    private Slider x2Slider = new Slider(0, 10, 0);
    private Slider x3Slider = new Slider(0, 10, 0);

    private Slider y1Slider = new Slider(0, 10, 0);
    private Slider y2Slider = new Slider(0, 10, 0);
    private Slider y3Slider = new Slider(0, 10, 0);

    private Label p1Label = new Label("P1");
    private Label p2Label = new Label("P2");
    private Label p3Label = new Label("P3");

    private Label x1Label = new Label("X1 :");
    private Label x2Label = new Label("X2 :");
    private Label x3Label = new Label("X3 :");

    private Label y1Label = new Label("Y1 :");
    private Label y2Label = new Label("Y2 :");
    private Label y3Label = new Label("Y3 :");

    private Label areaLabel = new Label("Area :");
    private TextField areaTextField = new TextField();

    private Line p1p2 = new Line();
    private Line p2p3 = new Line();
    private Line p3p1 = new Line();

    private Pane drawPane = new Pane();

    private GridPane root = new GridPane();

    DoubleProperty x1 = x1Slider.valueProperty();
    DoubleProperty x2 = x2Slider.valueProperty();
    DoubleProperty x3 = x3Slider.valueProperty();
    DoubleProperty y1 = y1Slider.valueProperty();
    DoubleProperty y2 = y2Slider.valueProperty();
    DoubleProperty y3 = y3Slider.valueProperty();

    @Override
    public void start(Stage stage) throws Exception {
        configGridPane();
        configSliders();
        addSliders();
        addArea();
        addPointLabels();
        addDrawPane();
        createBinding();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Triangle Area Calculator");
        stage.show();
    }

    private void configSliders() {
        configSlider(x1Slider);
        configSlider(y1Slider);
        configSlider(x2Slider);
        configSlider(y2Slider);
        configSlider(x3Slider);
        configSlider(y3Slider);
    }

    private void addDrawPane() {
        drawPane.setPrefSize(500, 500);
        drawPane.setStyle("-fx-background-color: #ddd");
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                new Double[]{
                        50 * x1.get(), 50 * y1.get(),
                        50 * x2.get(), 50 * y2.get(),
                        50 * x3.get(), 50 * y3.get()
                });
        drawPane.getChildren().add(triangle);
        x1.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(0, 50 * newV.doubleValue())
        );
        y1.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(1, 50 * newV.doubleValue())
        );
        x2.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(2, 50 * newV.doubleValue())
        );
        y2.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(3, 50 * newV.doubleValue())
        );
        x3.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(4, 50 * newV.doubleValue())
        );
        y3.addListener(
                (obs, oldV, newV) -> triangle.getPoints().set(5, 50 * newV.doubleValue())
        );
    }

    private void configSlider(Slider slider) {
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMinorTickCount(4);
        slider.setMajorTickUnit(5);
        slider.setSnapToTicks(true);
        slider.setPrefWidth(300);
        slider.valueProperty().addListener((obs, oldVal, newVal) -> { slider.valueProperty().set(Math.round(slider.valueProperty().doubleValue())); }
        );
    }

    private void configGridPane() {
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        root.setPadding(new Insets(10));
        root.setPrefSize(700, 700);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMaxWidth(50);
        col1.setMinWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(80);
        root.getColumnConstraints().addAll(col1,col2);
        root.add(drawPane, 0, 10,2 , 10);
    }

    private void addArea() {
        root.add(areaLabel, 0, 9);
        root.add(areaTextField, 1, 9);
    }

    private void addSliders() {

        root.add(x1Label, 0, 1);
        root.add(x1Slider, 1, 1);
        root.add(y1Label, 0, 2);
        root.add(y1Slider, 1, 2);

        root.add(x2Label, 0, 4);
        root.add(x2Slider, 1, 4);
        root.add(y2Label, 0, 5);
        root.add(y2Slider, 1, 5);

        root.add(x3Label, 0, 7);
        root.add(x3Slider, 1, 7);
        root.add(y3Label, 0, 8);
        root.add(y3Slider, 1, 8);
    }

    private void addPointLabels() {
        root.add(new Label("P1"), 0, 0);
        root.add(new Label("P2"), 0, 3);
        root.add(new Label("P3"), 0, 6);
    }
    private void createBinding() {
        StringBinding area = new StringBinding() {
            {
                super.bind(x1, x2, x3, y1, y2, y3);
            }

            @Override
            protected String computeValue() {
                return String.format("%.2f", Math.abs(x1.get() * y2.get() - x1.get() * y3.get() + x2.get() * y3.get() - x2.get() * y1.get()
                        + x3.get() * y1.get() - x3.get() * y2.get()) / 2.0);
            }
        };
        areaTextField.textProperty().bind(area);
    }
}
