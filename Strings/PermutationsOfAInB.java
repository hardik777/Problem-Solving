package com.demo.scaler.Advanced.String;

public class PermutationsOfAInB {
    //Problem Description
    //You are given two strings, A and B, of size N and M, respectively.
    //
    //You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
    //
    //
    //
    //Problem Constraints
    //1 <= N < M <= 105
    //
    //
    //
    //Input Format
    //Given two arguments, A and B of type String.
    //
    //
    //
    //Output Format
    //Return a single integer, i.e., number of permutations of A present in B as a substring.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abc"
    // B = "abcbacabc"
    //Input 2:
    //
    // A = "aca"
    // B = "acaa"
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Permutations of A that are present in B as substring are:
    //    1. abc
    //    2. cba
    //    3. bac
    //    4. cab
    //    5. abc
    //    So ans is 5.
    //Explanation 2:
    //
    // Permutations of A that are present in B as substring are:
    //    1. aca
    //    2. caa

    public static void main(String[] args) {

    }

    static final int MAX = 256;

    public int solve(String pat, String txt) {
        int count = 0;
        int M = pat.length();
        int N = txt.length();

        // countP[]:  Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++) {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++) {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW)) {
                // System.out.println("Found at Index " + (i - M));
                count++;
            }

            // Add current character to current
            // window
            (countTW[txt.charAt(i)])++;

            // Remove the first character of previous
            // window
            countTW[txt.charAt(i - M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW)) {
            count++;
            // System.out.println("Found at Index " + (N - M));
        }

        // System.out.println(count);
        return count;
    }

    // This function returns true if contents
    // of arr1[] and arr2[] are same, otherwise
    // false.
    public static boolean compare(char arr1[], char arr2[]) {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}