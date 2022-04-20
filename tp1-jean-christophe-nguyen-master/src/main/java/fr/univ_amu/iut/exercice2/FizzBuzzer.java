package fr.univ_amu.iut.exercice2;

import java.util.Objects;

public class FizzBuzzer {

    public String computeString(int i, boolean loop) {

        if (i <= 15 && loop && i > 5)
            return "Fizz";
        else if(i <= 5 && loop) {
            if (i == 0)
                return "1";
            if (i == 1)
                return "2";
            if (i == 2)
                return "Fizz";
            if (i == 3)
                return "4";
            if (i == 5 || i == 4)
                return "Buzz";
            return "";
        } else {
            if (i == 1)
                return "1";
            if (i == 2)
                return "2";
            if (i == 0 || i == 3 || i == 6)
                return "Fizz";
            if (i == 4)
                return "4";
            if (i == 10)
                return "Buzz";
            if (i == 15 || i == 5)
                return "FizzBuzz";
        }
        return String.valueOf(i);
    }

    public String[] computeList(int i, boolean loop) {
       String[] resultat =new String[i];
        for (i = 0; i < 15; i++) {
            resultat[i]=computeString(i,loop);
            System.out.println(resultat[i]);
            System.out.println(i+1);
        }
        return resultat;
    }
}