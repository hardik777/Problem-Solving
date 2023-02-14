package com.demo.scaler.LinkedList;

public class ReverseLinkedListK {
    //Problem Description
    //Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 103
    //
    //B always divides A
    //
    //
    //
    //Input Format
    //The first argument of input contains a pointer to the head of the linked list.
    //
    //The second arugment of input contains the integer, B.
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
    // A = [1, 2, 3, 4, 5, 6]
    // B = 2
    //Input 2:
    //
    // A = [1, 2, 3, 4, 5, 6]
    // B = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // [2, 1, 4, 3, 6, 5]
    //Output 2:
    //
    // [3, 2, 1, 6, 5, 4]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // For the first example, the list can be reversed in groups of 2.
    //    [[1, 2], [3, 4], [5, 6]]
    // After reversing the K-linked list
    //    [[2, 1], [4, 3], [6, 5]]
    //Explanation 2:
    //
    // For the second example, the list can be reversed in groups of 3.
    //    [[1, 2, 3], [4, 5, 6]]
    // After reversing the K-linked list
    //    [[3, 2, 1], [6, 5, 4]]

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head, int K) {
        if (head == null) return null;
        int size = size(head);
        if (size == 1) return head;

        //Base case
        if (size < K) return head;

        //Rec Case
        ListNode temp = head, prev = null, curr = temp;
        int cnt = 0;

        while (cnt < K) {
            ListNode n = curr.next;
            curr.next = prev;

            prev = curr;
            curr = n;
            cnt++;
        }

        if (curr != null) {
            head.next = reverseList(curr, K);
        }
        return prev;
    }

    public static int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
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
