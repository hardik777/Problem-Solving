package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {
    //Problem Description
    //Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
    //
    //The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
    //
    //Return the nodes in any order.
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
    //Return an array, representing the top view of the binary tree.
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
    // [1, 2, 4, 8, 3, 7]
    //Output 2:
    //
    // [1, 2, 3]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Top view is described.
    //Explanation 2:
    //
    //Top view is described.

    public static void main(String[] args) {

    }

    static class Pair {
        TreeNode node;
        int dist;

        public Pair(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    //For top view, Only nodes which have unique distance are considerable.
    //For example, Distance of root = 0 and left nodes = dist - 1 and right nodes = dist + 1
    //So for each level order traversal we need to Create HashMap<Dist, TreeNode> for unique distance

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (!map.containsKey(poll.dist)) {
                map.put(poll.dist, poll.node);
                arr.add(poll.node.val);
            }
            if (poll.node.left != null) {
                queue.offer(new Pair(poll.node.left, poll.dist - 1));
            }
            if (poll.node.right != null) {
                queue.offer(new Pair(poll.node.right, poll.dist + 1));
            }
        }
//        System.out.println(arr);
        return arr;
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