package com.demo.scaler.Arrays.PrefixSum;

import java.util.ArrayList;
import java.util.HashSet;

public class LeadersInArray {
    //Problem Description
    //
    //Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
    //
    //NOTE: The rightmost element is always a leader.
    //
    //Problem Constraints
    //
    //1 <= N <= 105
    //1 <= A[i] <= 108
    //Input Format
    //
    //There is a single input argument which a integer array A
    //Output Format
    //
    //Return an integer array denoting all the **leader elements** of the array.
    //NOTE: Ordering in the output doesn't matter.
    //
    //Example Input
    //
    // A = [16, 17, 4, 3, 5, 2]
    //Example Output
    //
    // [17, 2, 5]
    //Example Explanation
    //
    // Element 17 is strictly greater than all the elements on the right side to it.
    // Element 2 is strictly greater than all the elements on the right side to it.
    // Element 5 is strictly greater than all the elements on the right side to it.
    // So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        //Iterate through right side and compare current and next element and get max element and update in new arrayList

        //16 17 4 3 5 2
        //17 17 5 5 5 2  //From right side and Remove duplicates using HashSet

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(A);

        int N = A.size();

        arrayList.set(N - 1, A.get(N - 1));

        for (int i = N - 2; i >= 0; i--) {
            arrayList.set(i, Math.max(arrayList.get(i + 1), A.get(i)));
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);

        arrayList.clear();
        arrayList.addAll(hashSet);

//        System.out.println(arrayList);
        return arrayList;
    }
}