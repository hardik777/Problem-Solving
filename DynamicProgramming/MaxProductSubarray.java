package com.demo.scaler.DynamicProgramming;

import java.util.List;

public class MaxProductSubarray {
    //Problem Description
    //Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
    //
    //Return an integer corresponding to the maximum product possible.
    //
    //NOTE: Answer will fit in 32-bit integer value.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 5 * 105
    //
    //-100 <= A[i] <= 100
    //
    //
    //
    //Input Format
    //First and only argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return an integer corresponding to the maximum product possible.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [4, 2, -5, 1]
    //Input 2:
    //
    // A = [-3, 0, -5, 0]
    //
    //
    //Example Output
    //Output 1:
    //
    // 8
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // We can choose the subarray [4, 2] such that the maximum product is 8.
    //Explanation 2:
    //
    // 0 will be the maximum product possible.

    public static void main(String[] args) {

    }

    public int maxProduct(final List<Integer> A) {
        int max = A.get(A.size() - 1);
        int min = A.get(A.size() - 1);
        int res = max;
        for (int i = A.size() - 2; i >= 0; i--) {
            int fp = max * A.get(i);
            int sp = min * A.get(i);
            max = Math.max(fp, Math.max(A.get(i), sp));
            min = Math.min(fp, Math.min(A.get(i), sp));
            res = Math.max(res, max);
        }
        // System.out.println(res);
        return res;
    }
}