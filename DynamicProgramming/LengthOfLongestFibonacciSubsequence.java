package com.demo.scaler.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class LengthOfLongestFibonacciSubsequence {
    //Problem Description
    //Given a strictly increasing array A of positive integers forming a sequence.
    //
    //A sequence X1, X2, X3, ..., XN is fibonacci like if
    //
    //
    //N > =3
    //Xi + Xi+1 = Xi+2 for all i+2 <= N
    //Find and return the length of the longest Fibonacci-like subsequence of A.
    //
    //If one does not exist, return 0.
    //
    //NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.
    //
    //
    //
    //Problem Constraints
    //3 <= length of the array <= 1000
    //
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the length of the longest Fibonacci-like subsequence of A.
    //If one does not exist, return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, 5, 6, 7, 8]
    //Input 2:
    //
    // A = [1, 3, 7, 11, 12, 14, 18]
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
    //Explanation 2:
    //
    // The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
    // The length will be 3.

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int solve = solveUsingDP(A);
        System.out.println(solve);
    }

    /**
     * Use Set or Map to determine quickly whether the next term of Fibonacci sequence is present in the array A or not. Because of the exponential growth of these terms, there will be not more than log(M) searches to get next element on each iteration.
     * For each starting pair A[i], A[j], we maintain the next expected value y = A[i] + A[j] and the previously seen largest value x = A[j]. If y is in the array, then we can then update these values (x, y) -> (y, x+y) otherwise we stop immediately.
     * Time Complexity = O(n2 * log(m))
     * Space Complexity = O(n)
     */
    public static int solveUsingSet(ArrayList<Integer> A) {
        // Store all array elements in a hash table
        TreeSet<Integer> S = new TreeSet<>();
        for (int t : A) {
            // Add each element into the set
            S.add(t);
        }
        int maxLen = 0, x, y;

        for (int i = 0; i < A.size(); ++i) {
            for (int j = i + 1; j < A.size(); ++j) {

                x = A.get(j);
                y = A.get(i) + A.get(j);
                int length = 3;

                // check until next fib element is found
                while (S.contains(y) && (y != S.last())) {

                    // next element of fib subseq
                    int z = x + y;
                    x = y;
                    y = z;
                    maxLen = Math.max(maxLen, ++length);
                }
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }

    /**
     * The above problem can be solved optimally using dynamic programming.
     * Any two terms can form the first two terms of the Fibonacci like sequence, create a 2-D array dp of size (n X n), where n is the size of the array. An element of the 2-D array, dp[i][j], denotes the maximum length of the Fibonacci sequence ending at (i, j), that is, the last two terms of the sequence are i and j respectively.
     * <p>
     * Consider an example, arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
     * One possible fibonacci like sequence is {1, 2, 3, 5, 8}, that is, {arr[0], arr[1], arr[2], arr[4], arr[7]}
     * Initially the length of longest fibonacci sequence ending at any (i, j) is 2, that is, dp[i][j] = 2 initially.
     * The maximum length of sequence ending at (j, k) = 1 + maximum length of sequence ending at (i, j), where i is the index of element(arr[k] – arr[j]).
     * That is,
     * dp[j][k] = 1 + dp[i][j], where i is the index of element (arr[k] – arr[j]) in array arr.
     * <p>
     * Time Complexity = O(n2)
     * Space Complexity = O(n2)
     */
    public static int solveUsingDP(ArrayList<Integer> A) {
        int n = A.size();
        // Store the indices of all the elements of arr
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(A.get(i), i);
        }
        // Initialize all the elements of dp as 2
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        int maxLength = 2;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                // For every pair (j, k)
                if (index.containsKey(A.get(k) - A.get(j))) {
                    // Find the index i
                    int i = index.get(A.get(k) - A.get(j));
                    // if i and j are not same
                    if (i != j) {
                        // use the formula dp[j][k] = 1 + dp[i][j]
                        dp[j][k] = 1 + dp[i][j];
                        // Update the maximum length
                        maxLength = Math.max(maxLength, dp[j][k]);
                    }
                }
            }
        }
        // If maxLength is 2, then return 0, else return maxLength
        return (maxLength == 2) ? 0 : maxLength;
    }
}
