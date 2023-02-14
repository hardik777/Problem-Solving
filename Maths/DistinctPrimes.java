package com.demo.scaler.Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DistinctPrimes {
    //You have given an array A having N integers. Let say G is the product of all elements of A.
    //
    //You have to find the number of distinct prime divisors of G.
    //
    //
    //
    //Input Format
    //
    //The first argument given is an Array A, having N integers.
    //Output Format
    //
    //Return an Integer, i.e number of distinct prime divisors of G.
    //Constraints
    //
    //1 <= N <= 1e5
    //1 <= A[i] <= 1e5
    //For Example
    //
    //Input:
    //    A = [1, 2, 3, 4]
    //Output:
    //     2
    //
    //Explanation:
    //    here G = 1 * 2 * 3 * 4 = 24
    //    and distinct prime divisors of G are [2, 3]

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        int solve = solve(A);
        System.out.println(solve);
    }

    public static int solve(ArrayList<Integer> A) {
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            int sq = (int) Math.sqrt(A.get(i));

            for (int j = 2; j <= sq; j++) {
                if (A.get(i) % j == 0) {
                    list.add(j);
                    while (A.get(i) % j == 0) {
                        A.set(i, A.get(i) / j);
                    }
                }
            }
            System.out.println(A);
            if (A.get(i) > 1) {
                list.add(A.get(i));
            }
        }
        return list.size();
    }
}
