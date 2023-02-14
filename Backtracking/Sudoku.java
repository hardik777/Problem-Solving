package com.demo.scaler.Backtracking;

import java.util.ArrayList;

public class Sudoku {
    //Problem Description
    //Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
    //
    //
    //
    //A sudoku puzzle,
    //
    //
    //
    //and its solution numbers marked in red.
    //
    //
    //
    //Problem Constraints
    //N = 9
    //
    //
    //Input Format
    //First argument is an array of array of characters representing the Sudoku puzzle.
    //
    //
    //Output Format
    //Modify the given input to the required answer.
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
    //
    //
    //Example Output
    //Output 1:
    //
    //[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Look at the diagrams given in the question.

    public static void main(String[] args) {

    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudoku(a, 0, 0);
    }

    public static boolean solveSudoku(ArrayList<ArrayList<Character>> sudoku, int row, int col) {
        int n = sudoku.size();

        //base condition
        if (row >= n) {
            return true;
        }

        int nextCol = (col + 1 == n) ? 0 : col + 1;
        int nextRow = (col + 1 == n) ? row + 1 : row;

        //if cell contains any value then return
        if (sudoku.get(row).get(col) != '.') {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (Character option = '1'; option <= '9'; option++) {
            if (isValid(sudoku, row, col, option)) {
                sudoku.get(row).set(col, option);
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                } else {
                    sudoku.get(row).set(col, '.');  //Backtracking
                }
            }
        }
        return false;
    }

    private static boolean isValid(ArrayList<ArrayList<Character>> sudoku, int row, int col, Character option) {
        //check same row
        for (int i = 0; i < sudoku.size(); i++) {
            if (sudoku.get(row).get(i) == option) {
                return false;
            }
        }
        //check same col
        for (int i = 0; i < sudoku.size(); i++) {
            if (sudoku.get(i).get(col) == option) {
                return false;
            }
        }

        //check same square
        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku.get(i).get(j) == option) {
                    return false;
                }
            }
        }
        return true;
    }
}