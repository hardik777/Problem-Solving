package com.demo.scaler.TwoPointers;

import java.util.List;

public class Array3Pointers {
    //Problem Description
    //You are given 3 sorted arrays A, B and C.
    //
    //Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
    //
    //Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
    //
    //
    //
    //Problem Constraints
    //0 <= len(A), len(B), len(c) <= 106
    //
    //0 <= A[i], B[i], C[i] <= 107
    //
    //
    //
    //Input Format
    //First argument is an integer array A.
    //
    //Second argument is an integer array B.
    //
    //Third argument is an integer array C.
    //
    //
    //
    //Output Format
    //Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 4, 10]
    // B = [2, 15, 20]
    // C = [10, 12]
    //Input 2:
    //
    // A = [3, 5, 6]
    // B = [2]
    // C = [3, 4]
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // With 10 from A, 15 from B and 10 from C.
    //Explanation 2:
    //
    // With 3 from A, 2 from B and 3 from C.

    public static void main(String[] args) {

    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        //To get max difference of 3 values we can get (max - min) of 3 values
        //and move pointer which have min value because For (max - min) if we increase min values then only we get min difference

        int i = 0, j = 0, k = 0;
        int n1 = A.size(), n2 = B.size(), n3 = C.size();
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;

        while (i < n1 && j < n2 && k < n3) {
            //find min and max values from three values
            minn = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            maxx = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            //Update ans with min diff
            int diff = maxx - minn;
            res = Math.min(diff, res);

            //increment pointer which have min value
            if (minn == A.get(i)) {
                i++;
            } else if (minn == B.get(j)) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}