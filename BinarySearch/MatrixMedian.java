package com.demo.scaler.Advanced.BinarySearch;

import java.util.ArrayList;

public class MatrixMedian {
    //roblem Description
    //Given a matrix of integers A of size N x M in which each row is sorted.
    //
    //Find and return the overall median of matrix A.
    //
    //NOTE: No extra memory is allowed.
    //
    //NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
    //
    //
    //
    //Problem Constraints
    //1 <= N, M <= 10^5
    //
    //1 <= N*M <= 10^6
    //
    //1 <= A[i] <= 10^9
    //
    //N*M is odd
    //
    //
    //
    //Input Format
    //The first and only argument given is the integer matrix A.
    //
    //
    //
    //Output Format
    //Return the overall median of matrix A.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [   [1, 3, 5],
    //        [2, 6, 9],
    //        [3, 6, 9]   ]
    //Input 2:
    //
    //A = [   [5, 17, 100]    ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 17
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    //Median is 5. So, we return 5.
    //Explanation 2:
    //
    //Median is 17.

    public static void main(String[] args) {

    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = A.size();
        int m = A.get(0).size();
        int desiredValue = 1 + (n * m) / 2;

        // compute max min values from since array is sorted out- row wise count
        for (int i = 0; i < n; i++) {

            if (A.get(i).get(0) < low) {
                low = A.get(i).get(0);
            }
            if (A.get(i).get(m - 1) > high) {
                high = A.get(i).get(m - 1);
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // get count of elements less than mid in all rows
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += getSmallestCount(A.get(i), mid);
            }
            if (count < desiredValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // System.out.println(low);
        return low;
    }

    //count of elements less than mid in each row
    public static int getSmallestCount(ArrayList<Integer> row, int mid) {
        int low = 0;
        int high = row.size() - 1;
        while (low <= high) {
            int midd = low + (high - low) / 2;
            if (row.get(midd) <= mid) {
                low = midd + 1;
            } else {
                high = midd - 1;
            }
        }
        return low;
    }

}