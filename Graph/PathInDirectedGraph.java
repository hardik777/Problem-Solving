package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {
    //Problem Description
    //Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
    //
    //B[i][0] to node B[i][1].
    //
    //Find whether a path exists from node 1 to node A.
    //
    //Return 1 if path exists else return 0.
    //
    //NOTE:
    //
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
    //Return 1 if path exists between node 1 to node A else return 0.
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
    // 0
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The given doens't contain any path from node 1 to node 5 so we will return 0.
    //Explanation 2:
    //
    // Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.

    public static void main(String[] args) {

    }

    //Create Adj. List
    //Starts from 1 node and using Queue Iterate thorugh all the children
    //During this if A node found then return 1 else at the end return 0
    
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();
    static int ans = 0;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited = new HashSet<>();
        map = new HashMap<>();
        ans = 0;
        createAdjacentList(A, B);
        findUsingQueue(1, A);
        return ans;
    }

    private static void findUsingQueue(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int pop = queue.poll();
            visited.add(pop);

            ArrayList<Integer> arrayList = map.get(pop);
            for (Integer children : arrayList) {
                if (children == end) {
                    ans = 1;
                    return;
                }
                if (!visited.contains(children)) {
                    queue.add(children);
                }
            }
        }
    }

    private static void createAdjacentList(int A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 1; i <= A; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> arrayList = map.get(B.get(i).get(0));
            arrayList.add(B.get(i).get(1));
            map.put(B.get(i).get(0), arrayList);
        }
    }
}