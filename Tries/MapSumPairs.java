package com.demo.scaler.Tries;

import java.util.ArrayList;
import java.util.HashMap;

public class MapSumPairs {
    //Problem Description
    //
    //Rishabh was sitting ideally in his office and then suddenly his boss gave him some operations to perform.
    //
    //You being his friend tried to help him in finishing the task fast.
    //
    //So you have to perform Q operation of two types:
    //
    //Operation 1: INSERT : You are given an pair of (string, integer).The string represents the key and the integer represents the value. Insert the key-value pair in the hash and If the key already exists in hash, then the original key-value pair will be overridden to the new one.
    //Operation 2: SUM : you'll be given an pair of (string, -1) where string representing the prefix, and you need to return the sum of all the pairs' value in the hash whose key starts with the prefix.
    //
    //
    //Problem Constraints
    //
    //1 <= Q <= 103
    //
    //1 <= Length of string in any operation <= 30
    //
    //Strings in each operations only consists of lowercase characters.
    //
    //1 <= Integer in Operation 1 <= 100
    //
    //Integer in operation 2 is always -1 so this parameter will help you in distinguishing between the two opearations.
    //
    //
    //
    //Input Format
    //
    //First argument is an string array A of size Q denoting the first parameter of each operations.
    //
    //Seond argument is an integer array B of size Q denoting the second parameter of each operations.
    //
    //NOTE: ith query will be like (A[i], B[i])
    //
    //
    //
    //Output Format
    //
    //Return an integer array denoting the answer for each operation of type: 2
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = ["apple", "ap", "app", "ap"]
    // B = [3, -1, 2, -1]
    //Input 2:
    //
    // A = ["ban", "banana", "ba"]
    // B = [10, -1, -1]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // [3, 5]
    //Output 2:
    //
    // [0, 10]
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "apple" in our hash and store its value as 3.
    // 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our
    //    hash whose prefix is  "ap". Only "apple" has its prefix as "ap" so we will return 3
    // 3. (A[2], B[2]) is a type-1 operation as B[2] != -1 so we will insert "app" in our hash and store its value as 2.
    // 4. (A[3], B[3]) is a type-2 operation as B[3] == -1 so we will search for every string inserted in our
    //    hash whose prefix is  "ap". So both ["apple", "app"] has its prefix as "ap" so we will return 3 + 2 i.e 5
    //Explanation 2:
    //
    // 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "ban" in our hash and store its value as 10.
    // 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our
    //    hash whose prefix is  "banana". So there doesn't exist any string whose prefix is "banana" so we will return 0
    // 3. (A[2], B[2]) is a type-2 operation as B[2] == -1 so we will search for every string inserted in our
    //    hash whose prefix is  "ba". Only "ban" has its prefix as "ba" so we will return 10.

    public static void main(String[] args) {

    }

    class TrieNode {
        TrieNode[] children;
        int sum;
        boolean isEnd;

        public TrieNode(int val) {
            this.children = new TrieNode[26];
            this.sum = val;
            this.isEnd = false;
        }

        public void incrementSum(int val) {
            this.sum += val;
        }

        public int getSum() {
            return this.sum;
        }
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<Integer> B) {
        int N = A.size();
        TrieNode root = new TrieNode(0);
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (B.get(i).intValue() == -1) {
                res.add(sum(root, A.get(i)));
            } else {
                if (map.containsKey(A.get(i))) {
                    this.insert(root, A.get(i), B.get(i) - map.get(A.get(i)));
                } else {
                    this.insert(root, A.get(i), B.get(i));
                }

                map.put(A.get(i), B.get(i));
            }
        }

        return res;
    }

    public int sum(TrieNode root, String prefix) {
        int sum = 0;
        TrieNode temp = root;
        int N = prefix.length();
        for (int i = 0; i < N; i++) {
            char ch = prefix.charAt(i);

            if (temp.children[ch - 'a'] != null) {
                temp = temp.children[ch - 'a'];
            } else {
                return 0;
            }
        }

        return temp.getSum();
    }

    public void insert(TrieNode root, String key, int val) {
        TrieNode temp = root;
        int N = key.length();
        for (int i = 0; i < N; i++) {
            char ch = key.charAt(i);

            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode(val);
            } else {
                temp.children[ch - 'a'].incrementSum(val);
            }

            temp = temp.children[ch - 'a'];
        }
    }
}