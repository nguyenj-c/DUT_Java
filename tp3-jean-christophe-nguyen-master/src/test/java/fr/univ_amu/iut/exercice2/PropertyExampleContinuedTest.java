package java.fr.univ_amu.iut.exercice2;

import org.junit.jupiter.api.*;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

@Disabled
public class PropertyExampleContinuedTest {
    private PrintStream out;
    private PropertyExampleContinued propertyExample;

    @BeforeEach
    public void setUp() throws Exception {
        propertyExample = new PropertyExampleContinued();
        propertyExample.setAnInt(1024);
        out = mock(PrintStream.class);
        System.setOut(out);
    }


    @Test
    public void bindAndUnbindOnePropertyToAnother() throws Exception {
        propertyExample.bindAndUnbindOnePropertyToAnother();
        verify(out).println();
        verify(out).println("otherProperty.get() = 0");
        verify(out).println("Binding otherProperty to anIntProperty.");
        verify(out).println("otherProperty.get() = 1024");
        verify(out).println("Calling anIntProperty.set(7168).");
        verify(out, times(3)).println("otherProperty.get() = 7168");
        verify(out).println("Unbinding otherProperty from anIntProperty.");
        verify(out).println("Calling anIntProperty.set(8192).");
    }
}