package com.demo.scaler.Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {
    //Problem Description
    //N people having different priorities are standing in a queue.
    //
    //The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
    //
    //Your task is to sort the queue in the increasing order of priorities.
    //
    //NOTE:
    //
    //No two persons can have the same priority.
    //Use the property of the queue to sort the queue with complexity O(NlogB).
    //
    //
    //Problem Constraints
    //1 <= N <= 100000
    //0 <= B <= N
    //
    //
    //
    //Input Format
    //The first argument is an integer array A representing the priorities and initial order of N persons.
    //The second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return an integer array representing the sorted queue.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 40, 2, 3]
    // B = 2
    //Input 2:
    //
    // A = [2, 1, 17, 10, 21, 95]
    // B = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // [1, 2, 3, 40]
    //Output 2:
    //
    // [1, 2, 10, 17, 21, 95]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Given array A = [1, 40, 2, 3]
    // After sorting, A = [1, 2, 3, 40].
    // We can see that difference between initial position of elements amd the final position <= 2.
    //Explanation 2:
    //
    // After sorting, the array becomes [1, 2, 10, 17, 21, 95].

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        //For maintain difference of B we have to take B length array each time and get min element and store into Min Heap for ASC sort.
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();

        //add first B elements
        for (int i = 0; i < B + 1; i++) {
            minPQ.add(A.get(i));
        }

        //add remaining elements into min heap and get min each time and add into res array
        for (int i = B + 1; i < A.size(); i++) {
            res.add(minPQ.poll());
            minPQ.add(A.get(i));
        }

        //Add remaining elements from minPQ into res
        while (!minPQ.isEmpty()) {
            res.add(minPQ.poll());
        }

        // System.out.println(res);
        return res;
    }
}