package com.demo.scaler.Advanced.BinarySearch;

import java.util.ArrayList;

public class FoodPacketsDistribution {
    //Problem Description
    //The government wants to set up B distribution offices across N cities for the distribution of food
    //packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //
    //1 <= A[i] <= 106
    //
    //1 <= B <= 5 x 105
    //
    //
    //
    //Input Format
    //The first line of input contains an integer array A.
    //
    //The second line of input contains an integer B.
    //
    //
    //
    //Output Format
    //Return one integer representing the maximum number of people who can get food in any single office.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //  A = [10000, 20000, 30000]
    //  B = 6
    //Input 2:
    //
    //  A = [1, 1, 1]
    //  B = 4
    //
    //
    //Example Output
    //Output 1:
    //
    //  10000
    //Output 2:
    //
    //  0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //  1 office can be opened in the first city,
    //  2 offices in the second city and
    //  3 in the third. This way ,
    //  10,000 people can get food in the office in the first city, and
    //  10,000 people can get food in each office in the second city and
    //  10,000 people can get food in third city.
    //  We will allot 10000 people in each office in the third city.
    //  Had we alloted more in some office, we had to allot lesser in some other office which will reduce the answer.
    //Explanation 2:
    //
    //  We will have to allot 2 offices to one city. And one of these offices would give food to 0 people.

    public static void main(String[] args) {

    }

    //Algorithm:
    //1. As maximum of minimum population entered into B offices is between "0" and "Minimum Element in array" which are considered as left and right variables. Consider Mid population as (left+right)/2 and calculate no of offices should be required for this mid value (considering mid number of people go to each office) using check function by dividing each element in array and add these will give no of offices required .
    //2. if no of offices required>=B  increment left value by 1 and store answer with mid as we required maximum of minimum value there by increases no of people enters into office increases as no offices required greater than B.
    //3. if noofofficesrequired < B then reduced right by mid-1 there by decreases mid(no of population enter per office get reduced) which may come closer to B no of offices
    //4. Repeat the process until left>mid.
    //one of edge case is when mid is 0 then we just add all elements.

    // Time Complexity - O(N.LOG(N)) Space Complexity - O(1)
    public static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        long sum = 0;
        int minimum = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            minimum = Math.min(minimum, A.get(i));
            sum += A.get(i);
        }

        // to check edge case
        if (B > sum) {
            return 0;
        }

        // main code
        int left = 1;
        int right = minimum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (checkForPopulation(A, B, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // System.out.println(ans);
        return ans;
    }

    public static boolean checkForPopulation(ArrayList<Integer> A, int B, int k) {
        int n = A.size();
        long requiredOffice = 0;
        for (int i = 0; i < n; i++) {
            requiredOffice += A.get(i) / k;
        }
        if (requiredOffice >= B) {
            return true;
        }
        return false;
    }
}