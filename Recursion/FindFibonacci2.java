package com.demo.scaler.Advanced.Recursion;

public class FindFibonacci2 {
    public static void main(String[] args) {
        int sum = findAthFibonacci(9);
        System.out.println(sum);
    }

    public static int findAthFibonacci(int A) {
        if (A == 0 || A == 1) return A;

        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
