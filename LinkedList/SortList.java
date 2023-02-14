package com.demo.scaler.LinkedList;

public class SortList {
    //Problem Description
    //Sort a linked list, A in O(n log n) time using constant space complexity.
    //
    //
    //
    //Problem Constraints
    //0 <= |A| = 105
    //
    //
    //
    //Input Format
    //The first and the only arugment of input contains a pointer to the head of the linked list, A.
    //
    //
    //
    //Output Format
    //Return a pointer to the head of the sorted linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [3, 4, 2, 8]
    //Input 2:
    //
    //A = [1]
    //
    //
    //Example Output
    //Output 1:
    //
    //[2, 3, 4, 8]
    //Output 2:
    //
    //[1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
    //Explanation 2:
    //
    // The sorted form of [1] is [1].

    public ListNode sortList(ListNode head) {
        //Base case
        if (head == null || head.next == null) return head;

        //Rec case
        ListNode mid = getMid(head);

        ListNode a = head;
        ListNode b = mid.next;
        mid.next = null;

        a = sortList(a);
        b = sortList(b);
        return mergeTwoLists(a, b);
    }

    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        System.out.println(slow.val);
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head;

        //Base case
        if (a == null) return b;
        if (b == null) return a;

        //Rec case
        if (a.val <= b.val) {
            head = a;
            head.next = mergeTwoLists(a.next, b);
        } else {
            head = b;
            head.next = mergeTwoLists(a, b.next);
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