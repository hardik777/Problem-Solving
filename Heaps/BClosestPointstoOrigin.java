package com.demo.scaler.Heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class BClosestPointstoOrigin {
    //Problem Description
    //We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
    //
    //Here, the distance between two points on a plane is the Euclidean distance.
    //
    //You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
    //
    //NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
    //
    //
    //
    //Problem Constraints
    //1 <= B <= length of the list A <= 105
    //-105 <= A[i][0] <= 105
    //-105 <= A[i][1] <= 105
    //
    //
    //
    //Input Format
    //The argument given is list A and an integer B.
    //
    //
    //
    //Output Format
    //Return the B closest points to the origin (0, 0) in any order.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [
    //       [1, 3],
    //       [-2, 2]
    //     ]
    // B = 1
    //Input 2:
    //
    // A = [
    //       [1, -1],
    //       [2, -1]
    //     ]
    // B = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // [ [-2, 2] ]
    //Output 2:
    //
    // [ [1, -1] ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
    // So one closest point will be [-2,2].
    //Explanation 2:
    //
    // The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
    // So one closest point will be [1,-1].

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(1, 3)));
                add(new ArrayList<Integer>(Arrays.asList(-2, 2)));
            }
        };
        ArrayList<ArrayList<Integer>> solve = solve(arr, 1);
        System.out.println(solve);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        //We can use MinHeap and store all the points with dist and index
        //and iterate through minHeap and pop B elements

//        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
//        for (int i = 0; i < A.size(); i++) {
//            int x1 = A.get(i).get(0);
//            int y1 = A.get(i).get(1);
//            int eucDist = (x1 * x1) + (y1 * y1);
//            pq.add(new Pair(eucDist, i));
//        }
//
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        while (B-- > 0) {
//            int index = pq.remove().idx;
//            res.add(A.get(index));
//        }
//        return res;

        //---------------------------------------Using Sort(Merge Sort)--------------------------------------
        //Sort both array according to distance and find first B points
        mergesort(A, 0, A.size() - 1);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(B);
        for (int i = 0; i < B; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < B; i++) {
            res.get(i).add(A.get(i).get(0));
            res.get(i).add(A.get(i).get(1));
        }
        return res;
    }

    static void mergesort(ArrayList<ArrayList<Integer>> A, int s, int e) {
        if (s == e) return;
        int mid = (s + e) / 2;
        mergesort(A, s, mid);
        mergesort(A, mid + 1, e);
        merge(A, s, mid, e);
    }

    static void merge(ArrayList<ArrayList<Integer>> A, int s, int mid, int e) {
        int p1 = s, p2 = mid + 1, p3 = 0;
        int count = 0;
        int[][] temp = new int[e - s + 1][2];
        while (p1 <= mid && p2 <= e) {
            long x = (long) A.get(p1).get(0) * A.get(p1).get(0) + (long) A.get(p1).get(1) * A.get(p1).get(1);
            long y = (long) A.get(p2).get(0) * A.get(p2).get(0) + (long) A.get(p2).get(1) * A.get(p2).get(1);
            if (x <= y) {
                temp[p3][0] = A.get(p1).get(0);
                temp[p3][1] = A.get(p1).get(1);
                p1++;
                p3++;
            } else {
                temp[p3][0] = A.get(p2).get(0);
                temp[p3][1] = A.get(p2).get(1);
                p3++;
                p2++;
            }
        }
        while (p1 <= mid) {
            temp[p3][0] = A.get(p1).get(0);
            temp[p3][1] = A.get(p1).get(1);
            p1++;
            p3++;
        }
        while (p2 <= e) {
            temp[p3][0] = A.get(p2).get(0);
            temp[p3][1] = A.get(p2).get(1);
            p2++;
            p3++;
        }

        for (int i = s; i <= e; i++) {
            A.get(i).set(0, temp[i - s][0]);
            A.get(i).set(1, temp[i - s][1]);
        }
    }

    public static class Pair {
        int dist;
        int idx;

        Pair(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }
}
