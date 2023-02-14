package com.demo.scaler.BitManipulation;

public class UnsetxBitsFromRight {
    public static void main(String[] args) {
        solve(17L, 3);
    }

    public static Long solve(Long A, int B) {
        System.out.println(A & (~0 << B));
        return A & (~0 << B);
    }
}
