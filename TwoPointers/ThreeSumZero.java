package com.demo.scaler.Advanced.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {
    //Problem Description
    //
    //Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
    //
    //Find all unique triplets in the array which gives the sum of zero.
    //
    //Note:
    //
    //Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
    //
    //
    //
    //Problem Constraints
    //
    //0 <= N <= 7000
    //
    //-108 <= A[i] <= 108
    //
    //
    //
    //Input Format
    //
    //Single argument representing a 1-D array A.
    //
    //
    //
    //Output Format
    //
    //Output a 2-D vector where each row represent a unique triplet.
    //
    //
    //
    //Example Input
    //
    //A = [-1,0,1,2,-1,4]
    //
    //
    //Example Output
    //
    //[ [-1,0,1],
    //  [-1,-1,2] ]
    //
    //
    //Example Explanation
    //
    //Out of all the possible triplets having total sum zero,only the above two triplets are unique.

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        int n = A.size();

        // For a
        for (int a = 0; a < n - 3; a++) {
            // Take 2 pointers here to check the total sum for b and c
            int b = a + 1, c = n - 1;
            while (b < c) {
                int sum = A.get(a) + A.get(b) + A.get(c);
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(a));
                    temp.add(A.get(b));
                    temp.add(A.get(c));
                    Collections.sort(temp);
                    if (!res.contains(temp))
                        res.add(temp);
                    b++;
                } else if (sum < 0) {
                    b++;
                } else {
                    c--;
                }
            }
        }
        // System.out.println(res);
        return res;
    }
}