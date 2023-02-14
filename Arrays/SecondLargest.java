package com.demo.scaler.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SecondLargest {
    //Problem Description
    //You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //0 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The first argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return the second largest element. If no such element exist then return -1.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [2, 1, 2]
    //Input 2:
    //
    // A = [2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // -1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // First largest element = 2
    // Second largest element = 1
    //Explanation 2:
    //
    // There is no second largest element in the array.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return -1;
        } else {
            Collections.sort(A);
            //System.out.println(A.get(A.size() - 2));
            return A.get(A.size() - 2);
        }
    }
}