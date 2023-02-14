package com.demo.scaler.LinkedList;

public class BreakLoopFromLinkedList {
    //Problem Description
    //You are given a linked list that contains a loop.
    //You need to find the node, which creates a loop and break it by making the node point to NULL.
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 1000
    //
    //
    //
    //Input Format
    //The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
    //The second line of the input contains an integer which denotes the position of node where cycle starts.
    //
    //
    //
    //Output Format
    //return the head of the updated linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //1 -> 2
    //^    |
    //| - -
    //Input 2:
    //
    //3 -> 2 -> 4 -> 5 -> 6
    //          ^         |
    //          |         |
    //          - - - - - -
    //
    //
    //Example Output
    //Output 1:
    //
    // 1 -> 2 -> NULL
    //Output 2:
    //
    // 3 -> 2 -> 4 -> 5 -> 6 -> NULL
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Chain of 1->2 is broken.
    //Explanation 2:
    //
    // Chain of 4->6 is broken.

    public static void main(String[] args) {

    }

    public ListNode solve(ListNode head) {
        //Get Meeting point Node
        ListNode temp = head;
        ListNode meetingNode = getMeetingNode(temp);

        if (meetingNode != null) {
            ListNode slow = head;
            ListNode fast = meetingNode;
            if (slow != fast) {
                while (fast.next != slow.next) {
                    fast = fast.next;
                    slow = slow.next;
                }
                /* since fast->next is the looping point */
                fast.next = null; /* remove loop */
            }
//            //We got start node of loop
//            Node startOfLoop = slow;
//            Node tempStart = head;
//
//            //loop until both are not same
//            while (tempStart.next != startOfLoop) {
//                tempStart = tempStart.next;
//            }
//            tempStart.next = null;

            return head;
        }
        return head;
    }

    public static ListNode getMeetingNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast; //or slow
            }
        }
        return null;
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