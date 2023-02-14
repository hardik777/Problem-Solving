package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleInDirectedGraph {
    //Problem Description
    //Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
    //
    //Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
    //
    //NOTE:
    //
    //The cycle must contain atleast two nodes.
    //There are no self-loops in the graph.
    //There are no multiple edges between two nodes.
    //The graph may or may not be connected.
    //Nodes are numbered from 1 to A.
    //Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
    //
    //
    //Problem Constraints
    //2 <= A <= 105
    //
    //1 <= M <= min(200000,A*(A-1))
    //
    //1 <= B[i][0], B[i][1] <= A
    //
    //
    //
    //Input Format
    //The first argument given is an integer A representing the number of nodes in the graph.
    //
    //The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
    //
    //
    //
    //Output Format
    //Return 1 if cycle is present else return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 5
    // B = [  [1, 2]
    //        [4, 1]
    //        [2, 4]
    //        [3, 4]
    //        [5, 2]
    //        [1, 3] ]
    //Input 2:
    //
    // A = 5
    // B = [  [1, 2]
    //        [2, 3]
    //        [3, 4]
    //        [4, 5] ]
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
    // The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
    //Explanation 2:
    //
    // The given graph doesn't contain any cycle.

    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] list = new ArrayList[A + 1];

        //Create Adj list
        createAdjList(B, list);

        //Maintain Stack array and visited array
        //If any element find which is already in the stack then cycle detect
        //When there are no child found of any nbr then remove from stack

        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);

        boolean[] stack = new boolean[A + 1];
        Arrays.fill(stack, false);

        boolean isCycle = dfsForCycle(1, visited, stack, list);
        return isCycle ? 1 : 0;
    }

    public static void createAdjList(ArrayList<ArrayList<Integer>> B, ArrayList<Integer>[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList();
        }
        for (int i = 0; i < B.size(); i++) {
            list[B.get(i).get(0)].add(B.get(i).get(1));
        }
    }

    public static boolean dfsForCycle(int node, boolean[] visited, boolean[] stack, ArrayList<Integer>[] list) {
        //Base case
        if (stack[node] == true) {  //If already in the stack and must be visited
            return true;
        }

        if (visited[node] == true) {  //If already visited but not in the stack
            return false;
        }

        //Rec Case
        visited[node] = true;
        stack[node] = true;

        for (int nbr : list[node]) {
            if (dfsForCycle(nbr, visited, stack, list)) {
                return true;
            }
        }
        stack[node] = false;  //Backtracking
        return false;
    }
}