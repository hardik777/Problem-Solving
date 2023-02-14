package com.demo.scaler.DynamicProgramming;

import java.util.ArrayList;

public class MinSumPathInTriangle {
    //Problem Description
    //Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    //
    //Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is
    //
    //
    //
    //Problem Constraints
    //|A| <= 1000
    //
    //A[i] <= 1000
    //
    //
    //
    //Input Format
    //First and only argument is the vector of vector A defining the given triangle
    //
    //
    //
    //Output Format
    //Return the minimum sum
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //A = [
    //         [2],
    //        [3, 4],
    //       [6, 5, 7],
    //      [4, 1, 8, 3]
    //    ]
    //Input 2:
    //
    // A = [ [1] ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 11
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    //Explanation 2:
    //
    // Only 2 can be collected.

    public static void main(String[] args) {

    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        //Start from last row and count each and every element value by comparing (i+1,j) and (i+1,j+1)
        //and find min value and replace it.
        //To row 0,0 is our answer

        if (A.size() == 1) {
            return A.get(0).get(0);
        }

        int row = A.size();
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < A.get(i).size(); j++) {
                int value = A.get(i).get(j) + Math.min(A.get(i + 1).get(j), A.get(i + 1).get(j + 1));
                A.get(i).set(j, value);
            }
        }
        // System.out.println(A.get(0).get(0));
        return A.get(0).get(0);
    }
}