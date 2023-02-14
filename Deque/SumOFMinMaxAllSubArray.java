package com.demo.scaler.Deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SumOFMinMaxAllSubArray {
    //Problem Description
    //Given an array A of both positive and negative integers.
    //
    //Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
    //
    //NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
    //
    //
    //
    //Problem Constraints
    //1 <= size of array A <= 105
    //
    //-109 <= A[i] <= 109
    //
    //1 <= B <= size of array
    //
    //
    //
    //Input Format
    //The first argument denotes the integer array A.
    //The second argument denotes the value B
    //
    //
    //
    //Output Format
    //Return an integer that denotes the required value.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [2, 5, -1, 7, -3, -1, -2]
    // B = 4
    //Input 2:
    //
    // A = [2, -1, 3]
    // B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 18
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Subarrays of size 4 are :
    //    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    //    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    //    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    //    [7, -3, -1, -2], min + max = -3 + 7 = 4
    //    Sum of all min & max = 6 + 4 + 4 + 4 = 18
    //Explanation 2:
    //
    // Subarrays of size 2 are :
    //    [2, -1],   min + max = -1 + 2 = 1
    //    [-1, 3],   min + max = -1 + 3 = 2
    //    Sum of all min & max = 1 + 2 = 3

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int k) {
        // The queue will store indexes of useful elements
        // in every window
        // In deque 'G' we maintain decreasing order of
        // values from front to rear
        // In deque 'S' we  maintain increasing order of
        // values from front to rear

        if (k > A.size()) {
            return 0;
        }

        long sum = 0;
        long mod = 1000000007;
        Deque<Integer> dequeMin = new LinkedList<>();
        Deque<Integer> dequeMax = new LinkedList<>();

        //Add first k elements
        for (int i = 0; i < k; i++) {
            //Before add we have to remove element from front if they are min or max of current element
            while (!dequeMin.isEmpty() && A.get(i) <= A.get(dequeMin.peekLast())) {
                dequeMin.removeLast();
            }
            while (!dequeMax.isEmpty() && A.get(i) >= A.get(dequeMax.peekLast())) {
                dequeMax.removeLast();
            }

            // Add current element at rear of both deque
            dequeMin.addLast(i);
            dequeMax.addLast(i);
        }

        //Remaining elements
        for (int i = k; i < A.size(); i++) {
            // Element at the front of the deque 'G' & 'S'
            // is the largest and smallest
            // element of previous window respectively
            sum += A.get(dequeMin.peekFirst()) + A.get(dequeMax.peekFirst());

            //Maintain window size
            // Remove all elements which are out of this window
            if (i - k == dequeMin.peek())
                dequeMin.poll();
            if (i - k == dequeMax.peek())
                dequeMax.poll();

            //Before add we have to remove element from front if they are min or max of current element
            while (!dequeMin.isEmpty() && A.get(i) <= A.get(dequeMin.peekLast())) {
                dequeMin.removeLast();
            }
            while (!dequeMax.isEmpty() && A.get(i) >= A.get(dequeMax.peekLast())) {
                dequeMax.removeLast();
            }

            // Add current element at rear of both deque
            dequeMin.addLast(i);
            dequeMax.addLast(i);
        }
        // Sum of minimum and maximum element of last window
        sum = (sum + A.get(dequeMin.peekFirst()) + A.get(dequeMax.peekFirst())) % mod;
        if (sum < 0) sum += mod;

//        System.out.println(sum);
        return (int) sum;
    }
}