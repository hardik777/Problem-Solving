package com.demo.scaler.LinkedList;

public class ReverseLinkedListII {
    //Problem Description
    //Reverse a linked list A from position B to C.
    //
    //NOTE: Do it in-place and in one-pass.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 106
    //
    //1 <= B <= C <= |A|
    //
    //
    //
    //Input Format
    //The first argument contains a pointer to the head of the given linked list, A.
    //
    //The second arugment contains an integer, B.
    //
    //The third argument contains an integer C.
    //
    //
    //
    //Output Format
    //Return a pointer to the head of the modified linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 1 -> 2 -> 3 -> 4 -> 5
    // B = 2
    // C = 4
    //
    //Input 2:
    //
    // A = 1 -> 2 -> 3 -> 4 -> 5
    // B = 1
    // C = 5
    //
    //
    //Example Output
    //Output 1:
    //
    // 1 -> 4 -> 3 -> 2 -> 5
    //Output 2:
    //
    // 5 -> 4 -> 3 -> 2 -> 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
    // Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
    //Explanation 2:
    //
    // In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
    // Thus, the output is 5 -> 4 -> 3 -> 2 -> 1

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        // base case
        if (m >= n) return head;

        // 1. Skip the first `m` nodes
        ListNode prev = null, curr = head;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        // `prev` now points to (m-1)'th node
        // `curr` now points to m'th node

        ListNode start = curr;
        ListNode end = null;

        // 2. Traverse and reverse the sublist from position `m` to `n`
        i = 1;
        while (i <= n - m + 1 && curr != null) {
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
            i++;
        }

        /*
            `start` points to the m'th node
            `end` now points to the n'th node
            `curr` now points to the (n+1)'th node
        */

        // 3. Fix the pointers and return the head node
        if (start != null) {
            start.next = curr;
            if (prev != null) {
                prev.next = end;
            } else {
                head = end;   // when m = 1, `prev` is null
            }
        }
        return head;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}