package com.demo.scaler.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubMatrixSumQueries {
    //Problem Description
    //Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
    //
    //Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
    //
    //NOTE:
    //
    //Rows are numbered from top to bottom, and columns are numbered from left to right.
    //Sum may be large, so return the answer mod 109 + 7.
    //
    //
    //Problem Constraints
    //1 <= N, M <= 1000
    //-100000 <= A[i] <= 100000
    //1 <= Q <= 100000
    //1 <= B[i] <= D[i] <= N
    //1 <= C[i] <= E[i] <= M
    //
    //
    //
    //Input Format
    //The first argument given is the integer matrix A.
    //The second argument given is the integer array B.
    //The third argument given is the integer array C.
    //The fourth argument given is the integer array D.
    //The fifth argument given is the integer array E.
    //(B[i], C[i]) represents the top left corner of the i'th query.
    //(D[i], E[i]) represents the bottom right corner of the i'th query.
    //
    //
    //
    //Output Format
    //Return an integer array containing the submatrix sum for each query.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [   [1, 2, 3]
    //         [4, 5, 6]
    //         [7, 8, 9]   ]
    // B = [1, 2]
    // C = [1, 2]
    // D = [2, 3]
    // E = [2, 3]
    //Input 2:
    //
    // A = [   [5, 17, 100, 11]
    //         [0, 0,  2,   8]    ]
    // B = [1, 1]
    // C = [1, 4]
    // D = [2, 2]
    // E = [2, 4]
    //
    //
    //Example Output
    //Output 1:
    //
    // [12, 28]
    //Output 2:
    //
    // [22, 19]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
    // For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
    //Explanation 2:
    //
    // For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
    // For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
    //

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
                add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));
            }
        };

        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(2, 3));
        ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2, 3));

        ArrayList<Integer> solve = solve(A, B, C, D, E);
        System.out.println(solve);
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        //We are using PrefixSum Matrix to calculate all the sub matrix sum
        //To calculate prefix sum of each cell:  PS[i][j] = PS[i-1][j] + PS[i][j-1] - PS[i-1][j-1] + A[i][j]
        //Find sum of sub matrix using PrefixSum Matrix
        //PS[x2][y2] - PS[x2][y1-1] - PS[x1-1][y2] + PS[x1-1][y1-1]

        int n = A.size(), m = A.get(0).size(), mod = 1000000007;
        long preSum[][] = new long[n + 1][m + 1];
        //preSum[i][j] denotes the sum of elements of matirx (0, 0) to (i, j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = (preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + A.get(i - 1).get(j - 1) + mod) % mod;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int x1 = B.get(i), y1 = C.get(i), x2 = D.get(i), y2 = E.get(i);
            long ans = preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1 - 1];
            while (ans < 0)
                ans += mod;
            ans = ans % mod;
            res.add((int) ans);
        }
        return res;
    }
}
