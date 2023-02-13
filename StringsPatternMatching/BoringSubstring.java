package com.demo.scaler.StringsPatternMatching;

public class BoringSubstring {
    //Problem Description
    //You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
    //
    //A boring substring has the following properties:
    //
    //Its length is 2.
    //Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
    //Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //
    //
    //Input Format
    //The only argument given is a string A.
    //
    //
    //
    //Output Format
    //Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abcd"
    //Input 2:
    //
    // A = "aab"
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // String A can be rearranged into "cadb" or "bdac"
    //Explanation 2:
    //
    // No arrangement of string A can make it free of boring substrings.

    public static void main(String[] args) {
        int possible = solve("abcd");
        System.out.println(possible);
    }

    public static int solve(String A) {
        //The main intuition behind this problem statement is to partition the characters between two groups.
        //How to partition : Based on ascii values I can divide the whole string into two parts with odd and even basis.
        //If I want to merged the partitioned strings , I need to maximized the distance between the chars.
        //
        //How to maximize the diff : Max Val - Min Val
        //I need to check for both evenMax - oddMin as well as oddMax - evenMin
        //if any result not equal to 1 return 1;

        int evenMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        int oddMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;

        int n = A.length();
        for (int i = 0; i < n; i++) {
            int val = (int) (A.charAt(i) - 'a') + 1;
            if (val % 2 == 0) {
                evenMax = Math.max(evenMax, val);
                evenMin = Math.min(evenMin, val);
            } else {
                oddMax = Math.max(oddMax, val);
                oddMin = Math.min(oddMin, val);
            }
        }

        if (Math.abs(evenMax - oddMin) != 1 || Math.abs(oddMax - evenMin) != 1)
            return 1;
        return 0;
    }
}
