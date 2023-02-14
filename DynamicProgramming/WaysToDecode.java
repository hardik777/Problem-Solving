package com.demo.scaler.DynamicProgramming;

public class WaysToDecode {
    //Problem Description
    //A message containing letters from A-Z is being encoded to numbers using the following mapping:
    //
    //'A' -> 1
    //'B' -> 2
    //...
    //'Z' -> 26
    //Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
    //
    //
    //
    //Problem Constraints
    //1 <= length(A) <= 105
    //
    //
    //
    //Input Format
    //The first and the only argument is a string A.
    //
    //
    //
    //Output Format
    //Return an integer, representing the number of ways to decode the string modulo 109 + 7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "12"
    //Input 2:
    //
    // A = "8"
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
    // Given encoded message "8", it could be decoded as only "H" (8).
    // The number of ways decoding "8" is 1.
    //Explanation 2:
    //
    // Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
    // The number of ways decoding "12" is 2.

    public static void main(String[] args) {

    }

    public static final long mod = 1000000007;

    public int numDecodings(String A) {
        long[] dp = new long[A.length() + 1];
        dp[0] = 1;
        dp[1] = A.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= A.length(); i++) {
            int oneDigit = Integer.parseInt(A.substring(i - 1, i));
            int twoDigit = Integer.parseInt(A.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] = (dp[i] % mod + dp[i - 1] % mod) % mod;
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] % mod + dp[i - 2] % mod) % mod;
            }
        }
        // System.out.println((int) (dp[A.length()] % mod));
        return (int) (dp[A.length()] % mod);
    }
}