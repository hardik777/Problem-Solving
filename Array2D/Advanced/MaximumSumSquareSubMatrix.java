package com.demo.scaler.Array2D.Advanced;

import java.util.ArrayList;

public class MaximumSumSquareSubMatrix {
    //Problem Description
    //Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 103.
    //
    //1 <= B <= N
    //
    //-102 <= A[i][j] <= 102.
    //
    //
    //
    //Input Format
    //First arguement is an 2D integer matrix A.
    //
    //Second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return a single integer denoting the maximum sum of submatrix of size B x B.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [
    //        [1, 1, 1, 1, 1]
    //        [2, 2, 2, 2, 2]
    //        [3, 8, 6, 7, 3]
    //        [4, 4, 4, 4, 4]
    //        [5, 5, 5, 5, 5]
    //     ]
    // B = 3
    //Input 2:
    //
    // A = [
    //        [2, 2]
    //        [2, 2]
    //    ]
    // B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 48
    //Output 2:
    //
    // 8
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //    Maximum sum 3 x 3 matrix is
    //    8 6 7
    //    4 4 4
    //    5 5 5
    //    Sum = 48
    //Explanation 2:
    //
    // Maximum sum 2 x 2 matrix is
    //  2 2
    //  2 2
    //  Sum = 8

    public static void main(String[] args) {

    }

    public int solve(ArrayList<ArrayList<Integer>> A, int k) {
        int N = A.size();
        int M = A.get(0).size();

        //---------------------------Create PS---------------------------
        int[][] ps = new int[N][M];
        ps[0][0] = A.get(0).get(0);

        //fill first raw
        for (int i = 1; i < M; i++) {
            ps[0][i] = ps[0][i - 1] + A.get(0).get(i);
        }

        //fill first column
        for (int i = 1; i < N; i++) {
            ps[i][0] = ps[i - 1][0] + A.get(i).get(0);
        }

        // updating the values in the
        // cells as per the general formula.
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                ps[i][j] = ps[i][j - 1] + ps[i - 1][j] - ps[i - 1][j - 1] + A.get(i).get(j);
            }
        }
        //--------------------------------------------------------------

        int sum, max = Integer.MIN_VALUE;

        for (int i = k - 1; i < M; i++) {
            for (int j = k - 1; j < N; j++) {
                // Note that (i, j) is the bottom-right corner coordinates of the
                // square submatrix of size `k`

                sum = ps[i][j];
                if (i - k >= 0) {
                    sum = sum - ps[i - k][j];
                }

                if (j - k >= 0) {
                    sum = sum - ps[i][j - k];
                }

                if (i - k >= 0 && j - k >= 0) {
                    sum = sum + ps[i - k][j - k];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        // System.out.println(max);
        return max;
    }
}