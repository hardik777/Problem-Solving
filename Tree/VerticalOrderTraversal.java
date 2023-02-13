package com.demo.scaler.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {
    //Problem Description
    //Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
    //
    //
    //NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
    //
    //
    //
    //Problem Constraints
    //0 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First and only arument is a pointer to the root node of binary tree, A.
    //
    //
    //
    //Output Format
    //Return a 2D array denoting the vertical order traversal of tree as shown.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //      6
    //    /   \
    //   3     7
    //  / \     \
    // 2   5     9
    //Input 2:
    //
    //      1
    //    /   \
    //   3     7
    //  /       \
    // 2         9
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //    [2],
    //    [3],
    //    [6, 5],
    //    [7],
    //    [9]
    // ]
    //Output 2:
    //
    // [
    //    [2],
    //    [3],
    //    [1],
    //    [7],
    //    [9]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // First row represent the verical line 1 and so on.

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

    static ArrayList<Integer> arr = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();  //dist,array
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();

            if (map.containsKey(poll.dist)) {
                ArrayList<Integer> temp = map.get(poll.dist);
                temp.add(poll.node.val);
                map.put(poll.dist, temp);
            } else {
                arr = new ArrayList<>();
                arr.add(poll.node.val);
                map.put(poll.dist, arr);
            }

            if (poll.node.left != null) {
                queue.offer(new Pair(poll.node.left, poll.dist - 1));
            }
            if (poll.node.right != null) {
                queue.offer(new Pair(poll.node.right, poll.dist + 1));
            }
        }
        // System.out.println(map);

        //find min and max distance
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        // System.out.println(min + "," + max);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
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
