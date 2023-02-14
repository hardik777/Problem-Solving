package com.demo.scaler.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class FindAllSubsets {
    //Problem Description
    //Given a set of distinct integers A, return all possible subsets.
    //
    //NOTE:
    //
    //Elements in a subset must be in non-descending order.
    //The solution set must not contain duplicate subsets.
    //Also, the subsets should be sorted in ascending ( lexicographic ) order.
    //The list is not necessarily sorted.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 16
    //INTMIN <= A[i] <= INTMAX
    //
    //
    //Input Format
    //First and only argument of input contains a single integer array A.
    //
    //
    //
    //Output Format
    //Return a vector of vectors denoting the answer.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1]
    //Input 2:
    //
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //Output 1:
    //
    //[
    //    []
    //    [1]
    //]
    //Output 2:
    //
    //[
    // []
    // [1]
    // [1, 2]
    // [1, 2, 3]
    // [1, 3]
    // [2]
    // [2, 3]
    // [3]
    //]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // You can see that these are all possible subsets.
    //Explanation 2:
    //
    //You can see that these are all possible subsets.

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);

        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());

        findAllSubsets(A, 0, curr, res);

        // System.out.println(res);
        return res;
    }

    public static void findAllSubsets(ArrayList<Integer> A, int i, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        //base case
        if (i == A.size()) {
            return;
        }

        //Rec case
        //include i-th element and do the work for remaining
        curr.add(A.get(i));
        res.add(new ArrayList(curr));
        findAllSubsets(A, i + 1, curr, res);

        //exclude i-th element and do the work for remaining
        curr.remove(curr.size() - 1);
        findAllSubsets(A, i + 1, curr, res);
    }
}