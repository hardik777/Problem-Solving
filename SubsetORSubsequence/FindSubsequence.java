package com.demo.scaler.SubsetORSubsequence;

public class FindSubsequence {
    //Given two strings A and B, find if A is a subsequence of B.
    //
    //Return "YES" if A is a subsequence of B, else return "NO".
    //
    //
    //Input Format
    //
    //The first argument given is the string A.
    //The second argument given is the string B.
    //Output Format
    //
    //Return "YES" if A is a subsequence of B, else return "NO".
    //Constraints
    //
    //1 <= lenght(A), length(B) <= 100000
    //'a' <= A[i], B[i] <= 'z'
    //For Example
    //
    //Input 1:
    //    A = "bit"
    //    B = "dfbkjijgbbiihbmmt"
    //Output 1:
    //    YES
    //
    //Input 2:
    //    A = "apple"
    //    B = "appel"
    //Output 2:
    //    "NO"

    public static void main(String[] args) {
        String solve = solve("bit", "dfbkjijgbbiihbmmt");
        System.out.println(solve);
    }

    /**
     * Two pointer Approach
     * The idea is simple, we traverse both strings from one side to another side together.
     * If we find a matching character, we move ahead in both strings. Otherwise, we move ahead only in b.
     */
    public static String solve(String A, String B) {
        if (A.length() > B.length()) return "NO";
        if (A.length() == B.length()) {
            if (A.equals(B)) return "YES";
            return "NO";
        }

        int p1 = 0, p2 = 0;
        while (p1 < A.length() && p2 < B.length()) {
            if (A.charAt(p1) == B.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return p1 == A.length() ? "YES" : "NO";
    }
}
