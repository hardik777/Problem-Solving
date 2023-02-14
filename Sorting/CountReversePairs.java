package com.demo.scaler.Advanced.Sorting;

import java.util.ArrayList;

public class CountReversePairs {
    //Problem Description
    //Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
    //Return the number of important reverse pairs in the given array A.
    //
    //
    //
    //Problem Constraints
    //1 <= length of the array <= 105
    //
    //-2 * 109 <= A[i] <= 2 * 109
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the number of important reverse pairs in the given array A.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 3, 2, 3, 1]
    //Input 2:
    //
    // A = [4, 1, 2]
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
    // There are two pairs which are important reverse i.e (3, 1) and (3, 1).
    //Explanation 2:
    //
    // There is only one pair i.e (4, 1).

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        return reversePairs(A, 0, A.size() - 1);
    }

    public static int reversePairs(ArrayList<Integer> A, int start, int end) {
        //Base case
        if (start == end) return 0;

        int mid = (start + end) / 2;
        int leftReversePairs = reversePairs(A, start, mid);
        int rightReversePairs = reversePairs(A, mid + 1, end);
        int mergeReversePairs = merge(A, start, mid, end);
        return leftReversePairs + rightReversePairs + mergeReversePairs;
    }

    public static int merge(ArrayList<Integer> A, int start, int mid, int end) {
        int p1 = start, p2 = mid + 1, ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        while (p1 <= mid && p2 <= end) {
            if ((long) A.get(p1) > 2 * (long) A.get(p2)) {
                ans += mid - p1 + 1;
                p2++;
            } else {
                p1++;
            }
        }

        p1 = start;
        p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (A.get(p1) <= A.get(p2)) {
                arr.add(A.get(p1++));
            } else {
                arr.add(A.get(p2++));
            }
        }

        //Add Remaining
        while (p1 <= mid) arr.add(A.get(p1++));
        while (p2 <= end) arr.add(A.get(p2++));

        for (int i = 0; i < arr.size(); i++) {
            A.set(start + i, arr.get(i));
        }
        return ans;
    }
}