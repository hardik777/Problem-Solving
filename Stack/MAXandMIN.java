package com.demo.scaler.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXandMIN {
    //Problem Description
    //Given an array of integers A.
    //
    //value of a array = max(array) - min(array).
    //
    //Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 1000000
    //
    //
    //
    //Input Format
    //The first and only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the sum of values of all possible subarrays of A modulo 109+7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1]
    //Input 2:
    //
    // A = [4, 7, 3, 8]
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 26
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Only 1 subarray exists. Its value is 0.
    //Explanation 2:
    //
    //value ( [4] ) = 4 - 4 = 0
    //value ( [7] ) = 7 - 7 = 0
    //value ( [3] ) = 3 - 3 = 0
    //value ( [8] ) = 8 - 8 = 0
    //value ( [4, 7] ) = 7 - 4 = 3
    //value ( [7, 3] ) = 7 - 3 = 4
    //value ( [3, 8] ) = 8 - 3 = 5
    //value ( [4, 7, 3] ) = 7 - 3 = 4
    //value ( [7, 3, 8] ) = 8 - 3 = 5
    //value ( [4, 7, 3, 8] ) = 8 - 3 = 5
    //sum of values % 10^9+7 = 26

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        //Contribution technique for each element in total answer in every Subarray as MIN and MAX element
        //pre-compute all of this
        int[] prevSmall = prevSmallerIndex(A);
        int[] nextSmall = nextSmallerIndex(A);
        int[] prevGreater = prevGreaterIndex(A);
        int[] nextGreater = nextGreaterIndex(A);
        int mod = 1000 * 1000 * 1000 + 7;

        long ans = 0;
        for (int i = 0; i < A.size(); i++) {
            //subarray in which A[i] is min
            int p1 = prevSmall[i];
            int p2 = nextSmall[i];
            long prodMin = (1L * (i - p1) * (p2 - i)) % mod;
            long minContribution = (prodMin * A.get(i)) % mod;

            //subarray in which A[i] is max
            int p3 = prevGreater[i];
            int p4 = nextGreater[i];
            long prodMax = (1L * (i - p3) * (p4 - i)) % mod;
            long maxContribution = (prodMax * A.get(i)) % mod;

            //computing ans
            ans = (ans % mod) + ((maxContribution - minContribution) % mod);
            ans = ans % mod;
        }
        if (ans < 0) {
            ans = (ans + mod) % mod;
        }
        return (int) (ans % mod);
    }

    private static int[] prevSmallerIndex(ArrayList<Integer> A) {
        int N = A.size();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }


    private static int[] nextSmallerIndex(ArrayList<Integer> A) {
        int N = A.size();
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] prevGreaterIndex(ArrayList<Integer> A) {
        int N = A.size();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A.get(i) >= A.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterIndex(ArrayList<Integer> A) {
        int N = A.size();
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(i) >= A.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

}