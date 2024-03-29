package com.demo.scaler.Tree;

public class PathSumFromRootToLeaf {
    //Problem Description
    //Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //-100000 <= B, value of nodes <= 100000
    //
    //
    //
    //Input Format
    //First argument is a root node of the binary tree, A.
    //
    //Second argument is an integer B denoting the sum.
    //
    //
    //
    //Output Format
    //Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // Tree:    5
    //         / \
    //        4   8
    //       /   / \
    //      11  13  4
    //     /  \      \
    //    7    2      1
    //
    // B = 22
    //Input 2:
    //
    // Tree:    5
    //         / \
    //        4   8
    //       /   / \
    //     -11 -13  4
    //
    // B = -1
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
    //Explanation 2:
    //
    // There is no path which has sum -1.

    public static void main(String[] args) {

    }

    public int hasPathSum(TreeNode root, int sum) {
        boolean pathExist = isPathExist(root, sum);
        // System.out.println(pathExist);
        return pathExist ? 1 : 0;
    }

    public static boolean isPathExist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;

        if (root.left == null && root.right == null) {
            return sum == 0 ? true : false;
        }

        return (isPathExist(root.left, sum) || isPathExist(root.right, sum));
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