package com.demo.scaler.SubsetORSubsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenSubsequences {
    //Given an array of integers A of size, N. Find the longest subsequence of A, which is odd-even.
    //
    //A subsequence is said to be odd-even in the following cases:
    //
    //The first element of the subsequence is odd; the second element is even, the third element is odd, and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
    //
    //The first element of the subsequence is even, the second element is odd, the third element is even, and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
    //
    //Return the maximum possible length of odd-even subsequence.
    //
    //Note: An array B is a subsequence of an array A if B can be obtained from A by deleting several (possibly, zero, or all) elements.
    //
    //
    //Input Format
    //
    //The only argument given is the integer array A.
    //Output Format
    //
    //Return the maximum possible length of odd-even subsequence.
    //Constraints
    //
    //1 <= N <= 100000
    //1 <= A[i] <= 10^9
    //For Example
    //
    //Input 1:
    //    A = [1, 2, 2, 5, 6]
    //Output 1:
    //    4
    //    Explanation 1:
    //        Maximum length odd even subsequence is [1, 2, 5, 6]
    //
    //Input 2:
    //    A = [2, 2, 2, 2, 2, 2]
    //Output 2:
    //    1
    //    Explanation 2:
    //        Maximum length odd even subsequence is [2]

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 5, 6));
        int solve = solve(arr);
//        int solve = solveUsingBits(arr);
        System.out.print(solve);
    }

    //find the first integer value i.e. Odd or Even.

    //Iterate through the array and check the element is opposite to previous one. Meaning if //previous one is odd then current should be even and vice versa.
    //Increase our maxcount(which is our answer),  if above condition is true.
    //If above condition is satisfied then change the boolean value according to current value.(odd or even).

    public static int solve(ArrayList<Integer> A) {
        //Check first element is odd or even
        boolean even = A.get(0) % 2 == 0 ? true : false;
        boolean odd = A.get(0) % 2 != 0 ? true : false;
        int length = 0;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 == 0 && even) {  // check for even
                length++;
                even = false;  //setting even flag to false implies that next element in the sub-sequence should be odd
                odd = true;
            } else if (A.get(i) % 2 != 0 && odd) {  // check for odd
                length++;
                odd = false;  //setting odd flag to false implies that next element in the sub-sequence should be even
                even = true;
            }
        }
        return length;
    }

    //Bit Manipulation solution
    public static int solveUsingBits(ArrayList<Integer> A) {
        //AND with odd number gives 1 and with even number given 0
        int count = 1;
        int n = A.size();

        //bitwise and operator concept used here.
        for (int i = 1; i < n; i++) {
            int prev = A.get(i - 1);
            int curr = A.get(i);
            if ((prev & 1) != (curr & 1)) {
                count++;
            }
        }

        return count;
    }

}
