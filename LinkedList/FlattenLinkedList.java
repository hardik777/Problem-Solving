package com.demo.scaler.LinkedList;

public class FlattenLinkedList {
    //Problem Description
    //Given a linked list where every node represents a linked list and contains two pointers of its type:
    //
    //Pointer to next node in the main list (right pointer)
    //Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
    //You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
    //
    //
    //
    //Problem Constraints
    //1 <= Total nodes in the list <= 100000
    //
    //1 <= Value of node <= 109
    //
    //
    //
    //Input Format
    //The only argument given is head pointer of the doubly linked list.
    //
    //
    //
    //Output Format
    //Return the head pointer of the Flattened list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //   3 -> 4 -> 20 -> 20 ->30
    //   |    |    |     |    |
    //   7    11   22    20   31
    //   |               |    |
    //   7               28   39
    //   |               |
    //   8               39
    //Input 2:
    //
    //   2 -> 4
    //   |    |
    //   7    11
    //   |
    //   7
    //
    //
    //Example Output
    //Output 1:
    //
    // 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
    //Output 2:
    //
    // 2 -> 4 -> 7 -> 7 -> 11
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The return linked list is the flatten sorted list.

    public static void main(String[] args) {

    }

    public ListNode flatten(ListNode head) {
        //Base case
        if (head == null || head.right == null) return head;

        //Rec case
        ListNode mid = getMid(head);
        ListNode a = head;
        ListNode b = mid.right;
        mid.right = null;

        flatten(a);
        flatten(b);

        return mergeTwoLists(a, b);
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head;

        //Base case
        if (a == null) return b;
        if (b == null) return a;

        //Rec case
        if (a.val <= b.val) {
            head = a;
            head.down = mergeTwoLists(a.down, b);
        } else {
            head = b;
            head.down = mergeTwoLists(a, b.down);
        }
        return head;
    }

    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.right;

        while (fast != null && fast.right != null) {
            fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
}