package com.demo.scaler.Arrays.PrefixSum;

import android.net.IpSecManager;

import java.util.ArrayList;

public class ClosestMinMaxSubArray {
    //Problem Description
    //Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
    //
    //and at least one occurrence of the minimum value of the array.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 2000
    //
    //
    //
    //Input Format
    //First and only argument is vector A
    //
    //
    //
    //Output Format
    //Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 3]
    //Input 2:
    //
    //A = [2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Only choice is to take both elements.
    //Explanation 2:
    //
    // Take the whole array.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        //Find Max
        int max = getMax(A);  //Collections.max(A);
        int min = getMin(A);  //Collections.min(A);

        int pos_min = -1;
        int pos_max = -1;
        int ans = Integer.MAX_VALUE;

        //0 1 2 3 4 5
        //6 4 1 2 5 6
        for (int i = 0; i < A.size(); i++) {

            // last occurrence of minValue
            if (A.get(i) == min) {
                pos_min = i;
            }

            // last occurrence of maxValue
            if (A.get(i) == max) {
                pos_max = i;
            }
            if (pos_max != -1 && pos_min != -1) {
                ans = Math.min(ans, Math.abs(pos_min - pos_max) + 1);
            }
        }
        return ans;
    }

    public static int getMax(ArrayList<Integer> A) {
        int max = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (max < A.get(i)) {
                max = A.get(i);
            }
        }
        return max;
    }

    public static int getMin(ArrayList<Integer> A) {
        int min = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (min > A.get(i)) {
                min = A.get(i);
            }
        }
        return min;
    }
}