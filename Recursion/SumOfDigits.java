package com.demo.scaler.Advanced.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int sum = solve(12345);
        System.out.println(sum);
    }

    public static int solve(int A) {
        if (A < 10)
            return A;

        return A % 10 + solve(A / 10);
    }
}
