package com.demo.scaler.Graph;

import java.util.ArrayList;

public class FirstDepthFirstSearch {
    //Problem Description
    //You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
    //
    //Given 2 towns find whether you can reach the first town from the second without repeating any edge.
    //
    //B C : query to find whether B is reachable from C.
    //
    //Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
    //
    //There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
    //
    //NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 100000
    //
    //
    //
    //Input Format
    //First argument is vector A
    //
    //Second argument is integer B
    //
    //Third argument is integer C
    //
    //
    //
    //Output Format
    //Return 1 if reachable, 0 otherwise.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 1, 2]
    // B = 1
    // C = 2
    //Input 2:
    //
    // A = [1, 1, 2]
    // B = 2
    // C = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
    //Explanation 2:
    //
    // Tree is 1--> 2--> 3 and hence 2 is reachable from 1.

    public static void main(String[] args) {

    }

    //Create Adj. List for each directed edge
    //Create visited array and start from C node and run DFS for each node
    //If at the end if B is visited found in visited array then possible else not.
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<Integer>[] adj = adjacency(A);
        boolean[] vis = new boolean[A.size() + 1];

        dfs(adj, C, vis);

        return vis[B] ? 1 : 0;

    }

    public void dfs(ArrayList<Integer>[] adj, int s, boolean[] vis) {
        //Base case
        if (vis[s] == true)
            return;

        vis[s] = true;

        for (int i = 0; i < adj[s].size(); i++) {
            int n = adj[s].get(i);
            if (vis[n] == false)
                dfs(adj, n, vis);
        }
    }

    public ArrayList<Integer>[] adjacency(ArrayList<Integer> A) {

        ArrayList<Integer>[] adj = new ArrayList[A.size() + 1];

        for (int i = 0; i <= A.size(); i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < A.size(); i++) {

            int source = A.get(i);
            adj[source].add(i + 1);
        }
        return adj;
    }
}
