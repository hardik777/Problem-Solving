package com.demo.scaler.InterviewProblems;

public class LengthOfLongestConsecutiveOnes {
    //Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
    //
    //
    //Input Format
    //
    //The only argument given is string A.
    //Output Format
    //
    //Return the length of the longest consecutive 1’s that can be achieved.
    //Constraints
    //
    //1 <= length of string <= 1000000
    //A contains only characters 0 and 1.
    //For Example
    //
    //Input 1:
    //    A = "111000"
    //Output 1:
    //    3
    //
    //Input 2:
    //    A = "111011101"
    //Output 2:
    //    7

    public static void main(String[] args) {

    }

    public int solve(String A) {
        /**
         *         We have to find each '0' and calculate length of left and right side '1'
         *         find total length by leftCount + rightCount + 1
         *         each time calculate Max length
         */
        int N = A.length(), totalOneCount = 0, ans = 0, leftCount = 0, rightCount = 0;

        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == '1') {
                totalOneCount++;
            }
        }

        if (totalOneCount == N) {
            return totalOneCount;
        }

        for (int i = 0; i < N; i++) {

            if (A.charAt(i) == '0') {

                //left
                leftCount = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1') {
                        leftCount++;
                    } else {
                        break;
                    }
                }

                //right
                rightCount = 0;
                for (int k = i + 1; k < N; k++) {
                    if (A.charAt(k) == '1') {
                        rightCount++;
                    } else {
                        break;
                    }
                }

                if (totalOneCount > (leftCount + rightCount)) {
                    ans = Math.max(ans, leftCount + rightCount + 1);
                } else {
                    ans = Math.max(ans, leftCount + rightCount);
                }
            }
        }

        if (totalOneCount > 0 && ans == 0) {
            ans = totalOneCount;
        }

        // System.out.println(ans);
        return ans;

    }
}