package com.demo.scaler.Advanced.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumUnSortedSubArray {
    //Problem Description
    //Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 1000000
    //1 <= A[i] <= 1000000
    //
    //
    //
    //Input Format
    //First and only argument is an array of non-negative integers of size N.
    //
    //
    //
    //Output Format
    //Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 3, 2, 4, 5]
    //Input 2:
    //
    //A = [1, 2, 3, 4, 5]
    //
    //
    //Example Output
    //Output 1:
    //
    //[1, 2]
    //Output 2:
    //
    //[-1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //If we sort the sub-array A1, A2, then the whole array A gets sorted.
    //Explanation 2:
    //
    //A is already sorted.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> arr = (ArrayList<Integer>) A.clone();
        Collections.sort(A);

        int start = -1;
        int end = -1;

        for (int i = 0; i < arr.size(); i++) {
            if (A.get(i) != arr.get(i)) {
                start = i;
                int j = arr.size() - 1;
                while (j >= start) {
                    if (A.get(j) != arr.get(j)) {
                        end = j;
                        return new ArrayList(Arrays.asList((int) start, (int) end));
                    }
                    j--;
                }
            }
        }
        return new ArrayList(Arrays.asList((int) -1));
    }
}