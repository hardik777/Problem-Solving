package com.demo.scaler.Advanced.BinarySearch;

public class SquareRootOfInteger {
    //Problem Description
    //
    //Given a number A. Return square root of the number if it is perfect square otherwise return -1.
    //
    //Problem Constraints
    //
    //1 <= A <= 108
    //Input Format
    //
    //First and the only argument is an integer A.
    //Output Format
    //
    //Return an integer which is the square root of A if A is perfect square otherwise return -1.
    //Example Input
    //
    //Input 1:
    //A = 4
    //Input 2:
    //
    //A = 1001
    //Example Output
    //
    //Output 1:
    //2
    //Output 2:
    //
    //-1
    //Example Explanation
    //
    //Explanation 1:
    //sqrt(4) = 2
    //Explanation 2:
    //
    //1001 is not a perfect square.

    public static void main(String[] args) {

    }

    public int solve(int A) {
        long root = -1;

        // Base Cases
        if (A == 0 || A == 1)
            return A;

        int start = 1, end = A;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == A) {
                // System.out.println(mid);
                return (int) mid;
            }

            //check mid * mid < A then search from 1 to mid
            if (mid * mid > A) {
                end = (int) (mid - 1);
            } else {
                start = (int) (mid + 1);
//                root = mid;
            }

        }

//        root = (int) Math.sqrt(A);
        // System.out.println(root);
        return (int) root;
    }
}