package fr.univ_amu.iut.utilitaires;

import java.util.ArrayList;

public class CalculateurPointsFonction {

  private static final int nombrePas = 1000;

  private ArrayList<Basic2DPoint> listePoints;
  private double yMin, yMax;
  private double xMin, xMax;

  public CalculateurPointsFonction(Expression f, double xMin, double xMax) {

    listePoints = new ArrayList<>();

    double dx = (xMax - xMin) / nombrePas;
    yMin = f.valeur(xMin);
    yMax = yMin;

    for (double x = xMin; x <= xMax; x += dx) {
      double y = f.valeur(x);
      listePoints.add(new Basic2DPoint(x, y));
      yMin = Math.min(y, yMin);
      yMax = Math.max(y, yMax);
    }
  }

  public double getYMax() {
    return yMax;
  }

  public double getYMin() {
    return yMin;
  }

  public double getXMax() {
    return xMax;
  }

  public double getXMin() {
    return xMin;
  }

  public ArrayList<Basic2DPoint> getListePoints() {
    return listePoints;
  }

  public static void main() {
    Analyseur analyse=new Analyseur("exp(-x * 0.2) * sin(x)");
    System.out.println(analyse);
    Expression f = null;
    new CalculateurPointsFonction(f,5,20);
    TestExpression.main();


  }

}
