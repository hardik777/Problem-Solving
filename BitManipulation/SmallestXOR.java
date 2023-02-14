package com.demo.scaler.BitManipulation;

public class SmallestXOR {
    //Problem Description
    //Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.
    //
    //
    //
    //Problem Constraints
    //0 <= A <= 109
    //0 <= B <= 30
    //
    //
    //
    //Input Format
    //First argument contains a single integer A. Second argument contains a single integer B.
    //
    //
    //
    //Output Format
    //Return a single integer X.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 3
    // B = 3
    //Input 2:
    //
    // A = 15
    // B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 7
    //Output 2:
    //
    // 12
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 3 xor 7 = 4 which is minimum
    //Explanation 2:
    //
    // 15 xor 12 = 3 which is minimum

    public static void main(String[] args) {
        int solve = solve(15, 2);
        System.out.println(solve);
    }

    public static int solve(int A, int B) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (checkbit(A, i) == true) {
                count++;
                ans = ans + (1 << i);
            }
        }
        if (count == B) {
            return ans;
        } else if (count < B) {
            for (int i = 0; i < 32; i++) {
                if (checkbit(A, i) == false) {
                    ans = ans + (1 << i);
                    count++;
                    if (count == B) {
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < 32; i++) {
                if (checkbit(A, i) == true) {
                    ans = ans ^ (1 << i);
                    count--;
                    if (count == B) {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean checkbit(int n, int i) {
        if ((n & (1 << i)) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
