package com.demo.scaler.LinkedList;

public class RemoveDuplicatesFromSortedList {
    //Problem Description
    //Given a sorted linked list, delete all duplicates such that each element appears only once.
    //
    //
    //
    //Problem Constraints
    //0 <= length of linked list <= 106
    //
    //
    //
    //Input Format
    //First argument is the head pointer of the linked list.
    //
    //
    //
    //Output Format
    //Return the head pointer of the linked list after removing all duplicates.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // 1->1->2
    //Input 2:
    //
    // 1->1->2->3->3
    //
    //
    //Example Output
    //Output 1:
    //
    // 1->2
    //Output 2:
    //
    // 1->2->3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Each element appear only once in 1->2.

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head, prev = head;
        while (temp != null) {

            // Compare values of both pointers
            if (prev.val != temp.val) {
                // if the value of prev is not equal to the
                // value of temp that means there are no
                // more occurrences of the prev data. So we
                // can set the next of prev to the temp
                // node.
                prev.next = temp;
                prev = temp;
            }
            //Set the temp to the next node
            temp = temp.next;
        }

        // This is the edge case if there are more than one
        // occurrences of the last element
        if (prev != temp) prev.next = null;

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