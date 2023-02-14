package com.demo.scaler.Advanced.Recursion;

public class PowerModC {
    //Problem Description
    //Implement pow(A, B) % C.
    //In other words, given A, B and C, Find (AB % C).
    //
    //Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
    //
    //
    //
    //Problem Constraints
    //-109 <= A <= 109
    //0 <= B <= 109
    //1 <= C <= 109
    //
    //
    //Input Format
    //Given three integers A, B, C.
    //
    //
    //Output Format
    //Return an integer.
    //
    //
    //Example Input
    //A = 2, B = 3, C = 3
    //
    //
    //Example Output
    //2
    //
    //
    //Example Explanation
    //23 % 3 = 8 % 3 = 2

    public static void main(String[] args) {

    }

    public int pow(int A, int B, int C) {
        if (A == 0)
            return 0;

        if (B == 0)
            return 1;

        long ans = pow(A, B / 2, C);
        if (B % 2 == 0)
            return (int) ((ans * ans) % C); // If b is even then answer cannot be negative
        else
            ans = ((ans * ans % C) * (A % C)) % C;

        return (int) ((ans + C) % C); // If b is odd answer can be negative, convert it to positive using (A-B) % M
    }
}