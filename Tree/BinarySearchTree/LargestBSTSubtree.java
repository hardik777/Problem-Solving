package com.demo.scaler.Tree.BinarySearchTree;

public class LargestBSTSubtree {
    //Problem Description
    //You are given a Binary Tree A with N nodes.
    //
    //Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
    //
    //If the complete Binary Tree is BST, then return the size of the whole tree.
    //
    //NOTE:
    //
    //The largest subtree is the subtree with the most number of nodes.
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //
    //
    //
    //Input Format
    //First and only argument is an pointer to root of the binary tree A.
    //
    //
    //
    //Output Format
    //Return an single integer denoting the size of the largest subtree which is also a BST.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //     10
    //    / \
    //   5  15
    //  / \   \
    // 1   8   7
    //Input 2:
    //
    //     5
    //    / \
    //   3   8
    //  / \ / \
    // 1  4 7  9
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 7
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Largest BST subtree is
    //                            5
    //                           / \
    //                          1   8
    //Explanation 2:
    //
    // Given binary tree itself is BST.

    public static void main(String[] args) {

    }

    public int solve(TreeNode A) {
        int largestBSTSize = getLargestBSTSize(A);
        // System.out.println(largestBSTSize);
        return largestBSTSize;
    }

    public static int getLargestBSTSize(TreeNode node) {
        //Base case
        if (node == null) return 0;

        if (isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return getSize(node);
        }

        return Math.max(getLargestBSTSize(node.left), getLargestBSTSize(node.right));
    }

    public static boolean isValidBST(TreeNode root, int min, int max) {
        //Base case
        if (root == null) return true;

        //If root value is not in the left and right bounds then return false
        if (root.val < min || root.val > max) return false;

        return (isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max));
    }

    public static int getSize(TreeNode root) {
        //Base case
        if (root == null) return 0;

        return 1 + getSize(root.left) + getSize(root.right);
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

}