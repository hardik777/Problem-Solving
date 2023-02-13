package com.demo.scaler.StringsPatternMatching;

import java.util.ArrayList;

public class PeriodOfString {
    //Problem Description
    //You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
    //
    //Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 106
    //
    //
    //
    //Input Format
    //First and only argument is a string A of length N.
    //
    //
    //
    //Output Format
    //Return an integer, denoting the period of the string.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abababab"
    //Input 2:
    //
    // A = "aaaa"
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Period of the string will be 2:
    // Since, for all i, A[i] = A[i%2].
    //Explanation 2:
    //
    // Period of the string will be 1.

    public static void main(String[] args) {
        int period = solve("abababab");
        System.out.println(period);
    }

    public static int solve(String A) {
        ArrayList<Integer> LPS = new ArrayList<Integer>();
        LPS.add(0); //LPS[0]=0
        int N = A.length();
        int x = 0;
        int lpsValue = 0;

        for (int i = 1; i < N; i++) {
            x = LPS.get(i - 1);
            while (A.charAt(x) != A.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS.get(x - 1);
            }
            lpsValue = x + 1;
            LPS.add(lpsValue);
        }
        System.out.println(LPS);
        return (N - LPS.get(N - 1));
    }
}