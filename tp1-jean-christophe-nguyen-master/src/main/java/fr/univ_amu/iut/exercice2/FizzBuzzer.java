package fr.univ_amu.iut.exercice2;

import java.util.Objects;

public class FizzBuzzer {

    public String computeString(int i) {
        String s;

        if (i % 3 == 0 && i % 5 == 0)
            s = "FizzBuzz";
        else if (i % 3 == 0)
            s = "Fizz";
        else if (i % 5 == 0)
            s = "Buzz";
        else
            s = String.valueOf(i);
        return s;
    }

    public String[] computeList(int i) {
        String[] arr = new String[i];

        for (int j = 0; j < i; ++j)
            arr[j] = computeString(j+1);

        return arr;
    }
}