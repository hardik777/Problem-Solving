package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT {
    //Problem Description
    //Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First and only argument is root node of the binary tree, A.
    //
    //
    //
    //Output Format
    //Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //Input 2:
    //
    //   1
    //  / \
    // 6   2
    //    /
    //   3
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //   [3],
    //   [20, 9],
    //   [15, 7]
    // ]
    //Output 2:
    //
    // [
    //   [1]
    //   [2, 6]
    //   [3]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Return the 2D array. Each row denotes the zigzag traversal of each level.

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                arr.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (!isOdd) {
//                Collections.reverse(arr);
                reverseArray(arr);
            }
            res.add(arr);
            isOdd = !isOdd;
            // System.out.println(arr);
        }
        return res;
    }

    public static void reverseArray(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n / 2; i++) {
            int temp = arr.get(i);
            arr.set(i, arr.get(n - 1 - i));
            arr.set(n - i - 1, temp);
        }
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