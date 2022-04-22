package fr.univ_amu.iut.exercice5;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperBoard {

    private List<String> board;

    public MinesweeperBoard(List<String> inputBoard) {
        if (inputBoard == null)
            throw new IllegalArgumentException("Input board may not be null.");
        else if (containsIllegalCharacters(inputBoard))
            throw new IllegalArgumentException("Input board can only contain the characters ' ' and '*'.");
        else if (!hasConsistentRowLengths(inputBoard))
            throw new IllegalArgumentException("Input board rows must all have the same number of columns.");

        board = new ArrayList<>(inputBoard);
    }

    public List<String> getAnnotatedRepresentation() {


        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.get(i).length(); ++j) {
                if (board.get(i).charAt(j) != '*') {
                    int nombreMinesVoisines = compterMinesAutourDe(i, j);
                    if (nombreMinesVoisines == 0) continue;

                    StringBuilder sb = new StringBuilder(board.get(i));
                    sb.setCharAt(j, Character.forDigit(nombreMinesVoisines, 10));
                    board.set(i, sb.toString());
                }
            }
        }
        return board;
    }

    private int compterMinesAutourDe(int i, int j) {
        int nombreMines = 0;

        if (i-1 >= 0 && i-1 < board.size()) {
            // en haut à gauche
            if (j-1 >= 0
                    && j-1 < board.get(i-1).length()
                    && board.get(i-1).charAt(j-1) == '*')
                ++nombreMines;

            // en haut au milieu
            if (j >= 0
                    && j < board.get(i-1).length()
                    && board.get(i-1).charAt(j) == '*')
                ++nombreMines;

            // en haut à droite
            if (j+1 >= 0
                    && j+1 < board.get(i-1).length()
                    && board.get(i-1).charAt(j+1) == '*')
                ++nombreMines;
        }

        if (i >= 0 && i < board.size()) {
            // à gauche
            if (j-1 >= 0
                    && j-1 < board.get(i).length()
                    && board.get(i).charAt(j-1) == '*')
                ++nombreMines;

            // à droite
            if (j+1 >= 0
                    && j+1 < board.get(i).length()
                    && board.get(i).charAt(j+1) == '*')
                ++nombreMines;
        }

        if (i+1 >= 0 && i+1 < board.size()) {
            // en bas à gauche
            if (j-1 >= 0
                    && j-1 < board.get(i+1).length()
                    && board.get(i+1).charAt(j-1) == '*') ++nombreMines;

            // en bas au milieu
            if (j >= 0
                    && j < board.get(i+1).length()
                    && board.get(i+1).charAt(j) == '*') ++nombreMines;

            // en bas à droite
            if (j+1 >= 0
                    && j+1 < board.get(i+1).length()
                    && board.get(i+1).charAt(j+1) == '*') ++nombreMines;
        }

        return nombreMines;
    }

    private boolean containsIllegalCharacters(List<String> board) {
        for (String s : board) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != ' ' && s.charAt(i) != '*')
                    return true;
            }
        }

        return false;
    }

    private boolean hasConsistentRowLengths(List<String> board) {
        for (int i = 0; i < board.size() - 1; ++i) {
            if (board.get(i).length() != board.get(i+1).length())
                return false;
        }

        return true;
    }
}
