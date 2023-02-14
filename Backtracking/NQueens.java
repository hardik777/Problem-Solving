package com.demo.scaler.Backtracking;

import java.util.ArrayList;

public class NQueens {
    //Problem Description
    //The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    //
    //
    //
    //Given an integer A, return all distinct solutions to the n-queens puzzle.
    //
    //Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    //The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
    //
    //
    //Problem Constraints
    //1 <= A <= 10
    //
    //
    //
    //Input Format
    //First argument is an integer n denoting the size of chessboard
    //
    //
    //
    //Output Format
    //Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = 4
    //Input 2:
    //
    //A = 1
    //
    //
    //Example Output
    //Output 1:
    //
    //[
    // [".Q..",  // Solution 1
    //  "...Q",
    //  "Q...",
    //  "..Q."],
    //
    // ["..Q.",  // Solution 2
    //  "Q...",
    //  "...Q",
    //  ".Q.."]
    //]
    //Output 1:
    //
    //[
    // [Q]
    //]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //There exist only two distinct solutions to the 4-queens puzzle:
    //Explanation 1:
    //
    //There exist only one distinct solutions to the 1-queens puzzle:

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        printNQueens(chess, 0);
        return ans;
    }

    private void printNQueens(int[][] chess, int row) {
        if (row == chess.length) {
            //iterate and add the matrix to ans
            addToAnsList(chess);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (checkIfQueenCanBePlaced(chess, row, col) == true) {
                chess[row][col] = 1; //place the queen
                printNQueens(chess, row + 1);
                chess[row][col] = 0; //remove the queen //Backtracking
            }
        }
    }

    private boolean checkIfQueenCanBePlaced(int[][] chess, int row, int col) {
        //iterating vertically upward on same column
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        //iterating left diagonal upward
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        //iterating right diagonal upward
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void addToAnsList(int[][] chess) {
        ArrayList<String> currList = new ArrayList<>();

        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess.length; j++) {
                int val = chess[i][j];
                if (val == 0) {
                    sb.append(".");
                } else if (val == 1) {
                    sb.append("Q");
                }
            }
            currList.add(sb.toString());
        }
        ans.add(currList);
    }
}