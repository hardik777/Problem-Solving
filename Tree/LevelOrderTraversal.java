package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    //Problem Description
    //Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
    //   [9, 20],
    //   [15, 7]
    // ]
    //Output 2:
    //
    // [
    //   [1]
    //   [6, 2]
    //   [3]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Return the 2D array. Each row denotes the traversal of each level.

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) return res;

        ArrayList<Integer> arr = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            arr = new ArrayList<>();

            int size = queue.size();
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
            res.add(arr);
        }
        // System.out.println(res);
        return res;
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