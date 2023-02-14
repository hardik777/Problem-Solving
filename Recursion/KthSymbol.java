package com.demo.scaler.Recursion;

public class KthSymbol {
    //Problem Description
    //On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    //
    //Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 20
    //
    //1 <= B <= 2A - 1
    //
    //
    //
    //Input Format
    //First argument is an integer A.
    //
    //Second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return an integer denoting the Bth indexed symbol in row A.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 2
    // B = 1
    //Input 2:
    //
    // A = 2
    // B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Row 1: 0
    // Row 2: 01
    //Explanation 2:
    //
    // Row 1: 0
    // Row 2: 01

    public static void main(String[] args) {

    }

    //We just have to make observation
    //for n=0, 0
    //for n=1, 0 1
    //for n=2, 0 1 1 0
    //for n=3, 0 1 1 0 1 0 0 1
    //before half the grammar is same as previous row whereas latter half is complement of previous row

    public int solve(int N, int K) {
        //Base case
        if (N == 1 && K == 1) return 0;

        //Rec case
        int mid = (int) (Math.pow(2, N - 1) / 2); //Find mid point of current row
        if (K <= mid) {
            return solve(N - 1, K);
        } else {
            return 1 - solve(N - 1, K - mid); //reverse
        }
    }
}