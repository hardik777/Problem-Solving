package com.demo.scaler.SubsetORSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FindAllSubsets {
    //Problem Description
    //Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
    //
    //NOTE:
    //
    //Elements in a subset must be in non-descending order.
    //The solution set must not contain duplicate subsets.
    //The subsets must be sorted lexicographically.
    //
    //
    //Problem Constraints
    //0 <= N <= 16
    //
    //
    //
    //Input Format
    //Only argument is an integer array A of size N.
    //
    //
    //
    //Output Format
    //Return a 2-D vector denoting all the possible subsets.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 2]
    //Input 2:
    //
    // A = [1, 1]
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //    [],
    //    [1],
    //    [1, 2],
    //    [1, 2, 2],
    //    [2],
    //    [2, 2]
    // ]
    //Output 2:
    //
    // [
    //    [],
    //    [1],
    //    [1, 1]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //All the subsets of the array [1, 2, 2] in lexicographically sorted order.

    public static void main(String[] args) {

    }

    static ArrayList<ArrayList<Integer>> ans;

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        findSubset(A, 0, A.size(), list, hs);
        return ans;
    }

    public static void findSubset(ArrayList<Integer> A, int index, int size, ArrayList<Integer> curr, HashSet<ArrayList<Integer>> hs) {

        if (index == size) {
            return;
        }

        // Take It -- Include
        curr.add(A.get(index));
        if (!hs.contains(curr)) {
            ans.add(new ArrayList<>(curr));
            hs.add(curr);
        }
        findSubset(A, index + 1, size, curr, hs);

        // Don't Take it -- Not Include
        curr.remove(curr.size() - 1);
        findSubset(A, index + 1, size, curr, hs);
    }

}