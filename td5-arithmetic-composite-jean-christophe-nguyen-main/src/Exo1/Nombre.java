package Exo1;

public class Nombre extends Expression{
    private final int valeur;

    public Nombre(int valeur){
        super(null,null);
        this.valeur=valeur;
    }

    @Override
    public double calculerValeur() {
        return valeur;
    }
}
