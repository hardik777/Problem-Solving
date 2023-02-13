package com.demo.scaler.SubsetORSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class SubsequenceSumProblem {
    //Problem Description
    //
    //You are given an array of integers of N size.
    //
    //You have to find that there is any subsequence exists or not whose sum is equal to B.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= N <= 20
    //1 <= A[i] <= 100000
    //0 <= B <= 1e9
    //
    //
    //Input Format
    //
    //First Argument is array of integers A
    //Second Argument is B
    //
    //
    //
    //Output Format
    //
    //Return 1 if any subsequence sum is equal to B otherwise return 0.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    //A=[1,20,13,4,5]
    //B=18
    //Input 2:
    //
    //
    //A=[2,2,2,2]
    //B=5
    //
    //
    //Example Output
    //
    //1
    //Output 1:
    //
    //
    //1
    //Output 2:
    //
    //
    //0
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    // There is as subsequence present at indexes 1,3,4 whose sum is 18
    //Explanation 2:
    //
    //
    //There is no possible subsequence whose sum is 5
    //NOTE: Array is considered 1 based indexing for the above explanation.

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 20, 13, 4, 5));
        int solve = solve(arr, 18);
        System.out.print(solve);
    }

    public static int solve(ArrayList<Integer> A, int B) {
        boolean thereSubsetSum = isThereSubsetSum(A, A.size(), B);
        return thereSubsetSum ? 1 : 0;
    }

    /**
     * Let’s take the last element and now the sum = target sum – value of ‘last’ element and elements remaining = size of array – 1.
     *     Now  don’t take the ‘last’ element and now the  sum = target sum and elements remaining = size of array – 1.
     */
    static boolean isThereSubsetSum(ArrayList<Integer> arr, int n, int sum) {
        //Base Case
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        if (arr.get(n - 1) > sum) return isThereSubsetSum(arr, n - 1, sum);

        //Recursive -- Either include or exclude
        return isThereSubsetSum(arr, n - 1, sum) ||
                isThereSubsetSum(arr, n - 1, sum - arr.get(n - 1));
    }
}
