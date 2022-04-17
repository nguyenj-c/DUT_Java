package fr.univ_amu.iut.exercice2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzzer fizzBuzz = new FizzBuzzer();

    @Disabled
    @Test
    public void test_computeString_Should_Return_1_when_1() {
        String resultat = fizzBuzz.computeString(1);
        assertEquals("1", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_2_when_2() {
        String resultat = fizzBuzz.computeString(2);
        assertEquals("2", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_Fizz_when_3() {
        String resultat = fizzBuzz.computeString(3);
        assertEquals("Fizz", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_4_when_4() {
        String resultat = fizzBuzz.computeString(4);
        assertEquals("4", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_Buzz_when_5() {
        String buzz = "Buzz";
        String resultat = fizzBuzz.computeString(5);
        assertEquals("Buzz", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_Fizz_when_6() {
        String resultat = fizzBuzz.computeString(6);
        assertEquals("Fizz", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_Fizz_when_9() {
        String resultat = fizzBuzz.computeString(9);
        assertEquals("Fizz", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_Buzz_when_10() {
        String resultat = fizzBuzz.computeString(10);
        assertEquals("Buzz", resultat);
    }

    @Disabled
    @Test
    public void test_computeString_Should_Return_FizzBuzz_when_15() {
        String resultat = fizzBuzz.computeString(15);
        assertEquals("FizzBuzz", resultat);
    }

    @Disabled
    @Test
    public void test_computeList_Should_Return_a_sequence_of_5_elements_when_5() {
        String[] resultat = fizzBuzz.computeList(5);
        assertEquals(5, resultat.length);
    }

    @Disabled
    @Test
    public void test_computeList_Should_Return_a_sequence_of_5_FizzBuzz_elements_when_5() {
        String[] resultat = fizzBuzz.computeList(5);
        assertEquals("1", resultat[0]);
        assertEquals("2", resultat[1]);
        assertEquals("Fizz", resultat[2]);
        assertEquals("4", resultat[3]);
        assertEquals("Buzz", resultat[4]);
    }

    @Disabled
    @Test
    public void test_computeList_Should_Return_a_sequence_of_15_FizzBuzz_elements_when_15() {
        String[] resultat = fizzBuzz.computeList(15);
        int i = 0;
        for (String number : resultat) {
            assertEquals(fizzBuzz.computeString(i + 1), resultat[i]);
            i++;
        }
    }
}
