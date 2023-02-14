package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeInMST {
    //Problem Description
    //
    //Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
    //
    //For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.
    //
    //Return an one-dimensional binary array of size M denoting answer for each edge.
    //
    //NOTE:
    //
    //The graph may be disconnected in that case consider mst for each component.
    //No self-loops and no multiple edges present.
    //Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].
    //
    //
    //Problem Constraints
    //
    //1 <= A, M <= 3*105
    //
    //1 <= B[i][0], B[i][1] <= A
    //
    //1 <= B[i][1] <= 103
    //
    //
    //
    //Input Format
    //
    //The first argument given is an integer A representing the number of nodes in the graph.
    //
    //The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].
    //
    //
    //
    //Output Format
    //
    //Return an one-dimensional binary array of size M denoting answer for each edge.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = 3
    // B = [ [1, 2, 2]
    //       [1, 3, 2]
    //       [2, 3, 3]
    //     ]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // [1, 1, 0]
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // Edge (1, 2) with weight 2 is included in the MST           1
    //                                                          /   \
    //                                                         2     3
    // Edge (1, 3) with weight 2 is included in the same MST mentioned above.
    // Edge (2,3) with weight 3 cannot be included in any of the mst possible.
    // So we will return [1, 1, 0]

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        //Using Krushkal Algo
        //1. Create Adj. list from B by adding node u,v,w
        //2. Sort list by weight
        //3. Create Parent Array for A nodes and set by default parent of each element itself
        //4. Iterate over Adj. list array and check if parent of both u and v are different then consider taking that edge (Union) and
        //replace higher element's parent by smaller element's parent.
        //This is called Union and Find Algo

//        int totalWeight = 0;
        List<Node> adjList = new ArrayList<Node>();
        int bLen = B.size();

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < bLen; i++) {
            ans.add(0);
        }

        //filling up the adjacency list
        for (int i = 0; i < bLen; i++) {
            Node n = new Node(B.get(i).get(0), B.get(i).get(1), B.get(i).get(2), i);
            adjList.add(n);
        }

        int[] parent = new int[A + 1];
        //initially each node is parent of itself
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        //Sort according to weight
        adjList.sort((o1, o2) -> o1.w - o2.w);

        //loop through sorted adjacency list and extract vertices u, v and weights. Find the parent of u and v,
        //if they belong to diff parent consider taking that edge (Union) and replace the parent of higher node
        //with smaller node's parent. This is called Union and Find Algo

        for (int i = 0; i < bLen; i++) {
            Node node = adjList.get(i);
            int u = node.u;
            int v = node.v;
            int w = node.w;
            int index = node.index;

            int parent_u = findParent(u, parent);
            int parent_v = findParent(v, parent);

            if (parent_u != parent_v) {
                parent[Math.max(parent_u, parent_v)] = Math.min(parent_u, parent_v);
//                totalWeight += w;
                ans.set(index, 1);
            }
        }
        return ans;
    }

    static int findParent(int node, int[] Parent) {
        if (node == Parent[node]) {
            return node;
        }

        Parent[node] = findParent(Parent[node], Parent);

        return Parent[node];
    }

    static class Node {
        int u, v, w, index;

        public Node(int u, int v, int w, int index) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.index = index;
        }
    }
}