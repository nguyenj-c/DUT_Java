package fr.univ_amu.iut.exercice5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class MinesweeperBoardTest {

    @Disabled
    @Test
    public void test_Input_Board_With_No_Rows_And_No_Columns() {
        final List<String> inputBoard = Collections.emptyList();
        final List<String> expectedAnnotatedRepresentation = Collections.emptyList();
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();

        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_One_Row_And_No_Columns() {
        final List<String> inputBoard = Collections.singletonList("");
        final List<String> expectedAnnotatedRepresentation = Collections.singletonList("");
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_No_Mines() {
        final List<String> inputBoard = Arrays.asList(
                "   ",
                "   ",
                "   "
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "   ",
                "   ",
                "   "
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Only_Mines() {
        final List<String> inputBoard = Arrays.asList(
                "***",
                "***",
                "***"
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "***",
                "***",
                "***"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Single_Mine_At_Center() {
        final List<String> inputBoard = Arrays.asList(
                "   ",
                " * ",
                "   "
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "111",
                "1*1",
                "111"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Mines_Around_Perimeter() {
        final List<String> inputBoard = Arrays.asList(
                "***",
                "* *",
                "***"
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "***",
                "*8*",
                "***"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Single_Row_And_Two_Mines() {
        final List<String> inputBoard = Collections.singletonList(
                " * * "
        );
        final List<String> expectedAnnotatedRepresentation = Collections.singletonList(
                "1*2*1"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Single_Row_And_Two_Mines_At_Edges() {
        final List<String> inputBoard = Collections.singletonList(
                "*   *"
        );
        final List<String> expectedAnnotatedRepresentation = Collections.singletonList(
                "*1 1*"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Single_Column_And_Two_Mines() {
        final List<String> inputBoard = Arrays.asList(
                " ",
                "*",
                " ",
                "*",
                " "
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "1",
                "*",
                "2",
                "*",
                "1"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Single_Column_And_Two_Mines_At_Edges() {
        final List<String> inputBoard = Arrays.asList(
                "*",
                " ",
                " ",
                " ",
                "*"
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "*",
                "1",
                " ",
                "1",
                "*"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Mines_In_Cross() {
        final List<String> inputBoard = Arrays.asList(
                "  *  ",
                "  *  ",
                "*****",
                "  *  ",
                "  *  "
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                " 2*2 ",
                "25*52",
                "*****",
                "25*52",
                " 2*2 "
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Large_Input_Board() {
        final List<String> inputBoard = Arrays.asList(
                " *  * ",
                "  *   ",
                "    * ",
                "   * *",
                " *  * ",
                "      "
        );
        final List<String> expectedAnnotatedRepresentation = Arrays.asList(
                "1*22*1",
                "12*322",
                " 123*2",
                "112*4*",
                "1*22*2",
                "111111"
        );
        final List<String> actualAnnotatedRepresentation
                = new MinesweeperBoard(inputBoard).getAnnotatedRepresentation();
        assertEquals(expectedAnnotatedRepresentation, actualAnnotatedRepresentation);
    }

    @Disabled
    @Test
    public void test_Null_Input_Board_Is_Rejected() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new MinesweeperBoard(null));
        assertEquals("Input board may not be null.", exception.getMessage());
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Invalid_Symbols_Is_Rejected() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new MinesweeperBoard(Collections.singletonList(" * & ")));
        assertEquals("Input board can only contain the characters ' ' and '*'.", exception.getMessage());
    }

    @Disabled
    @Test
    public void test_Input_Board_With_Inconsistent_Row_Lengths_Is_Rejected() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new MinesweeperBoard(Arrays.asList(
                        "*",
                        "**",
                        "* *",
                        "*  *",
                        "*   *"
                )));
        assertEquals("Input board rows must all have the same number of columns.", exception.getMessage());
    }

}
