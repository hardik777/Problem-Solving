package com.demo.scaler.Pattern;

import java.util.Scanner;

public class StarPatternII {
    //Problem Description
    //
    //Write a program to input an integer N from user and print hollow inverted right triangle star pattern of N lines using '*'.
    //
    //See example for clarifications.
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
    //7
    //Input 2:
    //
    //4
    //
    //
    //Example Output
    //
    //Output 1:
    //
    //*******
    //*    *
    //*   *
    //*  *
    //* *
    //**
    //*
    //Output 2:
    //
    //****
    //* *
    //**
    //*

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = number; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {
                if (i == number) { // first
                    System.out.print("*");
                } else if (j == 1 || j == i) {  //first and last
                    System.out.print("*");
                } else { //Space between
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

    }
}
