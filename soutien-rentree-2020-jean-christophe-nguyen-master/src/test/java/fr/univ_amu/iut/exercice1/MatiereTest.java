package fr.univ_amu.iut.exercice1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatiereTest {


    @Test
    public void test_matiere_constructor_should_fail_with_null_name() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Matiere testMatiere = new Matiere(null, 3.0);
        });
        assertEquals(e.getMessage(), "L'intitulé d'une matière ne peut être vide");
    }


    @Test
    public void test_matiere_constructor_should_fail_with_empty_name() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Matiere testMatiere = new Matiere("", 3.0);
        });
        assertEquals(e.getMessage(), "L'intitulé d'une matière ne peut être vide");
    }



    @Test
    public void test_matiere_name_getter_with_IHM() {
        Matiere testMatiere = new Matiere("IHM", 2.0);
        assertEquals("IHM", testMatiere.getMatiere());
    }



    @Test
    public void test_matiere_pound_getter_with_15_2() {
        Matiere testMatiere = new Matiere("POO", 3.5);
        assertEquals(3.5, testMatiere.getCoeff());
    }

}

