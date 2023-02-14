package com.demo.scaler.LinkedList;

public class DetectCycleNode {
    //Problem Description
    //
    //Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //
    //Try solving it using constant additional space.
    //
    //Example:
    //
    //Input:
    //
    //                  ______
    //                 |     |
    //                 \/    |
    //        1 -> 2 -> 3 -> 4
    //
    //Return the node corresponding to node 3.

    public static void main(String[] args) {

    }

    //First find the meeting node where fast and slow pointers match
    //From the meeting node, slow starts from head and fast starts from meeting node and when they meet each other that is cycle node
    public ListNode detectCycle(ListNode head) {
        //Get Meeting point Node
        ListNode temp = head;
        ListNode meetingNode = getMeetingNode(temp);
        if (meetingNode != null) {
            ListNode slow = head;
            ListNode fast = meetingNode;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

    public static ListNode getMeetingNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}