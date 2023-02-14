package com.demo.scaler.Arrays;

import java.util.Scanner;

public class RemoveArray {
    //Problem Description
    //
    //Write a program to input N numbers array from user and an integer X and print the array by deleting element at specified position X.
    //
    //Problem Constraints
    //
    //1 <= N <= 100
    //
    //1 <= A[i] <= 1000
    //
    //1 <= X <= N
    //
    //Input Format
    //
    //First line is N which means number of elements.
    //
    //Second line contains N space separated integers.
    //
    //Third line is X position which has to be deleted.
    //Output Format
    //
    //N-1 space separated integers of the input array after deleting the element at required position.
    //Example Input
    //
    //5
    //2 3 1 4 2
    //3
    //Example Output
    //
    //2 3 4 2
    //Example Explanation
    //
    //Clearly after removing A[3] = 1, remaining array is 2 3 4 2.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int pos = sc.nextInt();

        int[] newarr = new int[count - 1];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (pos - 1 == i) {
                //Remove position
                continue;
            }
            newarr[j++] = array[i];
        }

        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i] + " ");
        }

    }
}