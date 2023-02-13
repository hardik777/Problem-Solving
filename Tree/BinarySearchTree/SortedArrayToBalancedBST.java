package com.demo.scaler.Tree.BinarySearchTree;

public class SortedArrayToBalancedBST {
    //Problem Description
    //Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
    //
    //Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    //
    //
    //
    //Problem Constraints
    //1 <= length of array <= 100000
    //
    //
    //
    //Input Format
    //First argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return a root node of the Binary Search Tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A : [1, 2, 3]
    //Input 2:
    //
    // A : [1, 2, 3, 5, 10]
    //
    //
    //Example Output
    //Output 1:
    //
    //      2
    //    /   \
    //   1     3
    //Output 2:
    //
    //      3
    //    /   \
    //   2     5
    //  /       \
    // 1         10

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(final int[] arr) {
        //Find mid with s and e pointers and create root node
        //attach left node from s, mid-1 and right node from mid+1,e

        TreeNode root = arrayToBST(arr, 0, arr.length - 1);
        //System.out.println(root.val);
        return root;
    }

    public static TreeNode arrayToBST(final int[] arr, int s, int e) {
        //Base case
        if (s > e) {
            return null;
        }

        //Rec case
        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBST(arr, s, mid - 1);
        root.right = arrayToBST(arr, mid + 1, e);

        return root;
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