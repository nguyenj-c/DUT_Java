package java.fr.univ_amu.iut.exercice3_2;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TriangleArea {

    private IntegerProperty x1 = new SimpleIntegerProperty(0);
    private IntegerProperty y1 = new SimpleIntegerProperty(0);

    private IntegerProperty x2 = new SimpleIntegerProperty(0);
    private IntegerProperty y2 = new SimpleIntegerProperty(0);

    private IntegerProperty x3 = new SimpleIntegerProperty(0);
    private IntegerProperty y3 = new SimpleIntegerProperty(0);

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
        //System.out.println(Bindings.format("For P1("+x1.get()+","+y1.get()+"), P2("+x2.get()+","+y2.get()+"), P3("+x3.get()+","+y3.get()+"), the area of triangle ABC is %.1f", area.getValue().doubleValue()).get());
        System.out.println(Bindings.concat("For P1("+x1.get()+","+y1.get()+"), P2("+x2.get()+","+y2.get()+"), P3("+x3.get()+","+y3.get()+"), the area of triangle ABC is ", area.getValue().doubleValue()).get());
    }

    private void createBinding() {
        area = new DoubleBinding() {
            { super.bind(x1, x2, x3, y1, y2, y3); }
            @Override
            protected double computeValue() {
                double a=x1.get();
                double b=x2.get();
                double c=x3.get();
                double d=y1.get();
                double e=y2.get();
                double f=y3.get();
                return Math.abs(a * e - a * f + b * f - b * d + c * d - c * e) / 2.0;
            }
        };
    }
}
