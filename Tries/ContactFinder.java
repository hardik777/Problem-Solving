package com.demo.scaler.Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ContactFinder {
    //Problem Description
    //
    //We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
    //
    //Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
    //
    //Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
    //
    //You have been given sequential add and find operations. You need to perform each operation in order.
    //
    //And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
    //
    //
    //
    //Problem Constraints
    //
    //1 <= |A| <= 10000
    //
    //1 <= |length of strings in B| <= 10
    //
    //
    //
    //Input Format
    //
    //First argument is the vector A, which denotes the type of query.
    //
    //Second argument is the vector B, which denotes the string for corresponding query.
    //
    //
    //
    //Output Format
    //
    //Return an array of integers, denoting answers for each query of type 1.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    //A = [0, 0, 1, 1]
    //B = ["hack", "hacker", "hac", "hak"]
    //Input 2:
    //
    //A = [0, 1]
    //B = ["abcde", "abc"]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    //
    //[2, 0]
    //Output 2:
    //
    //[1]
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    //
    //We perform the following sequence of operations:
    //Add a contact named "hack".
    //Add a contact named "hacker".
    //Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
    //Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
    //Explanation 2:
    //
    //
    //Add "abcde"
    //Find words with prefix "abc". We have answer as 1.

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1));
        ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList("s", "ss", "sss", "ssss", "sssss", "s", "ss", "sss", "ssss", "sssss", "ssssss"));
        ArrayList<Integer> solve = solve(arr1, arr2);
        System.out.print(solve);
    }

    static Node root;

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        root = new Node('*');
        ArrayList<Integer> list = new ArrayList<>();

        //Insert into Trie
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                //Add
                insertIntoTrie(B.get(i));
            } else {
                //Find
                int count = findPrefix(B.get(i));
                list.add(count);
            }
        }
//         System.out.println(list);
        return list;
    }

    public static int findPrefix(String word) {
        Node temp = root;
        int ans = 0;

        for (Character ch : word.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                return 0;
            }

            //Updating the current temp with the next node.
            temp = temp.children.get(ch);

            ans = temp.count;
        }
        return ans;
    }

    public static void insertIntoTrie(String word) {
        Node temp = root;

        for (Character ch : word.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new Node(ch));
            }

            //Updating the current temp with the next node.
            temp = temp.children.get(ch);

            // Keep tracking of the count of words going through this Character
            temp.count = temp.count + 1;
        }
    }

    public static class Node {
        char data;
        HashMap<Character, Node> children = new HashMap<>();
        int count = 0;
        boolean isTerminal = false;

        Node(char data) {
            this.data = data;
        }
    }
}
