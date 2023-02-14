package com.demo.scaler.LinkedList;

import java.util.Stack;

public class PalindromeList {
    //Problem Description
    //Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //
    //
    //Input Format
    //The first and the only argument of input contains a pointer to the head of the given linked list.
    //
    //
    //
    //Output Format
    //Return 0, if the linked list is not a palindrome.
    //
    //Return 1, if the linked list is a palindrome.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 2, 2, 1]
    //Input 2:
    //
    //A = [1, 3, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
    //Explanation 2:
    //
    // The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

    public static void main(String[] args) {

    }

    public int lPalin(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            int pop_element = stack.pop();
            if (temp.val != pop_element) {
                // System.out.println(0);
                return 0;
            }
            temp = temp.next;
        }
        // System.out.println(1);
        return 1;
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