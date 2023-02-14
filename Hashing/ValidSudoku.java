package com.demo.scaler.Hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    //Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
    //
    //The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    //
    //
    //
    //The input corresponding to the above configuration :
    //
    //["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
    //A partially filled sudoku which is valid.
    //
    //Note:
    //
    //A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
    //Return 0 / 1 ( 0 for false, 1 for true ) for this problem

    public static void main(String[] args) {

    }

    public int isValidSudoku(final List<String> A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = A.get(i).charAt(j);
                if (currentChar != '.') {
                    if (!(set.add(currentChar + "in the row " + i)) ||
                            !(set.add(currentChar + "in the column " + j)) ||
                            !(set.add(currentChar + "in the grid " + i / 3 + "-" + j / 3))) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}