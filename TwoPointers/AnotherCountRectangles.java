package com.demo.scaler.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class AnotherCountRectangles {
    //Problem Description
    //
    //Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
    //
    //(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
    //
    //
    //
    //Problem Constraints
    //
    //1 <= |A| <= 100000
    //1 <= A[i] <= 109
    //1 <= B <= 109
    //
    //
    //
    //Input Format
    //
    //The first argument given is the integer array A.
    //
    //The second argument given is integer B.
    //
    //
    //
    //Output Format
    //
    //Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [1, 2]
    // B = 5
    //Input 2:
    //
    // A = [1, 2]
    // B = 1
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 4
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
    //Explanation 2:
    //
    // No Rectangle is valid.

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5));
        int solve = solve(A, 5);  //Ans = 6
        System.out.println(solve);
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int mod = (1000 * 1000 * 1000) + 7;
        int l = 0, r = A.size() - 1;
        long ans = 0;
        while (l <= r) {
            long area = (long) A.get(l) * A.get(r);
            if (area < B) {
                int size = (r - l + 1);
                ans = ans % mod + (((long) 2 * size) - 1) % mod;  // 2 means we have to count each pair like 1X2 and 2X1
                l++;
            } else {
                r--;
            }
        }
        return (int) ans % mod;
    }
}
