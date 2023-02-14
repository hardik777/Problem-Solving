package com.demo.scaler.BitManipulation;

public class StrangeEquality {
    //Problem Description
    //Given an integer A.
    //Two numbers, X and Y, are defined as follows:
    //
    //X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
    //Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
    //Find and return the XOR of X and Y.
    //
    //NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
    //
    //NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 109
    //
    //
    //
    //Input Format
    //First and only argument is an integer A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the XOR of X and Y.
    //
    //
    //
    //Example Input
    //A = 5
    //
    //
    //Example Output
    //10
    //
    //
    //Example Explanation
    //The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.

    public static void main(String[] args) {
        int solve = solve(5);
        System.out.println(solve);
    }

    public static int solve(int A) {
        int n1 = 0;
        int n2 = 0;
        //the formula which guides this questions is A+B = A^B + 2*(A&B).
        //if A+B = A^B, then 2*(A&B) = 0 or A & B =0

        //for greatest smaller number

        //idea is to find the countOfBits and then make the exact reverse of the number so that
        // the bitwise And gives 0.
        // for example if A=5 (in bits 101), the greatest smaller number to give bitwise and as zero is 010.
        int lastOneBit = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(A, i)) {
                lastOneBit = i;
            }
        }

        int countOfBits = lastOneBit + 1;

        for (int i = 0; i < countOfBits; i++) {
            if (!checkBit(A, i)) {
                n1 = n1 + (1 << i);
            }
        }

        //for smallest greater number
        // the smallest number greater than number to give an bitwise and as zero is 2^countOfBits.
        // for example if A=5 (in bits 101), the smallest greater number to give bitwise and as zero is 1000.
        n2 = (1 << countOfBits);

        return n1 ^ n2;
    }

    public static boolean checkBit(int A, int i) {
        if ((A & (1 << i)) != 0)
            return true;
        else
            return false;
    }
}
