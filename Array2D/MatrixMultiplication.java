package com.demo.scaler.Array2D;

import java.util.ArrayList;

public class MatrixMultiplication {
    //Problem Description
    //You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
    //
    //image
    //
    //
    //
    //Problem Constraints
    //1 <= M, N, P <= 100
    //
    //-100 <= A[i][j], B[i][j] <= 100
    //
    //
    //
    //Input Format
    //There are 2 lines in the input
    //First line: Two integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array.
    //Second line: Two integer R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array.
    //
    //
    //Output Format
    //Return a 2D integer matrix denoting AB.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //2 2 1 2 3 4
    //2 2 5 6 7 8
    //Input 2:
    //
    //1 2 1 1
    //2 1 2 3
    //
    //
    //Example Output
    //Output 1:
    //
    // [[19, 22],
    //  [43, 50]]
    //Output 2:
    //
    // [[5]]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // image
    //Explanation 2:
    //
    // [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int N1 = A.size(), sum = 0;
        int M1 = A.get(0).size();
        int N2 = B.size();
        int M2 = B.get(0).size();

        for (int i = 0; i < N1; i++) {

            arr = new ArrayList<>();
            for (int j = 0; j < M2; j++) {
                sum = 0;
                for (int k = 0; k < N2; k++) {
                    sum += A.get(i).get(k) * B.get(k).get(j);
                }
                arr.add(sum);
            }
            arrayList.add(arr);
        }
        // System.out.println(arrayList);
        return arrayList;
    }
}