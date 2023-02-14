package com.demo.scaler.Backtracking;

import java.util.ArrayList;

public class Permutations {
    //Problem Description
    //Given an integer array A of size N denoting collection of numbers , return all possible permutations.
    //
    //NOTE:
    //
    //No two entries in the permutation sequence should be the same.
    //For the purpose of this problem, assume that all the numbers in the collection are unique.
    //Return the answer in any order
    //WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    //Example : next_permutations in C++ / itertools.permutations in python.
    //If you do, we will disqualify your submission retroactively and give you penalty points.
    //
    //
    //Problem Constraints
    //1 <= N <= 9
    //
    //
    //
    //Input Format
    //Only argument is an integer array A of size N.
    //
    //
    //
    //Output Format
    //Return a 2-D array denoting all possible permutation of the array.
    //
    //
    //
    //Example Input
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //[ [1, 2, 3]
    //  [1, 3, 2]
    //  [2, 1, 3]
    //  [2, 3, 1]
    //  [3, 1, 2]
    //  [3, 2, 1] ]
    //
    //
    //Example Explanation
    //All the possible permutation of array [1, 2, 3].

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findAllPermutations(A, 0, res);
        //System.out.println(res);
        return res;
    }

    public static void findAllPermutations(ArrayList<Integer> A, int i, ArrayList<ArrayList<Integer>> res) {
        //Base case
        if (i == A.size() - 1) {
            res.add(new ArrayList<>(A));
            return;
        }

        for (int j = i; j < A.size(); j++) {
            swap(A, i, j);  //swap A[i] = A[j]
            findAllPermutations(A, i + 1, res);
            swap(A, i, j);  //swap A[i] = A[j]
        }
    }

    public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}