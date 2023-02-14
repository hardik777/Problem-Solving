package com.demo.scaler.LinkedList;

public class PartitionList {
    //Problem Description
    //Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
    //
    //You should preserve the original relative order of the nodes in each of the two partitions.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 106
    //
    //1 <= A[i], B <= 109
    //
    //
    //
    //Input Format
    //The first argument of input contains a pointer to the head to the given linked list.
    //
    //The second argument of input contains an integer, B.
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
    //A = [1, 4, 3, 2, 5, 2]
    //B = 3
    //Input 2:
    //
    //A = [1, 2, 3, 1, 3]
    //B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    //[1, 2, 2, 4, 3, 5]
    //Output 2:
    //
    //[1, 1, 2, 3, 3]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
    //Explanation 2:
    //
    // [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.

    public static void main(String[] args) {
        partition(new ListNode(1), 3);
    }

//    1) Build two separate references of LL based on condition for each node
//    ->> value < B
//    ->> value >= B
//    2) Each LL will have two pointer head, tail
//        in each iteration sever the tail.next. Make it point to null
//                3) if any of the LL is empty other LL is the ans
//    4) Otherwise join LL2 after LL1
//        and return LL1

    public static ListNode partition(ListNode A, int B) {
        ListNode l1_head = null;
        ListNode l1_tail = null;
        ListNode l2_head = null;
        ListNode l2_tail = null;

        ListNode curr = A;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < B) {
                if (l1_head == null) {
                    l1_head = l1_tail = curr;
                } else {
                    l1_tail.next = curr;
                    l1_tail = l1_tail.next;
                }

                l1_tail.next = null;
            } else {
                if (l2_head == null) {
                    l2_head = l2_tail = curr;
                } else {
                    l2_tail.next = curr;
                    l2_tail = l2_tail.next;
                }

                l2_tail.next = null;
            }

            curr = next;
        }

        if (l1_head == null) {
            return l2_head;
        }
        if (l2_head == null) {
            return l1_head;
        }

        l1_tail.next = l2_head;
        return l1_head;
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
