package com.demo.scaler.Advanced.Sorting;

import java.util.Collections;
import java.util.List;

public class MakeLargestNumber {
    //Problem Description
    //Given an array A of non-negative integers, arrange them such that they form the largest number.
    //
    //Note: The result may be very large, so you need to return a string instead of an integer.
    //
    //
    //
    //Problem Constraints
    //1 <= len(A) <= 100000
    //0 <= A[i] <= 2*109
    //
    //
    //
    //Input Format
    //The first argument is an array of integers.
    //
    //
    //
    //Output Format
    //Return a string representing the largest number.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [3, 30, 34, 5, 9]
    //Input 2:
    //
    // A = [2, 3, 9, 0]
    //
    //
    //Example Output
    //Output 1:
    //
    // "9534330"
    //Output 2:
    //
    // "9320"
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
    //Explanation 2:
    //
    //Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

    public static void main(String[] args) {

    }

    public String largestNumber(final List<Integer> A) {
        //sort using comparator
        Collections.sort(A, (a, b) -> {
            String ab = "" + a + b;
            String ba = "" + b + a;
            return ba.compareTo(ab);
        });

//        System.out.println(A);

        //check if all zeros then return 0
        if (A.get(0) == 0 || A.get(A.size() - 1) == 0) return "0";

        //append
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            sb.append(A.get(i));
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}