package com.demo.scaler.Arrays;

import java.util.ArrayList;

public class TimeToEquality {
    //Problem Description
    //Given an integer array A of size N. In one second, you can increase the value of one element by 1.
    //
    //Find the minimum time in seconds to make all elements of the array equal.
    //
    //
    //Problem Constraints
    //1 <= N <= 1000000
    //1 <= A[i] <= 1000
    //
    //
    //Input Format
    //First argument is an integer array A.
    //
    //
    //Output Format
    //Return an integer denoting the minimum time to make all elements equal.
    //
    //
    //Example Input
    //A = [2, 4, 1, 3, 2]
    //
    //
    //Example Output
    //8
    //
    //
    //Example Explanation
    //We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        int time = 0;

        //find the max
        int max = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (max < A.get(i)) {
                max = A.get(i);
            }
        }

        //get the difference
        for (int i = 0; i < A.size(); i++) {
            if (max != A.get(i)) {
                time += max - A.get(i);
            }
        }

//        System.out.println(time);
        return time;
    }
}