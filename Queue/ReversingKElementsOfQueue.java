package com.demo.scaler.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingKElementsOfQueue {
    //Problem Description
    //Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.
    //
    //NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
    //
    //
    //
    //Problem Constraints
    //1 <= B <= length of the array <= 500000
    //1 <= A[i] <= 100000
    //
    //
    //
    //Input Format
    //The argument given is the integer array A and an integer B.
    //
    //
    //
    //Output Format
    //Return an array of integer after reversing the first B elements of A using queue.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, 5]
    // B = 3
    //Input 2:
    //
    // A = [5, 17, 100, 11]
    // B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // [3, 2, 1, 4, 5]
    //Output 2:
    //
    // [17, 5, 100, 11]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
    //Explanation 2:
    //
    // Reverse first 2 elements so the array becomes [17, 5, 100, 11]

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int K) {
        //Add K elements into stack  //4 5
        //Pop from stack and add into rear of queue // 4 5 3 2 1
        //Remove N-K elements from front and add into rear

        if (K > A.size()) return A;

        Queue<Integer> queue = new LinkedList<>(A);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            stack.push(A.get(i));
            queue.poll();
        }

        while (!stack.empty()) {
            queue.offer(stack.peek());
            stack.pop();
        }

        for (int i = 0; i < A.size() - K; i++) {
            int peek = queue.peek();
            queue.poll();
            queue.offer(peek);
        }
        // System.out.println(queue);
        return new ArrayList<Integer>(queue);
    }
}