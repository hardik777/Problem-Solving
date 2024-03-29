package com.demo.scaler.Advanced.GCD;

import java.util.ArrayList;

public class RemoveOneElementAndGetMaxGCD {
    //Problem Description
    //
    //Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
    //
    //Find the maximum value of GCD.
    //
    //
    //
    //Problem Constraints
    //
    //2 <= N <= 105
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //
    //First argument is an integer array A.
    //
    //
    //
    //Output Format
    //
    //Return an integer denoting the maximum value of GCD.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [12, 15, 18]
    //Input 2:
    //
    // A = [5, 15, 30]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 6
    //Output 2:
    //
    // 15
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    //
    // If you delete 12, gcd will be 3.
    // If you delete 15, gcd will be 6.
    // If you delete 18, gcd will 3.
    // Maximum vallue of gcd is 6.
    //Explanation 2:
    //
    // If you delete 5, gcd will be 15.
    // If you delete 15, gcd will be 5.
    // If you delete 30, gcd will be 5.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int gcdNum = 0;
        int index = 0;

        //capture which value giving small gcd and catch that
        for (int i = 0; i < A.size(); i++) {
            gcdNum = getGCD(gcdNum, A.get(i));
            if (gcdNum < min) {
                min = gcdNum;
                index = i;
            }
        }

        int newGcd = 0;

        //Don't consider that  element which giving small gcd
        for (int i = 0; i < A.size(); i++) {
            if (i != index) {
                newGcd = getGCD(newGcd, A.get(i));
            }
        }
        // System.out.println(newGcd);
        return newGcd;
    }

    public static int getGCD(int A, int B) {
        if (A == 0) return B;
        return getGCD(B % A, A);
    }
}