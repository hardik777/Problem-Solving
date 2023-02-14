package com.demo.scaler.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class AthPerfectNumber {
    //Problem Description
    //Given an integer A, you have to find the Ath Perfect Number.
    //
    //A Perfect Number has the following properties:
    //
    //It comprises only 1 and 2.
    //
    //The number of digits in a Perfect number is even.
    //
    //It is a palindrome number.
    //
    //For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 100000
    //
    //
    //
    //Input Format
    //The only argument given is an integer A.
    //
    //
    //
    //Output Format
    //Return a string that denotes the Ath Perfect Number.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 2
    //Input 2:
    //
    // A = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // 22
    //Output 2:
    //
    // 1111
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //First four perfect numbers are:
    //1. 11
    //2. 22
    //3. 1111
    //4. 1221
    //Explanation 2:
    //
    //First four perfect numbers are:
    //1. 11
    //2. 22
    //3. 1111
    //4. 1221

    public static void main(String[] args) {

    }

    public String solve(int A) {
        //Using queue
        //we can get half number and reverse it and combine to make palindrome number

        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        String res = "";

        while (cnt <= A) {
            //pop element and make two numbers and add into queue
            String poll = queue.poll();
            queue.offer(poll + "1");
            queue.offer(poll + "2");

            StringBuilder append = new StringBuilder(poll);
            res = append + append.reverse().toString();
            // System.out.println(res);
            cnt++;
        }
        // System.out.println(res);
        return res;
    }
}