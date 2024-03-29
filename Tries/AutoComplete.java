package com.demo.scaler.Tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class AutoComplete {
    //Problem Description
    //There is a dictionary A of N words, and ith word has a unique weight Wi.
    //
    //Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
    //
    //Output the words in decreasing order of their weight.
    //
    //NOTE: If there is no word that starts with the given prefix output -1.
    //
    //
    //
    //Problem Constraints
    //1 <= T <= 5
    //
    //1 <= N <= 20000
    //1 <= M <= 10000
    //
    //1 <= Wi <= 106
    //
    //1 <= length of any string either in A or B <= 30
    //
    //
    //
    //Input Format
    //First line is an integer T denoting the number of test cases.
    //For each test case,
    //
    //First line denotes two space seperated integer N and M.
    //Second line denotes N space seperated strings denoting the words in dictionary.
    //Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
    //Fourth line denotes M space seperated integers denoting the prefixes.
    //
    //
    //Output Format
    //For every prefix B[i], print the space seperated output on a new line.
    //
    //NOTE: After every output there should be a space.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // 1
    // 6 3
    // abcd aecd abaa abef acdcc acbcc
    // 2 1 3 4 6 5
    // ab abc a
    //Input 2:
    //
    // 1
    // 5 3
    // aaaa aacd abaa abaa aadcc
    // 3 4 1 2 6
    // aa aba abc
    //
    //
    //Example Output
    //Output 1:
    //
    // abef abaa abcd
    // abcd
    // acdcc acbcc abef abaa abcd
    //Output 2:
    //
    // aadcc aacd aaaa
    // abaa abaa
    // -1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
    // For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
    // For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
    // Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
    //Explanation 2:
    //
    // For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
    // For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
    // For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.

    public static void main(String[] args) {
        AutoCompleteSolution app = new AutoCompleteSolution();
        app.autoComplete();
    }

    static class AutoCompleteSolution {

        class WordInfo {
            public String word;
            public int weight;

            public WordInfo(String word, int weight) {
                this.word = word;
                this.weight = weight;
            }
        }

        void prefix(TrieNode root, String S, ArrayList<WordInfo> words) {
            if (root == null)
                return;

            if (root.map.size() == 0) {
                for (int i = 0; i < root.count; i++) {
                    words.add(new WordInfo(S, root.weight.get(i)));
                }

                return;
            }

            for (Character ch : root.map.keySet()) {
                prefix(root.map.get(ch), S + ch, words);
            }

            if (root.isEnd) {
                for (int i = 0; i < root.count; i++) {
                    words.add(new WordInfo(S, root.weight.get(i)));
                }
            }
        }

        class TrieNode {
            public HashMap<Character, TrieNode> map;
            public boolean isEnd;
            public ArrayList<Integer> weight;
            public int count;

            public TrieNode() {
                map = new HashMap<Character, TrieNode>();
                isEnd = false;
                weight = new ArrayList<Integer>();
                count = 0;
            }
        }

        TrieNode insert(String S, int weight, TrieNode root) {
            if (root == null) {
                root = new TrieNode();
            }

            TrieNode curr = root;

            for (int i = 0; i < S.length(); i++) {
                Character ch = S.charAt(i);

                if (!curr.map.containsKey(ch)) {
                    curr.map.put(ch, new TrieNode());
                }

                curr = curr.map.get(ch);
            }

            curr.isEnd = true;
            curr.weight.add(weight);
            curr.count++;

            return root;
        }

        public void autoComplete() {
            Scanner sc = new Scanner(System.in);

            int testCaseCount = sc.nextInt();

            for (int z = 0; z < testCaseCount; z++) {

                int N = Integer.parseInt(sc.next());
                int M = Integer.parseInt(sc.next());

                String[] dict = new String[N];
                for (int i = 0; i < N; i++) {
                    dict[i] = sc.next();
                }

                String[] weights = new String[N];
                for (int i = 0; i < N; i++) {
                    weights[i] = sc.next();
                }

                String[] queries = new String[M];
                for (int i = 0; i < M; i++) {
                    queries[i] = sc.next();
                }

                TrieNode root = new TrieNode();

                for (int i = 0; i < dict.length; i++) {
                    root = insert(dict[i], Integer.parseInt(weights[i]), root);
                }

                for (int i = 0; i < queries.length; i++) {
                    String S = queries[i];

                    TrieNode curr = root;

                    String pref = "";

                    for (int j = 0; j < S.length(); j++) {
                        Character ch = S.charAt(j);

                        if (curr.map.containsKey(ch)) {
                            pref = pref + ch;

                            curr = curr.map.get(ch);
                        } else {
                            curr = null;
                            break;
                        }
                    }

                    if (curr == null) {
                        System.out.print("-1 ");

                    } else {
                        ArrayList<WordInfo> words = new ArrayList<WordInfo>();

                        prefix(curr, pref, words);

                        Collections.sort(words, new Comparator<WordInfo>() {

                            @Override
                            public int compare(WordInfo w1, WordInfo w2) {
                                return w2.weight - w1.weight;
                            }

                        });

                        int count = 5;
                        for (WordInfo w : words) {
                            System.out.print(w.word + " ");
                            count--;
                            if (count == 0) break;
                        }
                    }

                    System.out.println();
                }
            }

            sc.close();
        }
    }
}
