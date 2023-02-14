package com.demo.scaler.Advanced.BinarySearch;

import java.util.List;

public class RotatedSortedArraySearch {
    //Problem Description
    //Given a sorted array of integers A of size N and an integer B.
    //
    //array A is rotated at some pivot unknown to you beforehand.
    //
    //(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
    //
    //You are given a target value B to search. If found in the array, return its index otherwise, return -1.
    //
    //You may assume no duplicate exists in the array.
    //
    //NOTE: Users are expected to solve this in O(log(N)) time.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 1000000
    //
    //1 <= A[i] <= 10^9
    //
    //all elements in A are distinct.
    //
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //
    //The second argument given is the integer B.
    //
    //
    //
    //Output Format
    //Return index of B in array A, otherwise return -1
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [4, 5, 6, 7, 0, 1, 2, 3]
    //B = 4
    //Input 2:
    //
    //A = [1]
    //B = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //
    //Target 4 is found at index 0 in A.
    //Explanation 2:
    //
    //
    //Target 1 is found at index 0 in A.

    public static void main(String[] args) {

    }

    public int search(final List<Integer> A, int B) {
        //find index from where elements order changes
        int ind = -1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                ind = i;
            }
        }

        int a = binarySearch(A, 0, ind, B);
        if (a == -1) {
            a = binarySearch(A, ind + 1, A.size() - 1, B);
        }
        // System.out.println(a);
        return a;
    }

    public static int binarySearch(List<Integer> A, int s, int e, int target) {
        if (s > e) return -1;

        int mid = (s + e) / 2;
        if (A.get(mid) == target) {
            return mid;
        } else if (A.get(mid) < target) {
            return binarySearch(A, mid + 1, e, target);
        } else {
            return binarySearch(A, s, mid - 1, target);
        }
    }
}