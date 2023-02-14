package com.demo.scaler.Advanced.Recursion;

import java.util.Scanner;

public class PrintReverseString {
    //Problem Description
    //Write a recursive function that, given a string S, prints the characters of S in reverse order.
    //
    //
    //
    //Problem Constraints
    //1 <= |s| <= 1000
    //
    //
    //
    //Input Format
    //First line of input contains a string S.
    //
    //
    //
    //Output Format
    //Print the character of the string S in reverse order.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // scaleracademy
    //Input 2:
    //
    // cool
    //
    //
    //Example Output
    //Output 1:
    //
    // ymedacarelacs
    //Output 2:
    //
    // looc
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Print the reverse of the string in a single line.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        printReverse(a, a.length() - 1);
    }

    private static void printReverse(String a, int len) {
        //Base case
        if (len < 0) return;

        System.out.print(a.charAt(len));  //Print last character every time
        printReverse(a, len - 1);
    }

}