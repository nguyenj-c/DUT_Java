package fr.univ_amu.iut.exercice1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class PropertyExampleTest {

    @Mock PrintStream out;
    private PropertyExample propertyExample;

    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        System.setOut(out);
        propertyExample = new PropertyExample();
        propertyExample.setAnInt(1024);
    }


    @Test
    public void createProperty() throws Exception {
        propertyExample.createProperty();

        verify(out).println();
        verify(out).println("anIntProperty = IntegerProperty [value: 1024]");
        verify(out).println("anIntProperty.get() = 1024");
        verify(out).println("anIntProperty.getValue() = 1024");
    }


    @Test
    public void addAndRemoveInvalidationListener() throws Exception {

        propertyExample.addAndRemoveInvalidationListener();

        verify(out).println();
        verify(out).println("Add invalidation listener.");
        verify(out).println("setValue() with 1024.");
        verify(out).println("set() with 2105.");
        verify(out).println("The observable has been invalidated.");
        verify(out).println("setValue() with 5012.");
        verify(out).println("Remove invalidation listener.");
        verify(out).println("set() with 1024.");
    }


    @Test
    public void addAndRemoveChangeListener() throws Exception {

        propertyExample.addAndRemoveChangeListener();

        verify(out).println();
        verify(out).println("Add change listener.");
        verify(out).println("setValue() with 1024.");
        verify(out).println("set() with 2105.");
        verify(out).println("The observableValue has changed: oldValue = 1024, newValue = 2105");
        verify(out).println("setValue() with 5012.");
        verify(out).println("The observableValue has changed: oldValue = 2105, newValue = 5012");
        verify(out).println("Remove change listener.");
        verify(out).println("set() with 1024.");
    }

}
