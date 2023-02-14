package com.demo.scaler.DynamicProgramming;

import java.util.ArrayList;

public class UniquePathsInGrid {
    //Problem Description
    //Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
    //
    //Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    //
    //
    //
    //Problem Constraints
    //1 <= n, m <= 100
    //A[i][j] = 0 or 1
    //
    //
    //
    //Input Format
    //Firts and only argument A is a 2D array of size n * m.
    //
    //
    //
    //Output Format
    //Return an integer denoting the number of unique paths from (1, 1) to (n, m).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [
    //        [0, 0, 0]
    //        [0, 1, 0]
    //        [0, 0, 0]
    //     ]
    //Input 2:
    //
    // A = [
    //        [0, 0, 0]
    //        [1, 1, 1]
    //        [0, 0, 0]
    //     ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
    // So, the total number of unique paths is 2.
    //Explanation 2:
    //
    // It is not possible to reach (n, m) from (1, 1). So, ans is 0.

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        //Using DP[][] we can count no of ways to reach cell i,j
        //dp[i][j] = dp[i-1][j] + dp[i][j-1]

        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return ways(dp, A, n - 1, m - 1);
    }

    //Start from last cell(N-1, M-1) and goes to 0,0
    private static int ways(int[][] dp, ArrayList<ArrayList<Integer>> A, int i, int j) {
        //Base case
        if (i < 0 || j < 0 || A.get(i).get(j) == 1) return 0;
        if (i == 0 && j == 0) return 1; //First row and col

        if (dp[i][j] != -1) return dp[i][j];

        int ans = ways(dp, A, i - 1, j) + ways(dp, A, i, j - 1);
        dp[i][j] = ans;
        return ans;
    }
}