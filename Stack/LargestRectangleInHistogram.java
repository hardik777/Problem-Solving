package com.demo.scaler.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    //Problem Description
    //Given an array of integers A.
    //
    //A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
    //
    //Find the area of the largest rectangle formed by the histogram.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 1000000000
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the area of the largest rectangle in the histogram.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [2, 1, 5, 6, 2, 3]
    //Input 2:
    //
    // A = [2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 10
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
    //Explanation 2:
    //
    //Largest rectangle has area 2.

    public static void main(String[] args) {

    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        int ans = 0;
        // if(n==1) return A[0];
        int left[] = smallestElementIndexLeft(A);
        int right[] = smallestElementIndexRight(A);

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            int p1 = left[i];
            int p2 = right[i];
            int width = p2 - p1 - 1;
            ans = Math.max(ans, width * A.get(i));
        }
        return ans;
    }

    public static int[] smallestElementIndexLeft(ArrayList<Integer> A) {
        int n = A.size();
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] smallestElementIndexRight(ArrayList<Integer> A) {
        int n = A.size();
        int ans[] = new int[n];
        Arrays.fill(ans, n);
        Stack<Integer> st = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}