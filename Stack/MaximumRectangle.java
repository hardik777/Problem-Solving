package com.demo.scaler.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class MaximumRectangle {
    //Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
    //
    //Find the largest rectangle containing only 1's and return its area.
    //
    //Note: Rows are numbered from top to bottom and columns are numbered from left to right.
    //
    //
    //Input Format
    //
    //The only argument given is the integer matrix A.
    //Output Format
    //
    //Return the area of the largest rectangle containing only 1's.
    //Constraints
    //
    //1 <= N, M <= 1000
    //0 <= A[i] <= 1
    //For Example
    //
    //Input 1:
    //    A = [   [0, 0, 1]
    //            [0, 1, 1]
    //            [1, 1, 1]   ]
    //Output 1:
    //    4
    //
    //Input 2:
    //    A = [   [0, 1, 0, 1]
    //            [1, 0, 1, 0]    ]
    //Output 2:
    //    1

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
                add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
            }
        };
        int solve = solve(A);
        System.out.println(solve);
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        int globalMax = Integer.MIN_VALUE;
        //calculates max among all rows
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r != 0 && A.get(r).get(c) == 1) {
                    A.get(r).set(c, A.get(r).get(c) + A.get(r - 1).get(c));
                }
            }
            int rowMax = rowMax(A, r);
            globalMax = Math.max(globalMax, rowMax);
        }
        return globalMax;
    }

    //calculates maximum area in each row
    static int rowMax(ArrayList<ArrayList<Integer>> A, int row) {
        int cols = A.get(0).size();
        int[] l = nearestSmallLtoR(A, row);
        int[] r = nearestSmallRtoL(A, row);
        int max_area = Integer.MIN_VALUE;
        for (int c = 0; c < cols; c++) {
            //Smallest_nearest on left (L) <= BLOCK OF HEIGHT X => smallest_nearest on Right (R)
            // For X to be max, we need to exclude L and R
            // L+1 < == X ==> R-1
            // width = (R-1)-(L+1) + 1 ==> R-1-L-1+1 ==> R-L-1
            int width = r[c] - l[c] - 1;
            int height = A.get(row).get(c);
            int area_with_height_len = width * height;
            max_area = Math.max(max_area, area_with_height_len);
        }
        return max_area;
    }

    //self explanatory
    static int[] nearestSmallLtoR(ArrayList<ArrayList<Integer>> A, int row) {
        int cols = A.get(row).size();
        int[] out = new int[cols];
        Deque<Integer> stack = new ArrayDeque();
        for (int c = 0; c < cols; c++) {
            while (!stack.isEmpty() && A.get(row).get(stack.peek()) >= A.get(row).get(c)) {
                stack.pop();
            }
            if (stack.isEmpty()) out[c] = -1;
            else out[c] = stack.peek();
            stack.push(c);
        }
        return out;
    }

    //self explanatory
    static int[] nearestSmallRtoL(ArrayList<ArrayList<Integer>> A, int row) {
        int cols = A.get(row).size();
        int[] out = new int[cols];
        Deque<Integer> stack = new ArrayDeque();
        for (int c = cols - 1; c >= 0; c--) {
            while (!stack.isEmpty() && A.get(row).get(stack.peek()) >= A.get(row).get(c)) {
                stack.pop();
            }
            if (stack.isEmpty()) out[c] = cols;
            else out[c] = stack.peek();
            stack.push(c);
        }
        return out;
    }
}