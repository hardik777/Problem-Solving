package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalSort {
    //Problem Description
    //Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
    //
    //Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
    //
    //Return the topological ordering of the graph and if it doesn't exist then return an empty array.
    //
    //If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
    //
    //Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
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
    //2 <= A <= 104
    //
    //1 <= M <= min(100000,A*(A-1))
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
    //Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 6
    // B = [  [6, 3]
    //        [6, 1]
    //        [5, 1]
    //        [5, 2]
    //        [3, 4]
    //        [4, 2] ]
    //Input 2:
    //
    // A = 3
    // B = [  [1, 2]
    //        [2, 3]
    //        [3, 1] ]
    //
    //
    //Example Output
    //Output 1:
    //
    // [5, 6, 1, 3, 4, 2]
    //Output 2:
    //
    // []
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
    //Explanation 2:
    //
    // The given graph contain cycle so topological ordering not possible we will return empty array.

    public static void main(String[] args) {

    }

    //First Create Adj. List and inDegree array with default all degree is 0
    //Create Queue and add all 0 degree into Queue
    //pop each node and decrese dependency by 1 and if 0 then add into Queue
    //At the end if all nodes visited then Topological Sorting found

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] inDegreeArr = new int[A + 1];
        ArrayList<Integer>[] list = new ArrayList[A + 1];

        //Create Adj list and InDegree Array
        createListAndInDegreeArr(A, B, list, inDegreeArr);

        //Create PriorityQueue and first add all 0 dependency element
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < inDegreeArr.length; i++) {
            if (inDegreeArr[i] == 0) {
                queue.add(i);
            }
        }
        //pop element from queue and decrease dependency of element by -1 and remove that edge
        //if dependency becomes 0 then add into queue.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int front = queue.poll();
            ans.add(front);
            for (int i = 0; i < list[front].size(); i++) {
                int neighbour = list[front].get(i);
                inDegreeArr[neighbour]--;
                if (inDegreeArr[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (ans.size() < A) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>(A);
        for (int i = 0; i < ans.size(); i++) {
            res.add(ans.get(i));
        }
        // System.out.println(res);
        return res;
    }

    public static void createListAndInDegreeArr(int A, ArrayList<ArrayList<Integer>> B, ArrayList<Integer>[] list, int[] inDegreeArr) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < B.size(); i++) {
            list[B.get(i).get(0)].add(B.get(i).get(1));
            inDegreeArr[B.get(i).get(1)]++;
        }
    }
}