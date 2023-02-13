package com.demo.scaler.String;

import java.util.ArrayList;
import java.util.HashMap;

public class VowelsFind {
    //Problem Description
    //You are given lowercase string (A) and you have to tell the count of vowels and consonants in it.
    //
    //
    //
    //Problem Constraints
    //1 <= A.size() <= 1000
    //
    //
    //
    //Input Format
    //First and only argument containing a lowercase string A.
    //
    //
    //
    //Output Format
    //You have to return an array of two elements representing count of vowels and consonants in the input string respectively.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //interviewbit
    //Input 2:
    //
    //scaler
    //
    //
    //Example Output
    //Output 1:
    //
    //[5 7]
    //Output 2:
    //
    //[2 4]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Clearly, interviewbit has 4 vowels and 7 consonants.
    //Explanation 2:
    //
    //Clearly, scaler has 2 vowels and 4 consonants.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(String A) {
        ArrayList<Character> arrVowels = new ArrayList<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }
        };

        ArrayList<Integer> arrCount = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        int vowelsCount = 0, constantCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (arrVowels.contains(A.charAt(i))) {
                vowelsCount++;
                hashMap.put("vowels", vowelsCount);
            } else {
                constantCount++;
                hashMap.put("constants", constantCount);
            }
        }
        arrCount.add(hashMap.get("vowels") == null ? 0 : hashMap.get("vowels"));
        arrCount.add(hashMap.get("constants") == null ? 0 : hashMap.get("constants"));
        // System.out.println(arrCount);
        return arrCount;
    }
}