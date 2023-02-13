package com.demo.scaler.StringsPatternMatching;

public class ClosestPalindrome {
    //Problem Description
    //Groot has a profound love for palindrome which is why he keeps fooling around with strings.
    //A palindrome string is one that reads the same backward as well as forward.
    //
    //Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //
    //
    //
    //Input Format
    //The first and only argument is a string A.
    //
    //
    //
    //Output Format
    //Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abbba"
    //Input 2:
    //
    // A = "adaddb"
    //
    //
    //Example Output
    //Output 1:
    //
    // "YES"
    //Output 2:
    //
    // "NO"
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // We can change the character at index 3(1-based) to any other character. The string will be palindromic.
    //Explanation 2:
    //
    // To make the string palindromic we need to change 2 characters.

    public static void main(String[] args) {
        String check = solve("abbba");
        System.out.println(check);
    }

    //TC : O(N), SC : O(1)
    public static String solve(String A) {
        //We can use Two Pointer Approach by putting p1 and p2 at first and last of the string
        //We maintain count and increment count if Characters doesn't match
        //If any characters will not match then i.e. count = 0 then We have check length of string...if length is Odd then 1
        //character need to change and if length is even then ans is "NO" because we need to change 2 characters to make palindrome

        int p1 = 0, p2 = A.length() - 1, count = 0;
        while (p1 < p2) {
            if (A.charAt(p1) != A.charAt(p2)) {
                count++;
            }
            p1++;
            p2--;
        }

        if (count == 1) {
            return "YES";
        } else if (count == 0) {
            //Check for odd and even length
            return A.length() % 2 == 0 ? "NO" : "YES";
        }
        return "NO";
    }
}
