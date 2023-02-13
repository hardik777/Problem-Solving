package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinarytree {
    //Problem Description
    //Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
    //
    //Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
    //
    //
    //
    //Problem Constraints
    //1 <= Number of nodes in binary tree <= 100000
    //
    //0 <= node values <= 10^9
    //
    //
    //
    //Input Format
    //First and only argument is head of the binary tree A.
    //
    //
    //
    //Output Format
    //Return an array, representing the right view of the binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //            1
    //          /   \
    //         2    3
    //        / \  / \
    //       4   5 6  7
    //      /
    //     8
    //Input 2:
    //
    //
    //            1
    //           /  \
    //          2    3
    //           \
    //            4
    //             \
    //              5
    //
    //
    //Example Output
    //Output 1:
    //
    // [1, 3, 7, 8]
    //Output 2:
    //
    // [1, 3, 4, 5]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Right view is described.
    //Explanation 2:
    //
    //Right view is described.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode root) {
        int maxLevel = 0, currentLevel = 1;
        ArrayList<Integer> arr = new ArrayList<>();

        //Using queue with level and node pair
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, currentLevel));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            currentLevel = poll.level;
            if (currentLevel > maxLevel) {
                maxLevel = currentLevel;
                arr.add(poll.node.val);
            }
            if (poll.node.right != null) {
                queue.offer(new Pair(poll.node.right, currentLevel + 1));
            }
            if (poll.node.left != null) {
                queue.offer(new Pair(poll.node.left, currentLevel + 1));
            }
        }
        // System.out.println(arr);
        return arr;
    }

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
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