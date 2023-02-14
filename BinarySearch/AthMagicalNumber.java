package com.demo.scaler.Advanced.BinarySearch;

public class AthMagicalNumber {
    //Problem Description
    //You are given three positive integers, A, B, and C.
    //
    //Any positive integer is magical if divisible by either B or C.
    //
    //Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 109
    //
    //2 <= B, C <= 40000
    //
    //
    //
    //Input Format
    //The first argument given is an integer A.
    //
    //The second argument given is an integer B.
    //
    //The third argument given is an integer C.
    //
    //
    //
    //Output Format
    //Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 1
    // B = 2
    // C = 3
    //Input 2:
    //
    // A = 4
    // B = 2
    // C = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 1st magical number is 2.
    //Explanation 2:
    //
    // First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

    public static void main(String[] args) {

    }

    public int solve(int A, int B, int C) {
        //Ath element can not go beyong Ath multiple of Minimum of B,C.
        long high = ((long) A) * Math.min(B, C);
        //low would be the first multiple of Minimum of B,C.
        long low = Math.min(B, C);
        int mod = 1000000007;

        //Once the search space is defined.
        if (A == 1)
            return (int) low;

        //To calculate the Ath position divisble by B or C, we need to (imagine) think of the A multiples of B and C atleast(say 5)
        // But we don't need to calculate the common multiple twice.
        //So we need to calculate lcm of B & C, to be able to reduce the common multiple of B and C.
        long lcm = (((long) B) * C) / gcd(B, C);
        long ans = low;

        //Now we are ready to run Binary Search for the search space defined above.
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long countB = mid / B;
            long countC = mid / C;
            //To Reduce count of common factors.
            long commonFactors = mid / lcm;
            long position = (countB + countC - commonFactors);
            //As we need the Ath Smallest,
            if (position >= A) {
                ans = mid;
                high = mid - 1;
                ;
            } else
                low = mid + 1;
        }
        if (ans < 0) {
            ans += mod;
        }
        return (int) (ans % mod);
    }

    public static int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return gcd(y % x, x);
    }
}