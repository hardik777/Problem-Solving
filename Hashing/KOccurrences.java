package com.demo.scaler.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class KOccurrences {
    //Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
    //
    //He wants to select some trees to replace his broken branches.
    //
    //But he wants uniformity in his selection of trees.
    //
    //So he picks only those trees whose heights have frequency B.
    //
    //He then sums up the heights that occur B times. (He adds the height only once to the sum and not B times).
    //
    //But the sum he ended up getting was huge so he prints it modulo 10^9+7.
    //
    //In case no such cluster exists, Groot becomes sad and prints -1.
    //
    //Constraints:
    //
    //1.   1<=N<=100000
    //2.   1<=B<=N
    //3.   0<=H[i]<=10^9
    //Input: Integers N and B and an array C of size N
    //
    //Output: Sum of all numbers in the array that occur exactly B times.
    //
    //Example:
    //
    //Input:
    //
    //N=5 ,B=2 ,C=[1 2 2 3 3]
    //Output:
    //
    //5
    //Explanation:
    //
    //There are 3 distinct numbers in the array which are 1,2,3.
    //Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.

    public static void main(String[] args) {

    }

    public int getSum(int N, int B, ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i))) {
                int val = map.get(arr.get(i));
                map.remove(arr.get(i));
                val++;
                map.put(arr.get(i), val);
            } else {
                map.put(arr.get(i), 1);
            }
        }
        int sum = 0;
        int flag = 0;
        if (map.containsKey(0) && map.get(0) == B) {
            flag = 1;
        }
        for (int i = 0; i < arr.size(); i++) {
            int val = map.get(arr.get(i));
            if (val == B) {
                sum += arr.get(i);
                sum %= 1000000007;
                map.remove(arr.get(i));
                map.put(arr.get(i), 0);
            }
        }
        if (sum == 0 && flag == 0) {
            return -1;
        }
        return sum;
    }
}