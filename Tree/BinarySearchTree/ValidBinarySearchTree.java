package com.demo.scaler.Tree.BinarySearchTree;

public class ValidBinarySearchTree {
    //Problem Description
    //You are given a binary tree represented by root A.
    //
    //Assume a BST is defined as follows:
    //
    //1) The left subtree of a node contains only nodes with keys less than the node's key.
    //
    //2) The right subtree of a node contains only nodes with keys greater than the node's key.
    //
    //3) Both the left and right subtrees must also be binary search trees.
    //
    //
    //
    //Problem Constraints
    //1 <= Number of nodes in binary tree <= 105
    //
    //0 <= node values <= 232-1
    //
    //
    //
    //Input Format
    //First and only argument is head of the binary tree A.
    //
    //
    //
    //Output Format
    //Return 0 if false and 1 if true.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //   1
    //  /  \
    // 2    3
    //Input 2:
    //
    //
    //  2
    // / \
    //1   3
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 2 is not less than 1 but is in left subtree of 1.
    //Explanation 2:
    //
    //Satisfies all conditions.

    public static void main(String[] args) {

    }

    public int isValidBST(TreeNode root) {
        boolean valid = isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // System.out.println(valid);
        return valid ? 1 : 0;
    }

    public static boolean isValid(TreeNode root, int min, int max) {
        //Base case
        /* an empty tree is BST */
        if (root == null)
            return true;

        /* false if this node violates the min/max
         * constraints */
        if (root.val < min || root.val > max)
            return false;

        //Rec case
        if (isValid(root.left, min, root.val - 1)
                && isValid(root.right, root.val + 1, max)) {
            return true;
        }
        return false;
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