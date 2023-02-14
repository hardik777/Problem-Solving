package com.demo.scaler.Queue;

import java.util.ArrayList;

public class NIntegersContainingOnly123 {
    //Problem Description
    //Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
    //
    //NOTE: All the A integers will fit in 32-bit integers.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 29500
    //
    //
    //
    //Input Format
    //The only argument given is integer A.
    //
    //
    //
    //Output Format
    //Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 3
    //Input 2:
    //
    // A = 7
    //
    //
    //Example Output
    //Output 1:
    //
    // [1, 2, 3]
    //Output 2:
    //
    // [1, 2, 3, 11, 12, 13, 21]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Output denotes the first 3 integers that contains only digits 1, 2 and 3.
    //Explanation 2:
    //
    // Output denotes the first 3 integers that contains only digits 1, 2 and 3.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int K) {
        ArrayList<String> A = new ArrayList<>();
        A.add("1");
        A.add("2");
        A.add("3");

        if (K == 0) return new ArrayList<Integer>();

        int i = 0;
        while (A.size() < K) {
            A.add(A.get(i) + '1');
            A.add(A.get(i) + '2');
            A.add(A.get(i) + '3');

            i++;
        }
        // System.out.println(A);

        ArrayList<Integer> arr = new ArrayList<>();
        for (int j = 0; j < K; j++) {
            arr.add(Integer.valueOf(A.get(j)));
        }
        // System.out.println(arr);
        return arr;
    }
}