package com.demo.scaler.DynamicProgramming;

import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements {
    //Problem Description
    //
    //Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
    //
    //Note: You can choose more than 2 numbers.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= N <= 20000
    //1 <= A[i] <= 2000
    //
    //
    //
    //Input Format
    //
    //The first and the only argument of input contains a 2d matrix, A.
    //
    //
    //
    //Output Format
    //
    //Return an integer, representing the maximum possible sum.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [
    //        [1]
    //        [2]
    //     ]
    //Input 2:
    //
    // A = [
    //        [1, 2, 3, 4]
    //        [2, 3, 4, 5]
    //     ]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 8
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // We will choose 2.
    //Explanation 2:
    //
    // We will choose 3 and 5.

    public static void main(String[] args) {

    }

    public int adjacent(ArrayList<ArrayList<Integer>> input) {
        int n = input.get(0).size();
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < n; ++i) {
            int temp = prev;
            prev = curr;
            curr = Math.max(temp + Math.max(input.get(0).get(i), input.get(1).get(i)), curr);
        }
        return curr;
    }
}