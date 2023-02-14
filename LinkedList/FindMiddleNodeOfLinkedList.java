package com.demo.scaler.LinkedList;

public class FindMiddleNodeOfLinkedList {
    //Problem Description
    //Given a linked list of integers, find and return the middle element of the linked list.
    //
    //NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
    //
    //
    //
    //Problem Constraints
    //1 <= length of the linked list <= 100000
    //
    //1 <= Node value <= 109
    //
    //
    //
    //Input Format
    //The only argument given head pointer of linked list.
    //
    //
    //
    //Output Format
    //Return the middle element of the linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // 1 -> 2 -> 3 -> 4 -> 5
    //Input 2:
    //
    // 1 -> 5 -> 6 -> 2 -> 3 -> 4
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The middle element is 3.
    //Explanation 2:
    //
    // The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.

    public static void main(String[] args) {

    }

    public int solve(ListNode head) {
        if (head == null) return 0;
        int size = size(head);
        if (size == 1) return head.val;

        int index = (size / 2) + 1;

        int i = 0;
        ListNode temp = head;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        // System.out.println(temp.val);
        return temp.val;
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