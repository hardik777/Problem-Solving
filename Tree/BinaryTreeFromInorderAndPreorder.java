package com.demo.scaler.Tree;

import com.demo.scaler.Tree.BinarySearchTree.ValidBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPreorder {
    //Problem Description
    //Given the inorder and postorder traversal of a tree, construct the binary tree.
    //
    //NOTE: You may assume that duplicates do not exist in the tree.
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First argument is an integer array A denoting the inorder traversal of the tree.
    //
    //Second argument is an integer array B denoting the postorder traversal of the tree.
    //
    //
    //
    //Output Format
    //Return the root node of the binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [2, 1, 3]
    // B = [2, 3, 1]
    //Input 2:
    //
    // A = [6, 1, 3, 2]
    // B = [6, 3, 2, 1]
    //
    //
    //Example Output
    //Output 1:
    //
    //   1
    //  / \
    // 2   3
    //Output 2:
    //
    //   1
    //  / \
    // 6   2
    //    /
    //   3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Create the binary tree and return the root node of the tree.

    public static void main(String[] args) {

    }

    static HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(ArrayList<Integer> inArray, ArrayList<Integer> postArray) {
        int pStart = 0, pEnd = postArray.size() - 1; //postorder -> Left Right Root
        int iStart = 0, iEnd = inArray.size() - 1; //inorder -> Left Root Right

        inOrderMap = new HashMap<>();
        for (int i = 0; i < inArray.size(); i++) {
            inOrderMap.put(inArray.get(i), i);
        }
        return construct(postArray, pStart, pEnd, inArray, iStart, iEnd);
    }

    public static TreeNode construct(ArrayList<Integer> post, int ps, int pe, ArrayList<Integer> in, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }

        int rootVal = post.get(pe);
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inOrderMap.get(rootVal); //get inorder index of the root
        int numLst = rootIndex - is;

        //calculating the start and end index for postorder & inorder
        root.left = construct(post, ps, ps + numLst - 1, in, is, rootIndex - 1);
        root.right = construct(post, ps + numLst, pe - 1, in, rootIndex + 1, ie);

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