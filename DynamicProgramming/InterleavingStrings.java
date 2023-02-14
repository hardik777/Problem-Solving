package com.demo.scaler.DynamicProgramming;

public class InterleavingStrings {
    //Problem Description
    //Given A, B, C find whether C is formed by the interleaving of A and B.
    //
    //
    //
    //Problem Constraints
    //1 <= length(A), length(B) <= 100
    //
    //1 <= length(C) <= 200
    //
    //
    //
    //Input Format
    //The first argument of input contains a string, A.
    //The second argument of input contains a string, B.
    //The third argument of input contains a string, C.
    //
    //
    //
    //Output Format
    //Return 1 if string C is formed by interleaving of A and B else 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "aabcc"
    // B = "dbbca"
    // C = "aadbbcbcac"
    //Input 2:
    //
    // A = "aabcc"
    // B = "dbbca"
    // C = "aadbbbaccc"
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
    //Explanation 2:
    //
    // It is not possible to get C by interleaving A and B.

    public static void main(String[] args) {

    }

    public int isInterleave(String A, String B, String C) {
        //Using 3 pointers i,j,k in A,B,C respectively
        //Start with i,j,k from end and goes to 0.
        //If any char match then move pointer ahead of both Strings

//        States: interleaveCheck(A, B, C, i, j, k) = interleaving check for the strings A, B, C ending at position i, j, k respectively
//
//        Unique states: NxMxL  (N = A.length, M = B.length, L = C.length.)
//
//        Recursion relation: interleaveCheck(A, B, C, i, j, k)
//        Case 1= A[i] = C[k] && B[j] = C[k] = result depends on Max(interleaveCheck(A, B, C, i-1, j, k-1), interleaveCheck(A, B, C, i, j-1, k-1))
//        Case 2= A[i] = C[k] = result depends on interleaveCheck(A, B, C, i-1, j, k-1)
//        Case 3= B[j] = C[k] = result depends on interleaveCheck(A, B, C, i, j-1, k-1)
//        Case 4= A[i] != C[k] && B[j] != C[k] = Return 0;

        int N = A.length();
        int M = B.length();
        int L = C.length();

        byte[][][] dp = new byte[N + 1][M + 1][L + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= L; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return interLeaveCheck(A, B, C, N, M, L, dp);
    }

    static int interLeaveCheck(String A, String B, String C, int i, int j, int k, byte[][][] dp) {

        if (i == 0 && j == 0 && k == 0) {
            return 1;
        }
        if ((i == 0 && j != k) || (j == 0 && i != k)) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return (int) dp[i][j][k];
        }

        int ans = 0;


        if ((i > 0 && C.charAt(k - 1) == A.charAt(i - 1)) && (j > 0 && C.charAt(k - 1) == B.charAt(j - 1))) {

            ans = Math.max(interLeaveCheck(A, B, C, i - 1, j, k - 1, dp), interLeaveCheck(A, B, C, i, j - 1, k - 1, dp));
        } else if (i > 0 && C.charAt(k - 1) == A.charAt(i - 1)) {

            ans = interLeaveCheck(A, B, C, i - 1, j, k - 1, dp);
        } else if (j > 0 && C.charAt(k - 1) == B.charAt(j - 1)) {

            ans = interLeaveCheck(A, B, C, i, j - 1, k - 1, dp);
        } else {

            ans = 0;
        }

        dp[i][j][k] = (byte) ans;

        return ans;

    }
}