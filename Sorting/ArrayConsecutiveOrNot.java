package com.demo.scaler.Advanced.Sorting;

import java.util.ArrayList;

public class ArrayConsecutiveOrNot {
    //Problem Description
    //Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    //NOTE: Try this with O(1) extra space.
    //
    //
    //
    //Problem Constraints
    //1 <= length of the array <= 100000
    //1 <= A[i] <= 10^9
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return 1 if the array elements are consecutive else return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [3, 2, 1, 4, 5]
    //Input 2:
    //
    // A = [1, 3, 2, 5]
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
    // As you can see all the elements are consecutive, so we return 1.
    //Explanation 2:
    //
    // Element 4 is missing, so we return 0.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
            sum += A.get(i);
        }

        long correctSum = ((max * (max + 1)) / 2) - ((min * (min - 1)) / 2);
        return sum == correctSum ? 1 : 0;
    }
}