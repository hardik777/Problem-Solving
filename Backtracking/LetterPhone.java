package com.demo.scaler.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
    //Problem Description
    //Given a digit string A, return all possible letter combinations that the number could represent.
    //
    //A mapping of digit to letters (just like on the telephone buttons) is given below.
    //
    //
    //
    //The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
    //
    //NOTE: Make sure the returned strings are lexicographically sorted.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 10
    //
    //
    //
    //Input Format
    //The only argument is a digit string A.
    //
    //
    //
    //Output Format
    //Return a string array denoting the possible letter combinations.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "23"
    //Input 2:
    //
    // A = "012"
    //
    //
    //Example Output
    //Output 1:
    //
    // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    //Output 2:
    //
    // ["01a", "01b", "01c"]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // There are 9 possible letter combinations.
    //Explanation 2:
    //
    // Only 3 possible letter combinations.

    public static void main(String[] args) {
        ArrayList<String> strings = letterCombinations("4");
        System.out.println(strings);
    }

    static HashMap<Integer, String> charmap = new HashMap<Integer, String>();
    static ArrayList<String> ans = new ArrayList<>();
    static String st = "";

    public static ArrayList<String> letterCombinations(String A) {
        charmap.put(0, "0");
        charmap.put(1, "1");
        charmap.put(2, "abc");
        charmap.put(3, "def");
        charmap.put(4, "ghi");
        charmap.put(5, "jkl");
        charmap.put(6, "mno");
        charmap.put(7, "pqrs");
        charmap.put(8, "tuv");
        charmap.put(9, "wxyz");

        generateall(A, 0);
        return ans;
    }

    static void generateall(String A, int ind) {
        //Base case
        if (A.length() == ind) {
            ans.add(st);
            return;
        }
        // or Character.toString
        String mapst = charmap.get(Integer.parseInt("" + A.charAt(ind)));
        for (int i = 0; i < mapst.length(); i++) {
            st += mapst.charAt(i);
            generateall(A, ind + 1);
            st = st.substring(0, st.length() - 1);  //Backtracking
        }
    }
}
