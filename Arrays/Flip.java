package com.demo.scaler.Arrays;

import java.util.ArrayList;

public class Flip {
    //Problem Description
    //You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
    //
    //Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
    //
    //If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
    //
    //NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
    //
    //
    //
    //Problem Constraints
    //1 <= size of string <= 100000
    //
    //
    //
    //Input Format
    //First and only argument is a string A.
    //
    //
    //
    //Output Format
    //Return an array of integers denoting the answer.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = "010"
    //Input 2:
    //
    //A = "111"
    //
    //
    //Example Output
    //Output 1:
    //
    //[1, 1]
    //Output 2:
    //
    //[]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //A = "010"
    //
    //Pair of [L, R] | Final string
    //_______________|_____________
    //[1 1]          | "110"
    //[1 2]          | "100"
    //[1 3]          | "101"
    //[2 2]          | "000"
    //[2 3]          | "001"
    //
    //We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
    //Explanation 2:
    //
    //No operation can give us more than three 1s in final string. So, we return empty array [].

    public static void main(String[] args) {
        ArrayList<Integer> flip = flip("010");
        System.out.println(flip);
    }

    public static ArrayList<Integer> flip(String A) {
        //Kadane's Algorithm + Two Pointer Technique

        ArrayList<Integer> res = new ArrayList<>();
        // left and end index
        int endIndex = 0;
        int startIndex = 0;
        int maxSum = 0;
        int currentSum = 0;
        int size = A.length();
        char[] charArr = A.toCharArray();
        // 1101010001
        for (int i = 0; i < size; i++) {
            char c = charArr[i];
            // if char is zero consider it as 1 and increment with 1
            if (c == '0') {
                currentSum++;
            } else {
                currentSum--;
            }

            // if new maxsum found store the start and end index
            if (maxSum < currentSum) {
                res.clear();
                maxSum = currentSum;
                endIndex = i;
                endIndex = endIndex + 1;
                res.add(startIndex + 1);
                res.add(endIndex);
            }
            // if current sum become negative reset value to zero and store the start index
            if (currentSum < 0) {
                currentSum = 0;
                startIndex = i + 1;
            }
        }

        return res;
    }
}
