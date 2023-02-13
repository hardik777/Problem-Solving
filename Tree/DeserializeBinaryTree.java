package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    //Problem Description
    //You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
    //
    //You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
    //
    //NOTE:
    //
    //In the array, the NULL/None child is denoted by -1.
    //For more clarification check the Example Input.
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //-1 <= A[i] <= 105
    //
    //
    //
    //Input Format
    //Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
    //
    //
    //
    //Output Format
    //Return the root node of the Binary Tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
    //Input 2:
    //
    // A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
    //
    //
    //Example Output
    //Output 1:
    //
    //           1
    //         /   \
    //        2     3
    //       / \
    //      4   5
    //Output 2:
    //
    //            1
    //          /   \
    //         2     3
    //        / \ .   \
    //       4   5 .   6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
    // Since 3, 4 and 5 each has both NULL child we had represented that using -1.
    //Explanation 2:
    //
    // Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
    // Since 3 has left child as NULL while 4 and 5 each has both NULL child.

    public static void main(String[] args) {

    }

    public TreeNode solve(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            int left = A.get(i);
            int right = A.get(i + 1);
            i = i + 2;

            if (left == -1) {
                poll.left = null;
            } else {
                poll.left = new TreeNode(left);
            }

            if (right == -1) {
                poll.right = null;
            } else {
                poll.right = new TreeNode(right);
            }

            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        // System.out.println(root.val);
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