package fr.univ_amu.iut.exercice6;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static fr.univ_amu.iut.exercice6.ArgsException.ErrorCode.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {

    @Disabled
    @Test
    public void testCreateWithNoSchemaOrArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    @Disabled
    @Test
    public void testWithNoSchemaButWithOneArgument() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("", new String[]{"-x"}));
        assertEquals(UNEXPECTED_ARGUMENT, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testWithNoSchemaButWithMultipleArguments() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("", new String[]{"-x", "-y"}));
        assertEquals(UNEXPECTED_ARGUMENT, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testNonLetterSchema() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("*", new String[]{}));
        assertEquals(INVALID_ARGUMENT_NAME, e.getErrorCode());
        assertEquals('*', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testInvalidArgumentFormat() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("f~", new String[]{}));
        assertEquals(INVALID_ARGUMENT_FORMAT, e.getErrorCode());
        assertEquals('f', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testSimpleBooleanPresent() throws Exception {
        Args args = new Args("x", new String[]{"-x"});
        assertEquals(true, args.getBoolean('x'));
        assertEquals(1, args.cardinality());
    }

    @Disabled
    @Test
    public void testSimpleStringPresent() throws Exception {
        Args args = new Args("x*", new String[]{"-x", "param"});
        assertTrue(args.has('x'));
        assertEquals("param", args.getString('x'));
        assertEquals(1, args.cardinality());
    }

    @Disabled
    @Test
    public void testMissingStringArgument() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("x*", new String[]{"-x"}));
        assertEquals(MISSING_STRING, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testSpacesInFormat() throws Exception {
        Args args = new Args("x, y", new String[]{"-xy"});
        assertTrue(args.has('x'));
        assertTrue(args.has('y'));
        assertEquals(2, args.cardinality());
    }

    @Disabled
    @Test
    public void testSimpleIntPresent() throws Exception {
        Args args = new Args("x#", new String[]{"-x", "42"});
        assertTrue(args.has('x'));
        assertEquals(42, args.getInt('x'));
        assertEquals(1, args.cardinality());
    }

    @Disabled
    @Test
    public void testInvalidInteger() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("x#", new String[]{"-x", "Forty two"}));
        assertEquals(INVALID_INTEGER, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
        assertEquals("Forty two", e.getErrorParameter());
    }

    @Disabled
    @Test
    public void testMissingInteger() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("x#", new String[]{"-x"}));
        assertEquals(MISSING_INTEGER, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testSimpleDoublePresent() throws Exception {
        Args args = new Args("x##", new String[]{"-x", "42.3"});
        assertTrue(args.has('x'));
        assertEquals(42.3, args.getDouble('x'), .001);
    }

    @Disabled
    @Test
    public void testInvalidDouble() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("x##", new String[]{"-x", "Forty two"}));
        assertEquals(INVALID_DOUBLE, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
        assertEquals("Forty two", e.getErrorParameter());
    }

    @Disabled
    @Test
    public void testMissingDouble() throws Exception {
        ArgsException e = assertThrows(ArgsException.class,
                () -> new Args("x##", new String[]{"-x"}));
        assertEquals(MISSING_DOUBLE, e.getErrorCode());
        assertEquals('x', e.getErrorArgumentId());
    }

    @Disabled
    @Test
    public void testExtraArguments() throws Exception {
        Args args = new Args("x,y*", new String[]{"-x", "-y", "alpha", "beta"});
        assertTrue(args.getBoolean('x'));
        assertEquals("alpha", args.getString('y'));
        assertEquals(2, args.cardinality());
    }

    @Disabled
    @Test
    public void testExtraArgumentsThatLookLikeFlags() throws Exception {
        Args args = new Args("x,y*", new String[]{"-x", "alpha", "-y", "beta"});
        assertTrue(args.has('x'));
        assertTrue(args.getBoolean('x'));
        assertTrue(args.has('y'));
        assertEquals("beta", args.getString('y'));
        assertEquals(2, args.cardinality());
    }
}
