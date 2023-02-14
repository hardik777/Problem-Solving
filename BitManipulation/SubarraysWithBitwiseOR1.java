package com.demo.scaler.Advanced.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarraysWithBitwiseOR1 {
    //Problem Description
    //Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
    //
    //
    //Problem Constraints
    //1 <= A <= 105
    //
    //
    //Input Format
    //The first argument is a single integer A.
    //The second argument is an integer array B.
    //
    //
    //Output Format
    //Return the number of subarrays with bitwise array 1.
    //
    //
    //Example Input
    //Input 1:
    // A = 3
    //B = [1, 0, 1]
    //Input 2:
    // A = 2
    //B = [1, 0]
    //
    //
    //Example Output
    //Output 1:
    //5
    //Output2:
    //2
    //
    //
    //Example Explanation
    //Explanation 1:
    //The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
    //Except the subarray [0] all the other subarrays has a Bitwise OR = 1
    //Explanation 2:
    //The subarrays are :- [1], [0], [1, 0]
    //Except the subarray [0] all the other subarrays has a Bitwise OR = 1

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 0, 1));
        Long count = solve(3, A);
        System.out.println(count);
    }

    public static Long solve(int B, ArrayList<Integer> A) {
        //1 with 0 or 1, OR will be 1
        //So we have to count consecutive 0 length and find No of sub array by n(n+1)/2
        //So total subarray - subarray with all 0's
        //count = n(n+1)/2 - subarray count with all 0's

        //Find subarray with all consecutive  0's
        long countZeroSubarray = 0, zerosCount = 0;
        for (int i = 0; i < B; i++) {
            if (A.get(i) == 0) {
                zerosCount++;
            } else {
                //Find subarray by getting length of all consecutive zeros
                countZeroSubarray += (zerosCount * (zerosCount + 1)) / 2;
                zerosCount = 0;
            }
        }
        //Find last part of zeros
        countZeroSubarray += (zerosCount * (zerosCount + 1)) / 2;

        long totalSubArrays = (B * (B + 1)) / 2;
        return totalSubArrays - countZeroSubarray;
    }
}
