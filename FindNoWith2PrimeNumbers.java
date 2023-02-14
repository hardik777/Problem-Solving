package com.demo.scaler.Advanced.Prime;

import java.util.ArrayList;

public class FindNoWith2PrimeNumbers {
    //Problem Description
    //Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
    //
    //If there is more than one solution possible, return the lexicographically smaller solution.
    //
    //If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
    //[a, b] < [c, d], If a < c OR a==c AND b < d.
    //NOTE: A solution will always exist. Read Goldbach's conjecture.
    //
    //
    //
    //Problem Constraints
    //4 <= A <= 2*107
    //
    //
    //
    //Input Format
    //First and only argument of input is an even number A.
    //
    //
    //
    //Output Format
    //Return a integer array of size 2 containing primes whose sum will be equal to given number.
    //
    //
    //
    //Example Input
    // 4
    //
    //
    //Example Output
    // [2, 2]
    //
    //
    //Example Explanation
    // There is only 1 solution for A = 4.

    public static void main(String[] args) {

    }

    public ArrayList<Integer> primesum(int A) {
        int[] sieve = sieve(A);
        int i = 0, j = sieve.length - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        while (i <= j) {
            sum = sieve[i] + sieve[j];
            if (sum == A) {
                arr.add(sieve[i]);
                arr.add(sieve[j]);
                // System.out.println(arr);
                return arr;
            } else if (sum > A) {
                j--;
            } else if (sum < A) {
                i++;
            }
        }
        return arr;
    }

    public static int[] sieve(int A) {
        boolean[] sieve = new boolean[A + 1];
        int x = 0;

        //set all true by default
        for (boolean b : sieve) {
            sieve[x] = true;
            x++;
        }

        //set false which are not prime
        for (int i = 2; i * i < A; i++) {
            if (sieve[i] == true) {
                for (int j = i * i; j < A; j += i) {
                    sieve[j] = false;
                }
            }
        }

        //store all true numbers which are prime into new array
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 2; i < A; i++) {
            if (sieve[i] == true) {
                temp.add(i);
            }
        }

        int[] primeSieve = new int[temp.size()];
        x = 0;
        for (int i : temp) {
            primeSieve[x] = i;
            x++;
        }
        return primeSieve;
    }
}
