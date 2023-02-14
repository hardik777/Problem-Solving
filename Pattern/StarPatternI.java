package com.demo.scaler.Pattern;

import java.util.Scanner;

public class StarPatternI {
    //Problem Description
    //
    //Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
    //
    //See example for clarifications over the pattern.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= N <= 1000
    //
    //
    //
    //Input Format
    //
    //First line is an integer N
    //
    //
    //
    //Output Format
    //
    //N lines conatining only char '*' as per the question.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    //4
    //Input 2:
    //
    //6
    //
    //
    //Example Output
    //
    //Output 1:
    //
    //********
    //***  ***
    //**    **
    //*      *
    //*      *
    //**    **
    //***  ***
    //********
    //Output 2:
    //
    //************
    //*****  *****
    //****    ****
    //***      ***
    //**        **
    //*          *
    //*          *
    //**        **
    //***      ***
    //****    ****
    //*****  *****
    //************

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int N = n * 2;

//        ********
//        ***  ***
//        **    **
//        *      *
//        *      *
//        **    **
//        ***  ***
//        ********

        int count = N / 2;
        int space = 0;
        boolean flag = true, flagSpace = true;

        for (int i = 1; i <= N; i++) {

            //-------------------First-------------------
            for (int j = 1; j <= count; j++) {
                System.out.print("*");
            }

            //-------------------Space-------------------
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            if (flagSpace) {
                space += 2;
                if (space == N) {
                    space -= 2;
                    flagSpace = false;
                }
            } else {
                space -= 2;
            }

            //-------------------Last-------------------
            for (int j = 1; j <= count; j++) {
                System.out.print("*");
            }

            //-----------Increment/Decrement-----------
            if (flag) {
                count -= 1;
                if (count == 0) {
                    count += 1;
                    flag = false;
                }
            } else {
                count += 1;
            }

            System.out.println();
        }

    }
}
