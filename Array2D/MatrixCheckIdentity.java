package com.demo.scaler.Array2D;

import java.util.ArrayList;
import java.util.List;

public class MatrixCheckIdentity {
    //Problem Description
    //
    //You are given a N X N square integer matrix A. You have to tell whether A is an identity matrix or not.
    //
    //Identity matrix is a special square matrix whose main diagonal elements are equal to 1 and all other elements are 0.
    //
    //
    //Problem Constraints
    //
    //2 <= N <= 103
    //
    //A[i][j] equals 0 or 1.
    //
    //
    //
    //Input Format
    //
    //The first argument is a 2D integer array denoting the matrix A
    //
    //
    //Output Format
    //
    //Return 1 if A is an identity matrix, else return 0.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    //[[1, 0], [0, 1]]
    //Input 2:
    //
    //[[0, 0, 1], [0, 1, 0], [1, 0, 0]]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // All the main diagonal elements in A are 1, all other elements are 0.
    // So, A is an identity matrix.
    //Explanation 2:
    //
    // All the main diagonal elements in A are not 1, also all other elements are not equal to 0.
    // So, A is not an identity matrix.

    public static void main(String[] args) {

    }

    public int solve(final List<ArrayList<Integer>> A) {
        int identity = 0;

        for (int i = 0; i < A.size(); i++) {

            int columns = A.get(i).size();

            for (int col = 0; col < columns; col++) {
                if (i == col && A.get(i).get(col) == 1) {
                    identity = 1;
                } else if (A.get(i).get(col) != 0) {
                    identity = 0;
                    break;
                }
            }
        }
//        System.out.println(identity == 1 ? "1" : "0");
        return identity;
    }
}