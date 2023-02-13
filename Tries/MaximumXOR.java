package com.demo.scaler.Tries;

import java.util.ArrayList;

public class MaximumXOR {
    //Problem Description
    //Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
    //
    //
    //
    //Problem Constraints
    //1 <= length of the array <= 100000
    //0 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the maximum result of A[i] XOR A[j].
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, 5]
    //Input 2:
    //
    // A = [5, 17, 100, 11]
    //
    //
    //Example Output
    //Output 1:
    //
    // 7
    //Output 2:
    //
    // 117
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
    //Explanation 2:
    //
    // Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        Trie trie = new Trie();

        //Create trie bits
        for (int x : A) {
            trie.insert(x);
        }

        //find other no from trie which maximize the xor
        int currentMax = 0;
        int ans = 0;

        for (int x : A) {
            currentMax = findCurrentMaxXOR(x, trie.root);
            ans = Math.max(ans, currentMax);
        }
        // System.out.println(ans);
        return ans;
    }

    private static int findCurrentMaxXOR(int x, Node root) {
        Node temp = root;
        int currentAns = 0;

        for (int j = 31; j >= 0; j--) {
            int bit = (x >> j) & 1;

            if (bit == 0) { //find 1 in trie right side to get max xor
                if (temp.right != null) {
                    temp = temp.right;
                    currentAns = currentAns + (1 << j); // means 2^j
                } else {
                    temp = temp.left;
                }
            } else { //find 0 in trie left side to get max xor
                if (temp.left != null) {
                    temp = temp.left;
                    currentAns = currentAns + (1 << j);  // means 2^j
                } else {
                    temp = temp.right;
                }
            }
        }
        return currentAns;
    }

    /**
     * Trie Node for Bit
     */
    public static class Node {
        Node left, right;

        Node() {
            left = right = null;
        }
    }

    /**
     * Create Trie
     */
    public static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int no) {
            Node temp = root;

            for (int j = 31; j >= 0; j--) {
                int bit = (no >> j) & 1;
                if (bit == 0) { // Go left side
                    if (temp.left == null) {
                        temp.left = new Node();
                    }
                    temp = temp.left;
                } else {  // Go right side
                    if (temp.right == null) {
                        temp.right = new Node();
                    }
                    temp = temp.right;
                }
            }
        }
    }
}