package com.demo.scaler.Pattern;

import java.util.Scanner;

public class CharactersStairPattern {
    //Problem Description
    //
    //Given an integer N, print the corresponding pattern for N.
    //
    //For example if N = 4 then pattern will be like:
    //
    //A
    //B B
    //C C C
    //D D D D
    //
    //
    //Problem Constraints
    //
    //1 <= N <= 26
    //
    //
    //
    //Input Format
    //
    //First and only line of input contains a single integer N.
    //
    //
    //
    //Output Format
    //
    //Output the pattern corresponding to the given N.
    //
    //NOTE: There should be no extra spaces after last character or before first character in any row and all characters in any row in the pattern are space separated.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // 2
    //Input 2:
    //
    // 3
    //
    //
    //Example Output
    //
    //Output 1:
    //
    //A
    //B B
    //Output 2:
    //
    //A
    //B B
    //C C C
    //
    //
    //Example Explanation
    //
    // Print the pattern as described.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        String[] array = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        if (number <= 26) {
            for (int i = 1; i <= number; i++) {

                for (int j = 1; j <= i; j++) {
                    if (j == i) {
                        System.out.print(array[i - 1]);
                    } else {
                        System.out.print(array[i - 1] + " ");
                    }
                }

                System.out.println();
            }
        }
    }
}
