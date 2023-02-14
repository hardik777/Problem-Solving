package com.demo.scaler.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsIII {
    //Problem Description
    //Given a matrix of integers A of size N x M . There are 4 types of squares in it:
    //
    //1. 1 represents the starting square.  There is exactly one starting square.
    //2. 2 represents the ending square.  There is exactly one ending square.
    //3. 0 represents empty squares we can walk over.
    //4. -1 represents obstacles that we cannot walk over.
    //Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
    //
    //Note: Rows are numbered from top to bottom and columns are numbered from left to right.
    //
    //
    //
    //Problem Constraints
    //2 <= N * M <= 20
    //-1 <= A[i] <= 2
    //
    //
    //
    //Input Format
    //The first argument given is the integer matrix A.
    //
    //
    //
    //Output Format
    //Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [   [1, 0, 0, 0]
    //        [0, 0, 0, 0]
    //        [0, 0, 2, -1]   ]
    //Input 2:
    //
    //A = [   [0, 1]
    //        [2, 0]    ]
    //
    //
    //Example Output
    //Output 1:
    //
    //2
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //We have the following two paths:
    //1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    //2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
    //Explanation 1:
    //
    //Answer is evident here.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0)));
                add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
                add(new ArrayList<Integer>(Arrays.asList(0, 0, 2, -1)));
            }
        };
        int solve = solve(arr);
        System.out.println(solve);
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int ans = 0;

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int start_i = 0, start_j = 0, totalZeroes = 0, zeroCount = 0;
        //find start position and total number of zeroes present in the input matrix
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {

                if (A.get(i).get(j) == 1) {
                    start_i = i;
                    start_j = j;
                } else if (A.get(i).get(j) == 0) {
                    totalZeroes++;
                }
            }
        }

        return walk(start_i, start_j, A, totalZeroes, zeroCount);
    }

    static int walk(int i, int j, ArrayList<ArrayList<Integer>> mat, int totalZeroes, int zeroCount) {

        //edge cases, avoid blocked (-1) && visited cells (-2)
        if (i < 0 || i >= mat.size() || j < 0 || j >= mat.get(0).size() || mat.get(i).get(j) < 0) {
            return 0;
        }

        //Happy case, we reached to the destination
        if (mat.get(i).get(j) == 2) {
            //check if all the non-blocked(0) cells are covered
            if (zeroCount == totalZeroes) {
                return 1;
            }
            return 0;
        }

        //if any cell has 0, increment the zeroCount
        if (mat.get(i).get(j) == 0) {
            zeroCount++;
        }

        //mark cell visited
        mat.get(i).set(j, -2);

        //count the paths by traversing in all 4 directions
        int ans = walk(i - 1, j, mat, totalZeroes, zeroCount) //up
                + walk(i + 1, j, mat, totalZeroes, zeroCount) //down
                + walk(i, j - 1, mat, totalZeroes, zeroCount) //left
                + walk(i, j + 1, mat, totalZeroes, zeroCount); //right

        //mark cell un-visited
        mat.get(i).set(j, 0);

        return ans;
    }
}
