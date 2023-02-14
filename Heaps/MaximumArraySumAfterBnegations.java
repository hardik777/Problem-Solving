package com.demo.scaler.Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaximumArraySumAfterBnegations {
    //Problem Description
    //Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
    //
    //You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
    //
    //
    //
    //Problem Constraints
    //1 <= length of the array <= 5*105
    //1 <= B <= 5 * 106
    //-100 <= A[i] <= 100
    //
    //
    //
    //Input Format
    //The first argument given is an integer array A.
    //The second argument given is an integer B.
    //
    //
    //
    //Output Format
    //Return an integer denoting the maximum array sum after B modifications.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [24, -68, -29, -9, 84]
    // B = 4
    //Input 2:
    //
    // A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
    // B = 10
    //
    //
    //Example Output
    //Output 1:
    //
    // 196
    //Output 2:
    //
    // 362
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Final array after B modifications = [24, 68, 29, -9, 84]
    //Explanation 2:
    //
    // Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]

    public static void main(String[] args) {

    }

    //TC: O(NLong) for push and push operation,  SC:O(N)

    public int solve(ArrayList<Integer> A, int B) {
        //To get maximum sum, we have to first take all the negative elements and convert them into positive numbers.
        //then after completing all negative elements, for all positive numbers, we take smallest positive number
        //For all positive numbers there are 2 cases:
        // 1. if remains B = even then no need to change and break loop
        //    For e.g: 5 and B = 4 then 5 into => 5,-5,5,-5  =>same value we get
        // 2. if remains B = odd then convert smallest positive element into negative and break (Because for odd times modification value becomes negative)
        //    For e.g: 5 and B = 3 then 5 into => -5,5,-5 =>negative value we get

        //To get min value each time, we use Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            minHeap.offer(A.get(i));
        }

        int sum = 0;
        for (int i = 1; i <= B; i++) {
            int min_val = minHeap.poll();
            min_val = -(min_val);
            minHeap.offer(min_val);
        }

        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        // System.out.println(sum);
        return sum;
    }
}