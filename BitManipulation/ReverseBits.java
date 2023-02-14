package com.demo.scaler.Advanced.BitManipulation;

public class ReverseBits {
    //Problem Description
    //Reverse the bits of an 32 bit unsigned integer A.
    //
    //
    //
    //Problem Constraints
    //0 <= A <= 232
    //
    //
    //
    //Input Format
    //First and only argument of input contains an integer A.
    //
    //
    //
    //Output Format
    //Return a single unsigned integer denoting the decimal value of reversed bits.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // 0
    //Input 2:
    //
    // 3
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 3221225472
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //        00000000000000000000000000000000
    //=>      00000000000000000000000000000000
    //Explanation 2:
    //
    //        00000000000000000000000000000011
    //=>      11000000000000000000000000000000

    public static void main(String[] args) {
        long reverse = reverse(3);
        System.out.println(reverse);
    }

    public static long reverse(long A) {
        int p = 31;
        long sum = 0;

        while (A > 0) {
            if ((A & 1) == 1) {  //check last bit is 1
                sum = sum + (long) Math.pow(2, p);
            }
            A = A >> 1;
            p--;
        }
        return sum;
    }
}
