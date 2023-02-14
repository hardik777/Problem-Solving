package com.demo.scaler.Arrays.PrefixSum;

public class AmazingSubarrays {
    //You are given a string S, and you have to find all the amazing substrings of S.
    //
    //An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
    //
    //Input
    //
    //Only argument given is string S.
    //Output
    //
    //Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
    //Constraints
    //
    //1 <= length(S) <= 1e6
    //S can have special characters
    //Example
    //
    //Input
    //    ABEC
    //
    //Output
    //    6
    //
    //Explanation
    //    Amazing substrings of given string are :
    //    1. A
    //    2. AB
    //    3. ABE
    //    4. ABEC
    //    5. E
    //    6. EC
    //    here number of substrings are 6 and 6 % 10003 = 6.

    public static void main(String[] args) {

    }

    public int solve(String A) {
        char[] chars = A.toLowerCase().toCharArray();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                count += A.substring(i).length();
            }
        }
        // System.out.println(count);
        return count % 10003;
    }
}