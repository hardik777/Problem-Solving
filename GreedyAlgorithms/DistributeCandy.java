package com.demo.scaler.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributeCandy {
    //N children are standing in a line. Each child is assigned a rating value.
    //
    //You are giving candies to these children subjected to the following requirements:
    //
    //Each child must have at least one candy.
    //Children with a higher rating get more candies than their neighbors.
    //What is the minimum number of candies you must give?
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //-109 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The first and only argument is an integer array A representing the rating of children.
    //
    //
    //
    //Output Format
    //Return an integer representing the minimum candies to be given.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2]
    //Input 2:
    //
    // A = [1, 5, 2, 1]
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 7
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
    // So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
    //Explanation 2:
    //
    // Candies given = [1, 3, 2, 1]

    public static void main(String[] args) {

    }

    public int candy(ArrayList<Integer> A) {
        //Create two array CL and CR and add values
        //CL = if A[i] > A[i-1] then CL[i] = CL[i-1] + 1 else 1
        //CR = if A[i] > A[i+1] then CR[i] = CR[i+1] + 1 else 1

        if (A == null || A.size() == 0) {
            return 0;
        }

        int len = A.size();
        List<Integer> candies = new ArrayList<>(Collections.nCopies(len, 1));

        for (int i = 1; i < len; i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies.set(i, candies.get(i - 1) + 1);
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies.set(i, Math.max(candies.get(i), candies.get(i + 1) + 1));
            }
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;

        // System.out.println(sum);
        return sum;
    }
}