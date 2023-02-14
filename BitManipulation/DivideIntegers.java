package com.demo.scaler.Advanced.BitManipulation;

import java.util.Scanner;

public class DivideIntegers {
    //Problem Description
    //Divide two integers without using multiplication, division and mod operator.
    //
    //Return the floor of the result of the division.
    //
    //Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
    //
    //NOTE: INT_MAX = 2^31 - 1
    //
    //
    //
    //Problem Constraints
    //-231 <= A, B <= 231-1
    //
    //B != 0
    //
    //
    //
    //Input Format
    //The first argument is an integer A denoting the dividend.
    //The second argument is an integer B denoting the divisor.
    //
    //
    //
    //Output Format
    //Return an integer denoting the floor value of the division.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 5
    // B = 2
    //Input 2:
    //
    // A = 7
    // B = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 7
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // floor(5/2) = 2

    public static void main(String[] args) {
//        int divide = divide(5, 2);
//        System.out.println(divide);


        Scanner s = new Scanner(System.in);
        long size = s.nextLong();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += s.nextLong();
        }
        System.out.println(sum);
    }

    public static int divide(int A, int B) {
        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        if (B == 1) {                     //Edge Case
            return A;
        }
        if (A == Integer.MIN_VALUE) {     //Edge Case
            A = Integer.MAX_VALUE;
        }
        long x = Math.abs(A);
        long y = Math.abs(B);
        int quotient = 0;
        while (x >= y) {
            x = x - y;
            quotient++;
        }
        return (int) quotient * sign;
    }
}
