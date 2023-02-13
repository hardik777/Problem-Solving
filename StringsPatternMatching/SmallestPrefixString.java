package com.demo.scaler.StringsPatternMatching;

public class SmallestPrefixString {
    //Problem Description
    //Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
    //Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
    //
    //
    //
    //Problem Constraints
    //1 <= N, M <= 100000
    //
    //
    //
    //Input Format
    //The first argument is a string A of size N.
    //The second argument is a string B of size M.
    //
    //
    //
    //Output Format
    //Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abba"
    // B = "cdd"
    //Input 2:
    //
    // A = "acd"
    // B = "bay"
    //
    //
    //Example Output
    //Output 1:
    //
    // "abbac"
    //Output 2:
    //
    // "ab"
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
    // The lexicographically smallest string will be "abbac".
    //Explanation 2:
    //
    // We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
    // The lexicographically smallest string will be "ab".

    public static void main(String[] args) {
        String s = smallestPrefix("abba", "cdd");
        System.out.println(s);
    }

    public static String smallestPrefix(String A, String B) {
        //Like Two pointer approach
        //We first take A[0] in ans and then append characters till A[i] < B[0]
        //When first string will complete it's length, Just append B[0] in ans

        int N = A.length();
        String ans = "";
        ans = ans + A.charAt(0); // 1. As the ans must start from prefix of A, therefore A[0] will definitely be part of ans
        int i = 1;
        while(i < N && A.charAt(i) < B.charAt(0)){
            ans = ans + A.charAt(i);
            i++;
        }
        ans = ans + B.charAt(0); // 2. since we want the smallest string, from B's side only B[0] should contribute in ans
        return ans;
    }
}
