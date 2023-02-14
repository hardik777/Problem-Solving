package com.demo.scaler.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {
    //Problem Description
    //You are given a matrix A of size N x 2 which represents different operations.
    //Assume initially you have a stack-like data structure you have to perform operations on it.
    //
    //Operations are of two types:
    //
    //1 x: push an integer x onto the stack and return -1.
    //
    //2 0: remove and return the most frequent element in the stack.
    //
    //If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
    //
    //A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 100000
    //
    //1 <= A[i][0] <= 2
    //
    //0 <= A[i][1] <= 109
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the array of integers denoting the answer to each operation.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [
    //            [1, 5]
    //            [1, 7]
    //            [1, 5]
    //            [1, 7]
    //            [1, 4]
    //            [1, 5]
    //            [2, 0]
    //            [2, 0]
    //            [2, 0]
    //            [2, 0]  ]
    //Input 2:
    //
    // A =  [
    //        [1, 5]
    //        [2, 0]
    //        [1, 4]   ]
    //
    //
    //Example Output
    //Output 1:
    //
    // [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
    //Output 2:
    //
    // [-1, 5, -1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Just simulate given operations.
    //Explanation 2:
    //
    // Just simulate given operations.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 7)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 7)));
                add(new ArrayList<Integer>(Arrays.asList(1, 4)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(2, 0)));
                add(new ArrayList<Integer>(Arrays.asList(2, 0)));
                add(new ArrayList<Integer>(Arrays.asList(2, 0)));
                add(new ArrayList<Integer>(Arrays.asList(2, 0)));
            }
        };
        ArrayList<Integer> solve = solve(arr);
        System.out.println(solve);
    }

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> retarr = new ArrayList<>();
        HashMap<Integer, Integer> freqmap = new HashMap<>();
        HashMap<Integer, Stack<Integer>> stackmap = new HashMap<>();
        int n = A.size();
        int maxfreq = 0;
        int freq = 0;
        for (int i = 0; i < n; i++) {
            int optype = A.get(i).get(0);
            int data = A.get(i).get(1);
            if (optype == 1) {
                Stack<Integer> st = new Stack<>();
                freqmap.put(data, freqmap.getOrDefault(data, 0) + 1);
                freq = freqmap.get(data);
                if (freq > maxfreq) {
                    maxfreq = freq;
                }
                st = stackmap.get(freq);
                if (st == null) {
                    st = new Stack<>();
                    st.push(data);
                } else {
                    st.push(data);
                }
                stackmap.put(freq, st);
                retarr.add(-1);
            } else {
                Stack<Integer> st = stackmap.get(maxfreq);
                int val = st.pop();
                freqmap.put(val, freqmap.get(val) - 1);
                if (st.isEmpty()) {
                    maxfreq--;
                }
                retarr.add(val);
            }
        }
        return retarr;
    }
}
