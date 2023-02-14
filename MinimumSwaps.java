package com.demo.scaler.Advanced;

import java.util.ArrayList;

public class MinimumSwaps {
    //Problem Description
    //
    //Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
    //
    //Note: It is possible to swap any two elements, not necessarily consecutive.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= length of the array <= 100000
    //-109 <= A[i], B <= 109
    //
    //
    //
    //Input Format
    //
    //The first argument given is the integer array A.
    //The second argument given is the integer B.
    //
    //
    //
    //Output Format
    //
    //Return the minimum number of swaps.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [1, 12, 10, 3, 14, 10, 5]
    // B = 8
    //Input 2:
    //
    // A = [5, 17, 100, 11]
    // B = 20
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // A = [1, 12, 10, 3, 14, 10, 5]
    // After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
    // After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
    // Now, all elements less than or equal to 8 are together.
    //Explanation 2:
    //
    // A = [5, 17, 100, 11]
    // After swapping 100 and 11, A => [5, 17, 11, 100].
    // Now, all elements less than or equal to 20 are together.
    //

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int B) {
        //Find count of number which are less than B = which is our window
        //first window count of bad no(which are greater than B)
        //Than start from end of first window till n
        //Check new number of window is > B than badnocount++
        //if previous number is > B than badnocount--
        //else update our ans

        int n = A.size();
        int x = 0, badNoCount = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) <= B)
                x++;
        }
        //First Window
        for (int i = 0; i < x; i++) {
            if (A.get(i) > B) badNoCount++;
        }
        int minswap = badNoCount;

        for (int i = x; i < n; i++) //maintain x size window
        {
            if (A.get(i) > B)
                badNoCount++;
            if (A.get(i - x) > B)
                badNoCount--;
            minswap = Math.min(minswap, badNoCount);
        }

        // System.out.println(minswap);
        return minswap;
    }
}