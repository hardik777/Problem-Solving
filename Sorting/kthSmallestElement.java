package com.demo.scaler.Advanced.Sorting;

import java.util.List;

public class kthSmallestElement {
    //Problem Description
    //Find the Bth smallest element in given array A .
    //
    //NOTE: Users should try to solve it in less than equal to B swaps.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= B <= min(|A|, 500)
    //
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The first argument is an integer array A.
    //
    //The second argument is integer B.
    //
    //
    //
    //Output Format
    //Return the Bth smallest element in given array.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [2, 1, 4, 3, 2]
    //B = 3
    //Input 2:
    //
    //A = [1, 2]
    //B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 3rd element after sorting is 2.
    //Explanation 2:
    //
    // 2nd element after sorting is 2.

    public static void main(String[] args) {

    }

    public int kthsmallest(final List<Integer> A, int B) {
        //Selection sort
        int n = A.size();
        for (int i = 0; i < n - 1; i++) {
            //search min value and index
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (A.get(j) < A.get(min_idx)) { // 1 < 2
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = A.get(min_idx);
            A.set(min_idx, A.get(i));
            A.set(i, temp);
        }

        // System.out.println(A);
        return A.get(B - 1);
    }

}