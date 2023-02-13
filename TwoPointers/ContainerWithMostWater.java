package com.demo.scaler.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
    //Problem Description
    //Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
    //
    //N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
    //
    //Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    //
    //Note: You may not slant the container.
    //
    //
    //
    //Problem Constraints
    //0 <= N <= 105
    //
    //1 <= A[i] <= 105
    //
    //
    //
    //Input Format
    //Single Argument representing a 1-D array A.
    //
    //
    //
    //Output Format
    //Return single Integer denoting the maximum area you can obtain.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 5, 4, 3]
    //Input 2:
    //
    //A = [1]
    //
    //
    //Example Output
    //Output 1:
    //
    // 6
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //
    //5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
    //So total area = 3 * 2 = 6
    //Explanation 2:
    //
    //
    //No container is formed.

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 4, 3));
        int solve = maxArea(A);
        System.out.println(solve);
    }

    public static int maxArea(ArrayList<Integer> A) {
        //We are using Two pointer technique to find max area
        //Put i as first pointer at 0 index and put j as second pointer at last index
        //We calculate area each time using i and j and move i,j
        // if A[i] <= A[j] then i++ else j--

        int area = 0;
        int p1 = 0, p2 = A.size() - 1;
        while (p1 < p2) {
            int h = Math.min(A.get(p1), A.get(p2));
            int w = p2 - p1;
            int water = h * w;
            if (A.get(p1) <= A.get(p2)) {
                p1++;
            } else {
                p2--;
            }
            area = Math.max(area, water);
        }
        return area;
    }
}
