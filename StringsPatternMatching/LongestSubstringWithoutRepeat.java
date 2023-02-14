package com.demo.scaler.Advanced.StringPatternMatching;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    //Problem Description
    //Given a string A, find the length of the longest substring without repeating characters.
    //
    //Note: Users are expected to solve in O(N) time complexity.
    //
    //
    //
    //Problem Constraints
    //1 <= size(A) <= 106
    //
    //String consists of lowerCase,upperCase characters and digits are also present in the string A.
    //
    //
    //
    //Input Format
    //Single Argument representing string A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the maximum possible length of substring without repeating characters.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abcabcbb"
    //Input 2:
    //
    // A = "AaaA"
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Substring "abc" is the longest substring without repeating characters in string A.
    //Explanation 2:
    //
    // Substring "Aa" or "aA" is the longest substring without repeating characters in string A.

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String A) {
        //---------------------Using HashMap---------------------
        //create map of character with frequency and when we find same character then move start variable and
        //count end-start+1 length
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0, maxLength = 0;
        for (int end = 0; end < A.length(); end++) {
            if (map.containsKey(A.charAt(end))) {
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = Math.max(start, map.get(A.charAt(end)) + 1);
            }

            // Updating the last seen value of the character
            map.put(A.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        // System.out.println(maxLength);
        return maxLength;
    }
}