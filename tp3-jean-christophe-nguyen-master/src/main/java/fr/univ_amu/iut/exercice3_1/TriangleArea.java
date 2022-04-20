package fr.univ_amu.iut.exercice3_1;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import static java.lang.String.format;

public class TriangleArea {

    private final IntegerProperty x1 = new SimpleIntegerProperty(0);
    private final IntegerProperty y1 = new SimpleIntegerProperty(0);

    private final IntegerProperty x2 = new SimpleIntegerProperty(0);
    private final IntegerProperty y2 = new SimpleIntegerProperty(0);

    private final IntegerProperty x3 = new SimpleIntegerProperty(0);
    private final IntegerProperty y3 = new SimpleIntegerProperty(0);

    private NumberBinding area;

    private StringExpression output;

    public TriangleArea() {
        createBinding();
    }

    public static void main(String[] args) {
        TriangleArea triangleArea = new TriangleArea();

        triangleArea.printResult();

        triangleArea.setP1(0, 1);
        triangleArea.setP2(5, 0);
        triangleArea.setP3(4, 3);

        triangleArea.printResult();

        triangleArea.setP1(1, 0);
        triangleArea.setP2(2, 2);
        triangleArea.setP3(0, 1);

        triangleArea.printResult();
    }

    public void setP1(int x1, int y1) {
        this.x1.set(x1);
        this.y1.set(y1);
    }

    public void setP2(int x2, int y2) {
        this.x2.set(x2);
        this.y2.set(y2);
    }

    public void setP3(int x3, int y3) {
        this.x3.set(x3);
        this.y3.set(y3);
    }

    public double getArea() {
        return area.getValue().doubleValue();
    }

    void printResult() {
        //StringExpression output = Bindings.format("For P1(" + x1.get() + "," + y1.get() + "), P2(" + x2.get() + "," + y2.get() + "), P3(" + x3.get() + "," + y3.get() + "),"+" the area of triangle ABC is %.1f", area.divide(2.0));
        StringExpression output = Bindings.concat("For P1(" + x1.get() + "," + y1.get() + "), P2(" + x2.get() + "," + y2.get() + "), P3(" + x3.get() + "," + y3.get() + "),"+" the area of triangle ABC is ", area.divide(2.0));
        //System.out.println("For P1(" + x1.get() + "," + y1.get() + "), P2(" + x2.get() + "," + y2.get() + "), P3(" + x3.get() + "," + y3.get() + ")," + output);
        System.out.println(output.getValue());
    }

    private void createBinding() {
        area = x1.multiply(y2).subtract(x1.multiply(y3)).add(x2.multiply(y3)).subtract(x2.multiply(y1)).add(x3.multiply(y1)).subtract(x3.multiply(y2)).divide(2.0);
        area = Bindings.when(area.lessThan(0)).then(area.negate()).otherwise(area);
    }
}
