package com.demo.scaler.StringsPatternMatching;

public class CountA {
    //Problem Description
    //You are given a string A. Find the number of substrings that start and end with 'a'.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //The string will have only lowercase English letters.
    //
    //
    //
    //Input Format
    //Given the only argument is a String A.
    //
    //
    //
    //Output Format
    //Return number of substrings that start and end with 'a'.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "aab"
    //Input 2:
    //
    // A = "bcbc"
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Substrings that start and end with 'a' are:
    //    1. "a"
    //    2. "aa"
    //    3. "a"
    //Explanation 2:
    //
    // There are no substrings that start and end with 'a'.

    public static void main(String[] args) {
        int count = solve("aab");
        System.out.println(count);
    }

    public static int solve(String A) {
        //Optimized : Count the number of A's and use n * n(+1) / 2

        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                count++;
            }
        }
        return (count * (count + 1)) / 2;
    }
}
