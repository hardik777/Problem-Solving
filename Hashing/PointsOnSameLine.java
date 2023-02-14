package com.demo.scaler.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnSameLine {
    //Problem Description
    //Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
    //
    //Find and return the maximum number of points that lie on the same line.
    //
    //
    //
    //Problem Constraints
    //1 <= (length of the array A = length of array B) <= 1000
    //
    //-105 <= A[i], B[i] <= 105
    //
    //
    //
    //Input Format
    //The first argument is an integer array A.
    //The second argument is an integer array B.
    //
    //
    //
    //Output Format
    //Return the maximum number of points which lie on the same line.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [-1, 0, 1, 2, 3, 3]
    // B = [1, 0, 1, 2, 3, 4]
    //Input 2:
    //
    // A = [3, 1, 4, 5, 7, -9, -8, 6]
    // B = [4, -8, -3, -2, -1, 5, 7, -4]
    //
    //
    //Example Output
    //Output 1:
    //
    // 4
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
    //Explanation 2:
    //
    // Any 2 points lie on a same line.

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size(), totalPoints = 0, equal, maxi;
        HashMap<String, Integer> hm = new HashMap<>(); // we can also create HashMap inside the outer loop
        for (int i = 0; i < n; i++) { // but then we have to remove #hm.clear() method.
            maxi = 0;
            equal = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) == A.get(j) && B.get(i) == B.get(j)) equal++; //for points that are overlaping.
                else {
                    int x = A.get(j) - A.get(i); //slope for any 2 points with co-ordinates (x,y) & (x1,y1)
                    int y = B.get(j) - B.get(i); // is (y1-y)/(x1-x)
                    int gcd = GCD(y, x); // dividing every co-ordinates with their gcd to get smallest
                    String str = (x / gcd) + "*" + (y / gcd); // possible ratio and then converting them to string.
                    hm.put(str, hm.getOrDefault(str, 0) + 1);
                    maxi = Math.max(maxi, hm.get(str));
                }
            }
            totalPoints = Math.max(totalPoints, equal + maxi + 1);// this extra 1 is added because for any
            // frequency in HashMap the count of corresponding or fixed point should also be counted
            hm.clear();
        }
        return totalPoints;
    }

    public static int GCD(int x, int y) {
        if (x == 0) return y;
        return GCD(y % x, x);
    }
}