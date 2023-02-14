package com.demo.scaler.Arrays;

import java.util.ArrayList;

public class ChristmasTrees {
    //Problem Description
    //You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
    //The cost of these trees is Bp + Bq + Br.
    //
    //You are to choose 3 trees such that their total cost is minimum. Return that cost.
    //
    //If it is not possible to choose 3 such trees return -1.
    //
    //
    //
    //Problem Constraints
    //1 <= A[i], B[i] <= 109
    //3 <= size(A) = size(B) <= 3000
    //
    //
    //
    //Input Format
    //First argument is an integer array A.
    //Second argument is an integer array B.
    //
    //
    //
    //Output Format
    //Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 3, 5]
    // B = [1, 2, 3]
    //Input 2:
    //
    // A = [1, 6, 4, 2, 6, 9]
    // B = [2, 5, 7, 3, 2, 7]
    //
    //
    //Example Output
    //Output 1:
    //
    // 6
    //Output 2:
    //
    // 7
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
    //Explanation 2:
    //
    // We can choose the trees with indices 1, 4 and 5, and the cost is 2 + 3 + 2 = 7.
    // This is the minimum cost that we can get.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //We can check j as middle element and find i on left by checking condition and find k on right side
        //and Calculate min sum each time

        int n = A.size();
        int min = Integer.MAX_VALUE;

        for (int j = 1; j < n; j++) {
            int temp_sum = B.get(j);  //contribution by centre element to the min sum;
            int val_i = Integer.MAX_VALUE;
            int val_k = Integer.MAX_VALUE;

            for (int i = j - 1; i >= 0; i--) {  //catching the left element with min possible contribution to the min sum;
                if (A.get(i) < A.get(j) && B.get(i) < val_i) {  // Also we are making sure left ele is smaller than centre;
                    val_i = B.get(i);
                }
            }
            for (int k = j + 1; k < n; k++) {  //catching the right element with min possible contribution to the min sum;
                if (A.get(j) < A.get(k) && B.get(k) < val_k) {
                    val_k = B.get(k);
                }
            }
            if (val_i != Integer.MAX_VALUE && val_k != Integer.MAX_VALUE) {  // calculating sum only after initial values of
                temp_sum = temp_sum + val_i + val_k;  //left contribution and right contribution are changed.
                min = Math.min(min, temp_sum);
            }
        }

        if (min == Integer.MAX_VALUE) {  //edge case where no possible triplets found.
            return -1;
        }
        return min;
    }
}