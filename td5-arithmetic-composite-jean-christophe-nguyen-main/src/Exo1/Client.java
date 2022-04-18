package Exo1;

public class Client {
    public static void main(String arg[]) throws Exception {
        Expression exp= new NoeudInterne(new NoeudInterne(new Nombre(2), new Nombre(3),'*'),new Nombre(5),'+');
        System.out.println("Résultat: " + exp.calculerValeur());
    }
}

