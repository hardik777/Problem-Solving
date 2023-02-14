package com.demo.scaler.Advanced;

import java.util.ArrayList;

public class CreateSpiralMarix {
    //Problem Description
    //Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 1000
    //
    //
    //
    //Input Format
    //First and only argument is integer A
    //
    //
    //Output Format
    //Return a 2-D matrix which consists of the elements added in spiral order.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //1
    //Input 2:
    //
    //2
    //Input 3:
    //
    //5
    //
    //
    //Example Output
    //Output 1:
    //
    //[ [1] ]
    //Output 2:
    //
    //[ [1, 2], [4, 3] ]
    //Output 2:
    //
    //[ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Only 1 is to be arranged.
    //Explanation 2:
    //
    //1 --> 2
    //      |
    //      |
    //4<--- 3

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int i = 0;
        int j = 0;
        int count = 1;
        int N = A;

        //Create arraylist and fill with default 1 value
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int k = 0; k < N; k++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int l = 0; l < N; l++) {
                temp.add(count);
            }
            arr.add(temp);
        }

        //update each values by rows and cols wise
        while (N >= 0) {
            //top row
            for (int k = 1; k < N; k++) {
                arr.get(i).set(j, count);
                j++;
                count++;
            }

            //right col
            for (int k = 1; k < N; k++) {
                arr.get(i).set(j, count);
                i++;
                count++;
            }

            //bottom row
            for (int k = 1; k < N; k++) {
                arr.get(i).set(j, count);
                j--;
                count++;
            }

            //left col
            for (int k = 1; k < N; k++) {
                arr.get(i).set(j, count);
                i--;
                count++;
            }
            i++;
            j++;
            N = N - 2;
            if (N == 1) {
                arr.get(i).set(j, count);
                break;
            }
        }
//        System.out.println(arr);
        return arr;
    }
}