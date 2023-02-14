package com.demo.scaler.Hashing;

import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {
    //Problem Description
    //Given an unsorted integer array A of size N.
    //
    //Find the length of the longest set of consecutive elements from array A.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 106
    //
    //-106 <= A[i] <= 106
    //
    //
    //
    //Input Format
    //First argument is an integer array A of size N.
    //
    //
    //
    //Output Format
    //Return an integer denoting the length of the longest set of consecutive elements from the array A.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [100, 4, 200, 1, 3, 2]
    //Input 2:
    //
    //A = [2, 1]
    //
    //
    //Example Output
    //Output 1:
    //
    // 4
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The set of consecutive elements will be [1, 2, 3, 4].
    //Explanation 2:
    //
    // The set of consecutive elements will be [1, 2].

    public static void main(String[] args) {

    }

    public int longestConsecutive(final List<Integer> A) {
        // Hash all the array elements
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            set.add(A.get(i));
        }

        // check each possible sequence from the start then update optimal length
        int ans = 0, count = 0;
        for (Integer value : set) {
            // if current element is the starting element of a sequence
            // by checking if previous element not found
            if (!set.contains(value - 1)) {
                // Then check for next elements in the sequence
                count = 0;
                int temp = value;
                while (set.contains(temp)) {
                    temp++;
                    count++;
                }
                //Update max
                ans = Math.max(ans, count);
            }
        }
        // System.out.println(ans);
        return ans;
    }
}