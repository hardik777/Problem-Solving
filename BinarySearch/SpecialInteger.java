package com.demo.scaler.BinarySearch;

import java.util.ArrayList;

public class SpecialInteger {
    //Problem Description
    //Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //1 <= A[i] <= 10^9
    //
    //1 <= B <= 10^9
    //
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //
    //The second argument given is integer B.
    //
    //
    //
    //Output Format
    //Return the maximum value of K (sub array length).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 2, 3, 4, 5]
    //B = 10
    //Input 2:
    //
    //A = [5, 17, 100, 11]
    //B = 130
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Constraints are satisfied for maximal value of 2.
    //Explanation 2:
    //
    //Constraints are satisfied for maximal value of 3.

    public static void main(String[] args) {

    }

    public static int solve(ArrayList<Integer> A, int B) {
        int start = 1;
        int end = A.size();
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (check(mid, A, B)) {

                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(int size, ArrayList<Integer> A, int B) {
        if (size == 0) {
            return false;
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += A.get(i);
        }
        if (sum > B) {
            return false;
        }
        int start = 0;
        int end = size;

        while (end < A.size()) {
            sum = sum + A.get(end) - A.get(start);

            if (sum > B) {
                return false;
            }
            end++;
            start++;
        }
        //System.out.println(sum);
        return true;
    }
}
