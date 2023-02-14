package com.demo.scaler.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class NobleIntegerExist {
    //Problem Description
    //Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 2*105
    //-108 <= A[i] <= 108
    //
    //
    //Input Format
    //First and only argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return 1 if any such integer p is present else, return -1.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [3, 2, 1, 3]
    //Input 2:
    //
    // A = [1, 1, 3, 3]
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
    // For integer 2, there are 2 greater elements in the array..
    //Explanation 2:
    //
    // There exist no integer satisfying the required conditions.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        Collections.sort(A);
        //Sort manually
        // int temp = 0;
        // for (int i = 0; i < N; i++) {
        //     for (int j = i + 1; j < A.size(); j++) {
        //         if (A.get(i) > A.get(j)) {  // < for desc, // > for asc
        //             //swap
        //             temp = A.get(i);
        //             A.set(i, A.get(j));
        //             A.set(j, temp);
        //         }
        //     }
        // }
        // System.out.println(A);

        if (A.get(N - 1) == 0) {
            // System.out.println(1);
            return 1;
        }

        //check if A[i] == i then exist
        for (int i = 0; i < N - 1; i++) {

            if (A.get(i) == A.get(i + 1)) {
                continue;
            }

            int greaterThanCurrent = (N - i) - 1;
            if (A.get(i) == greaterThanCurrent) {
                // System.out.println(1);
                return 1;
            }
        }
        // System.out.println(-1);
        return -1;
    }
}