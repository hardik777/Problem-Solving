package com.demo.scaler.Hashing;

import java.util.HashMap;

public class ReplicatingSubstring {
    //Problem Description
    //
    //Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
    //
    //Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
    //
    //If it is possible, return 1, else return -1.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= Length of string B <= 1000
    //
    //1 <= A <= 1000
    //
    //All the alphabets of S are lower case (a - z)
    //
    //
    //
    //Input Format
    //
    //First argument is an integer A.
    //Second argument is a string B.
    //
    //
    //
    //Output Format
    //
    //Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = 2
    // B = "bbaabb"
    //Input 2:
    //
    // A = 1
    // B = "bc"
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // We can re-order the given string into "abbabb".
    //Explanation 2:
    //
    // String "bc" is already arranged.

    public static void main(String[] args) {

    }

    public int solve(int A, String B) {
        //Hashmap with freq count and check freq is multiple of B
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), map.getOrDefault(B.charAt(i), 0) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) % A != 0) {
                // System.out.println(-1);
                return -1;
            }
        }
        // System.out.println(1);
        return 1;
    }
}