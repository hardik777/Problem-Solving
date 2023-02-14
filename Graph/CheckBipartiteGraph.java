package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteGraph {
    //Problem Description
    //Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
    //
    //Find whether the given graph is bipartite or not.
    //
    //A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
    //
    //Note:
    //
    //There are no self-loops in the graph.
    //
    //No multiple edges between two pair of vertices.
    //
    //The graph may or may not be connected.
    //
    //Nodes are Numbered from 0 to A-1.
    //
    //Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 100000
    //
    //1 <= M <= min(A*(A-1)/2,200000)
    //
    //0 <= B[i][0],B[i][1] < A
    //
    //
    //
    //Input Format
    //The first argument given is an integer A.
    //
    //The second argument given is the matrix B.
    //
    //
    //
    //Output Format
    //Return 1 if the given graph is bipartide else return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = 2
    //B = [ [0, 1] ]
    //Input 2:
    //
    //A = 3
    //B = [ [0, 1], [0, 2], [1, 2] ]
    //
    //
    //Example Output
    //Output 1:
    //
    //1
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Put 0 and 1 into 2 different subsets.
    //Explanation 2:
    //
    //
    //It is impossible to break the graph down to make two different subsets for bipartite matching

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 1)));
            }
        };
        int solve = solve(2, arr);
        System.out.println(solve);
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] visited = new int[A];
        ArrayList<Integer>[] list = createList(A, B);
        for (int i = 0; i < A; i++) {
            if (visited[i] == 0) {
                if (bfs(i, list, visited) == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static int bfs(int node, ArrayList<Integer>[] list, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            int frontCol = visited[front];
            for (int i = 0; i < list[front].size(); i++) {
                int neighbour = list[front].get(i);
                int neighbourCol = visited[neighbour];
                if (neighbourCol == 0) {
                    visited[neighbour] = (frontCol == 1) ? 2 : 1;
                    queue.add(neighbour);
                } else {
                    if (frontCol == neighbourCol) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static ArrayList<Integer>[] createList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] res = new ArrayList[A];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < B.size(); i++) {
            res[B.get(i).get(0)].add(B.get(i).get(1));
            res[B.get(i).get(1)].add(B.get(i).get(0));
        }
        return res;
    }
}
