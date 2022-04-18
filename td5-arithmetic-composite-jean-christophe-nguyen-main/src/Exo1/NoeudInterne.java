package Exo1;

public class NoeudInterne extends Expression{
    private final char operateurBinaire;

    public NoeudInterne(Expression premierOperande, Expression deuxiemeOperande, char operateurBinaire){
        super(premierOperande, deuxiemeOperande);
        this.operateurBinaire= operateurBinaire;
    }

    @Override
    public double calculerValeur() throws Exception {
        return switch (operateurBinaire) {
            case '+' -> premierOperande.calculerValeur() + deuxiemeOperande.calculerValeur();
            case '-' -> premierOperande.calculerValeur() - deuxiemeOperande.calculerValeur();
            case '/' -> premierOperande.calculerValeur() / deuxiemeOperande.calculerValeur();
            case '*' -> premierOperande.calculerValeur() * deuxiemeOperande.calculerValeur();
            default -> throw new Exception("Opérateur inconnue" + operateurBinaire);
        };
    }
}
