package com.demo.scaler.Advanced.Sorting;

import java.util.ArrayList;

public class InversionCountPairs {
    //Problem Description
    //Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
    //
    //
    //
    //Problem Constraints
    //1 <= length of the array <= 100000
    //
    //1 <= A[i] <= 10^9
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the number of inversions of A modulo (109 + 7).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [3, 2, 1]
    //Input 2:
    //
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //Output 1:
    //
    //3
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // All pairs are inversions.
    //Explanation 2:
    //
    // No inversions.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        int count = countInv(A, 0, A.size() - 1);
        //System.out.println(count);
        return count;
    }

    static int mod = 1000000007;

    public static int countInv(ArrayList<Integer> A, int s, int e) {
        //base case
        if (s >= e) return 0;

        //Rec Case
        int mid = (s + e) / 2;
        int left = countInv(A, s, mid) % mod;
        int right = countInv(A, mid + 1, e) % mod;
        int merge = merge(A, s, mid, e) % mod;
        return (left + right + merge) % mod;
    }

    private static int merge(ArrayList<Integer> A, int s, int mid, int e) {
        int p1 = s, p2 = mid + 1, p3 = 0, cnt = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while (p1 <= mid && p2 <= e) {
            if (A.get(p1) <= A.get(p2)) {
//                A.set(p3, A.get(p1));
                arr.add(A.get(p1));
                p3++;
                p1++;
            } else {
//                A.set(p3, A.get(p2));
                arr.add(A.get(p2));
                cnt += (mid - p1 + 1) % mod;
//                cnt = (cnt + (mid - i)); // COMMON MISTAKE : mid-ptr1
                p3++;
                p2++;
            }
        }

        //Add remaining elements into array
        while (p1 <= mid) {
//            A.set(p3, A.get(p1));
            arr.add(A.get(p1));
            p3++;
            p1++;
        }

        while (p2 <= e) {
//            A.set(p3, A.get(p2));
            arr.add(A.get(p2));
            p3++;
            p2++;
        }

        p3 = 0;
        for (int i = s; i <= e; i++) {
            A.set(i, arr.get(p3));
            p3++;
        }

        return cnt % mod;
    }
}