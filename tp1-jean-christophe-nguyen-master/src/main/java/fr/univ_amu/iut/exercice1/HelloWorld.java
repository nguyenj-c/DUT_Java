package fr.univ_amu.iut.exercice1;
import java.lang.String;
public class HelloWorld {
    public static String hello(String chaine) {
            if (chaine == null || chaine.isEmpty())
                return "Hello, World!";
            if (chaine.equals("Alice"))
                return "Hello, Alice!";
            if (chaine.equals("Bob"))
                return "Hello, Bob!";
            else
                return null ;
    }
}