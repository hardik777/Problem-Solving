package com.demo.scaler.Tree.BinarySearchTree;

import java.util.ArrayList;

public class CheckForBSTWithOneChild {
    //Problem Description
    //
    //Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= number of nodes <= 100000
    //
    //
    //
    //Input Format
    //
    //First and only argument is an integer array denoting the preorder traversal of binary tree.
    //
    //
    //
    //Output Format
    //
    //Return a string "YES" if true else "NO".
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A : [4, 10, 5, 8]
    //Input 2:
    //
    // A : [1, 5, 6, 4]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // "YES"
    //Output 2:
    //
    // "NO"
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // The possible BST is:
    //            4
    //             \
    //             10
    //             /
    //             5
    //              \
    //              8
    //Explanation 2:
    //
    // There is no possible BST which have the above preorder traversal.

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public String solve(ArrayList<Integer> A) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        TreeNode root = null, node = null;
        for (int i = 0; i < A.size(); i++) {
            if (root == null) {
                root = new TreeNode(A.get(i));
                node = root;
            } else if (A.get(i) > node.val && A.get(i) < max && A.get(i) > min) {//right
                node.right = new TreeNode(A.get(i));
                min = node.val;// [min, max] successive nodes should be in this range
                node = node.right;
            } else if (A.get(i) <= node.val && A.get(i) > min && A.get(i) < max) {
                node.left = new TreeNode(A.get(i));
                max = node.val;
                node = node.left;
            } else {
                return "NO";
            }
        }
        return "YES";

//        int left = Integer.MIN_VALUE;
//        int right = Integer.MAX_VALUE;
//        int root = A.get(0);
//        for (int i = 1; i < A.size(); i++) {
//            if (root < A.get(i)) {
//                left = root;
//            } else {
//                right = root;
//            }
//            if (A.get(i) < left || A.get(i) > right) {
//                return "NO";
//            }
//            root = A.get(i);
//        }
//        return "YES";
    }
}