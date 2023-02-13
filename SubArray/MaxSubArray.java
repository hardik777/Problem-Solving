package com.demo.scaler.SubArray;

import java.util.List;

public class MaxSubArray {
    //Problem Description
    //Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 1e6
    //-1000 <= A[i] <= 1000
    //
    //
    //
    //Input Format
    //The first and the only argument contains an integer array, A.
    //
    //
    //
    //Output Format
    //Return an integer representing the maximum possible sum of the contiguous subarray.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, -10]
    //Input 2:
    //
    // A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    //
    //
    //Example Output
    //Output 1:
    //
    // 10
    //Output 2:
    //
    // 6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
    //Explanation 2:
    //
    // The subarray [4,-1,2,1] has the maximum possible sum of 6.

    public static void main(String[] args) {

    }

    public int maxSubArray(final List<Integer> A) {
        int currentSum = 0, maxSum = A.get(0);
        for (int i = 1; i < A.size(); i++) {

            currentSum += A.get(i);
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        // System.out.println(maxSum);
        return maxSum;
    }
}