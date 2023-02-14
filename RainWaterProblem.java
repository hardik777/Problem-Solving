package com.demo.scaler.Advanced;

import java.util.Arrays;
import java.util.List;

public class RainWaterProblem {
    //Problem Description
    //Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //
    //
    //Input Format
    //First and only argument is the vector A
    //
    //
    //
    //Output Format
    //Return one integer, the answer to the question
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [0, 1, 0, 2]
    //Input 2:
    //
    //A = [1, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    //1
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //1 unit is trapped on top of the 3rd element.
    //Explanation 2:
    //
    //No water is trapped.

    public static void main(String[] args) {

    }

    public int trap(final List<Integer> A) {
        int N = A.size();

        //Create two arrays - left and right
//        ArrayList<Integer> left = new ArrayList<>();
        List<Integer> left = Arrays.asList(new Integer[N]);
        left.set(0, A.get(0));

        //left - store left to right max elements
        for (int i = 1; i < N; i++) {
            left.set(i, Math.max(A.get(i), left.get(i - 1)));
        }

        //right - store right to left max elements
        List<Integer> right = Arrays.asList(new Integer[N]);
        right.set(N - 1, A.get(N - 1));

        for (int i = N - 2; i >= 0; i--) {
            right.set(i, Math.max(A.get(i), right.get(i + 1)));
        }

        //take min value from left and right array and subtract from original array value
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.min(left.get(i), right.get(i)) - A.get(i);
        }
        // System.out.println(ans);
        return ans;
    }
}