package Exo1;

public abstract class Expression {
    protected final Expression premierOperande;
    protected final Expression deuxiemeOperande;

    public Expression(Expression premierOperande, Expression deuxiemeOperande) {
        this.premierOperande=premierOperande;
        this.deuxiemeOperande=deuxiemeOperande;
    }
    public abstract double calculerValeur() throws Exception;
}
