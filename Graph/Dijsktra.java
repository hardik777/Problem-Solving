package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijsktra {
    //Problem Description
    //Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
    //
    //You have to find an integer array D of size A such that:
    //
    //=> D[i] : Shortest distance form the C node to node i.
    //
    //=> If node i is not reachable from C then -1.
    //
    //Note:
    //
    //There are no self-loops in the graph.
    //
    //No multiple edges between two pair of vertices.
    //
    //The graph may or may not be connected.
    //
    //Nodes are numbered from 0 to A-1.
    //
    //Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 1e5
    //
    //0 <= B[i][0],B[i][1] < A
    //
    //0 <= B[i][2] <= 1e3
    //
    //0 <= C < A
    //
    //
    //
    //Input Format
    //The first argument given is an integer A, representing the number of nodes.
    //
    //The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
    //
    //The third argument given is an integer C.
    //
    //
    //
    //Output Format
    //Return the integer array D.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = 6
    //B = [   [0, 4, 9]
    //        [3, 4, 6]
    //        [1, 2, 1]
    //        [2, 5, 1]
    //        [2, 4, 5]
    //        [0, 3, 7]
    //        [0, 1, 1]
    //        [4, 5, 7]
    //        [0, 5, 1] ]
    //C = 4
    //Input 2:
    //
    //A = 5
    //B = [   [0, 3, 4]
    //        [2, 3, 3]
    //        [0, 1, 9]
    //        [3, 4, 10]
    //        [1, 3, 8]  ]
    //C = 4
    //
    //
    //Example Output
    //Output 1:
    //
    //D = [7, 6, 5, 6, 0, 6]
    //Output 2:
    //
    //D = [14, 18, 13, 10, 0]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // All Paths can be considered from the node C to get shortest path
    //Explanation 2:
    //
    // All Paths can be considered from the node C to get shortest path

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 4, 9)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 5)));
                add(new ArrayList<Integer>(Arrays.asList(0, 3, 7)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
                add(new ArrayList<Integer>(Arrays.asList(4, 5, 7)));
                add(new ArrayList<Integer>(Arrays.asList(0, 5, 1)));
            }
        };

        ArrayList<Integer> solve = solve(6, B, 4);
        System.out.println(solve);
    }

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        //Build buildAdjList using Pair(node,weight)
        //Take PriorityQueue minHeap with min distance comparator
        //Take One dist[] array for managing dist
        //Iterate through minHeap and poll element and calculate children distance and update in dist[] array

        ArrayList<Pair>[] graph = buildAdjList(B, A);
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[C] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p1.weight - p2.weight);
        minHeap.add(new Pair(C, 0)); // node, distance

        while (minHeap.size() > 0) {
            Pair pair = minHeap.poll();
            int u = pair.node;
            int d = pair.weight;
            if (dist[u] == d) {
                for (int i = 0; i < graph[u].size(); i++) {
                    Pair p = graph[u].get(i);
                    int v = p.node;
                    int w = p.weight;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        minHeap.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            res.add(dist[i]);
        }
        return res;
    }

    static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    private static ArrayList<Pair>[] buildAdjList(ArrayList<ArrayList<Integer>> matrix, int noOfnodes) {
        ArrayList<Pair>[] graph = new ArrayList[noOfnodes];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < matrix.size(); i++) {
            int u = matrix.get(i).get(0);
            int v = matrix.get(i).get(1);
            int w = matrix.get(i).get(2);

            //undirected graph
            Pair p = new Pair(v, w);
            ArrayList<Pair> currList = graph[u];
            currList.add(p);

            Pair p2 = new Pair(u, w);
            ArrayList<Pair> currList2 = graph[v];
            currList2.add(p2);
        }

        return graph;
    }
}