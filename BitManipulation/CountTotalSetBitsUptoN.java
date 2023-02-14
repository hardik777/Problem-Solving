package com.demo.scaler.BitManipulation;

public class CountTotalSetBitsUptoN {
    //Problem Description
    //Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
    //
    //Return the count modulo 109 + 7.
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
    //Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 3
    //Input 2:
    //
    // A = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // 4
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // DECIMAL    BINARY  SET BIT COUNT
    //    1          01        1
    //    2          10        1
    //    3          11        2
    // 1 + 1 + 2 = 4
    // Answer = 4 % 1000000007 = 4
    //Explanation 2:
    //
    // A = 1
    //  DECIMAL    BINARY  SET BIT COUNT
    //    1          01        1
    // Answer = 1 % 1000000007 = 1

    public static void main(String[] args) {

    }

    static int modValue = 1000000007;

    public static int solve(int A) {
        long result = getSetBitCount(A);
        return (int) (result % modValue);
    }

    private static long getSetBitCount(int value) {

        /**
         * Base Condition: For value 0 no of set bit is 0.
         */
        if (value == 0) {
            return 0L;
        }

        /**
         * Step-1: Find the power of 2 which is nearest to the given value.
         */
        long maxPower = getNearestPowerOfTwo(value);

        /**
         * Step-2: Calculate the no of Set bit for that power using the above derived formula- N * 2^(N-1)
         */
        long numberOfSetBitsTillMaxpowerValue = maxPower * (1 << (maxPower - 1));

        /**
         * Step-3: Calculate the remaining values MSB set bits count using the formula (InputValue - 2^n + 1)
         */
        long remainingValuesMSBCount = value - (1 << maxPower) + 1;

        long maxPowerAndMSBBitCount = (numberOfSetBitsTillMaxpowerValue % modValue + remainingValuesMSBCount % modValue) % modValue;
        /**
         * Step-4: As we have explain in the step-4, after calculating the MSB set bits for the remaining values. The remaining
         * values has become values from [0 - (InputValue - 2^n)]
         * Hence, recursively calling the same fuction with the updated value. i.e. (InputValue - 2^n)
         */
        long remainingBitCount = getSetBitCount(value - (1 << maxPower));

        return maxPowerAndMSBBitCount + (remainingBitCount % modValue);
    }

    private static long getNearestPowerOfTwo(int value) {
        long power = 0;
        while ((1 << power) <= value) {
            power++;
        }
        return power - 1;
    }
}