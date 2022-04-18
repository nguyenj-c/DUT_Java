package java.fr.univ_amu.iut.exercice2;

public class FizzBuzzer {

    public String computeString(int i) {
        if (i <=15)
            return "Fizz";
        /*if (i == 0)
            return "Fizz";
        if (i == 1)
            return "2";
        if (i == 2)
            return "Fizz";
        if (i == 3)
            return "4";
        if (i == 4)
            return "Buzz";
        if (i == 5)
            return "FizzBuzz";
        if (i == 6)
            return "Fizz";
        if (i == 10)
            return "Buzz";
        if (i == 15)
            return "FizzBuzz";*/
        return String.valueOf(i);
    }

    public String[] computeList(int i) {
       String[] resultat =new String[i];
        for (i = 0; i < 15; i++) {
            resultat[i]=computeString(i);
            System.out.println(resultat[i]);
            System.out.println(i+1);
        }
        return resultat;
    }
}