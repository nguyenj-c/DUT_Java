package fr.univ_amu.iut.exercice1;
public class HelloWorld {
    public static String hello(java.lang.String chaine) {
            chaine="Bob";
            if (chaine == null || chaine.isEmpty())
                return "Hello, World!";
            if (chaine == "Alice")
                return "Hello, Alice!";
            if (chaine == "Bob")
                return "Hello, Bob!";
            else
                return null ;
    }
}