package com.demo.scaler.DynamicProgramming;

import java.util.ArrayList;

public class MaximumSumValue {
    //Problem Description
    //
    //You are given an array A of N integers and three integers B, C, and D.
    //
    //You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= N <= 105
    //
    //-10000 <= A[i], B, C, D <= 10000
    //
    //
    //
    //Input Format
    //
    //First argument is an array A
    //Second argument is an integer B
    //Third argument is an integer C
    //Fourth argument is an integer D
    //
    //
    //
    //Output Format
    //
    //Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [1, 5, -3, 4, -2]
    // B = 2
    // C = 1
    // D = -1
    //Input 2:
    //
    // A = [3, 2, 1]
    // B = 1
    // C = -10
    // D = 3
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 18
    //Output 2:
    //
    // -4
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // If you choose i = 2, j = 2, and k = 3 then we will get
    // A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
    //Explanation 2:
    //
    // If you choose i = 1, j = 3, and k = 3 then we will get
    // A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int[] preMaxB = new int[A.size()];
        int[] preMaxC = new int[A.size()];
        int[] preMaxD = new int[A.size()];

        //Count max value of A[i] * B and store into preMaxB
        preMaxB[0] = A.get(0) * B;
        for (int i = 1; i < A.size(); i++) {
            preMaxB[i] = Math.max(preMaxB[i - 1], A.get(i) * B);
        }

        preMaxC[0] = preMaxB[0] + (A.get(0) * C);
        for (int i = 1; i < A.size(); i++) {
            preMaxC[i] = Math.max(preMaxC[i - 1], preMaxB[i] + (A.get(i) * C));
        }

        preMaxD[0] = preMaxC[0] + (A.get(0) * D);
        for (int i = 1; i < A.size(); i++) {
            preMaxD[i] = Math.max(preMaxD[i - 1], preMaxC[i] + (A.get(i) * D));
        }

        // System.out.println(preMaxD[preMaxD.length - 1]);
        return preMaxD[preMaxD.length - 1];
    }
}