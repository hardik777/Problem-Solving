package com.demo.scaler.Advanced.TwoPointers;

import java.util.ArrayList;

public class PairsWithGivenSumII {
    //Problem Description
    //Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
    //
    //Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 10^9
    //
    //1 <= B <= 10^9
    //
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //
    //The second argument given is integer B.
    //
    //
    //
    //Output Format
    //Return the number of pairs for which sum is equal to B modulo (10^9+7).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 1, 1]
    //B = 2
    //Input 2:
    //
    //
    //A = [1, 1]
    //B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Any two pairs sum up to 2.
    //Explanation 2:
    //
    // only pair (1, 2) sums up to 2.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int B) {
//        1. Start two pointers from beginning & end
//        2. If (A[l] + A[r] == sum) then increment global "ans" variable
//        3. To handle duplicates, count all duplicate values equal to A[r] and add it to global variable
        long mod = 1000000007;
        int i = 0;
        int j = A.size() - 1;
        long sum = 0;
        long res = 0;
        while (i < j) {
            sum = A.get(i) + A.get(j);
            if (sum < B) {
                i++;
            } else if (sum > B) {
                j--;
            } else {
                long x = A.get(i), xx = i;
                while ((i < j) && (A.get(i) == x))
                    i++;

                // Find the frequency of arr[j]
                long y = A.get(j), yy = j;
                while ((j >= i) && (A.get(j) == y))
                    j--;

                // If arr[i] and arr[j] are same
                // then remove the extra number counted
                if (x == y) {
                    long temp = i - xx + yy - j - 1;
                    res += (temp * (temp + 1)) / 2;
                } else {
                    res += (i - xx) * (yy - j);
                }
            }
        }
        // System.out.println((int) (res % mod));
        return (int) (res % mod);
    }
}