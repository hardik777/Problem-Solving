package com.demo.scaler.Advanced;

import java.util.ArrayList;

public class MergeIntervals {
    //Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    //
    //You may assume that the intervals were initially sorted according to their start times.
    //
    //
    //
    //Problem Constraints
    //0 <= |intervals| <= 105
    //
    //
    //
    //Input Format
    //First argument is the vector of intervals
    //
    //second argument is the new interval to be merged
    //
    //
    //
    //Output Format
    //Return the vector of intervals after merging
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
    //Input 2:
    //
    //Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
    //
    //
    //Example Output
    //Output 1:
    //
    // [ [1, 5], [6, 9] ]
    //Output 2:
    //
    // [ [1, 9] ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //(2,5) does not completely merge the given intervals
    //Explanation 2:
    //
    //(2,6) completely merges the given intervals

    public static void main(String[] args) {

    }


    //Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();

        int n = intervals.size();

        for (int i = 0; i < n; i++) {
            Interval currInterval = intervals.get(i);

            //non overlapping condition 1
            //ex - currInterval - [2,5] & new Interval - [8,10]
            //we just push currInterval to ans;
            //right
            if (currInterval.end < newInterval.start) {
                ans.add(currInterval);
            }

            //non overlapping condition 2
            //ex - currInterval - [8,10] & new Interval - [2,5]
            //we push newInterval to ans and then remaining all intervals;
            //left
            else if (newInterval.end < currInterval.start) {
                ans.add(newInterval);
                for (int j = i; j < n; j++) {
                    ans.add(intervals.get(j));
                }
                return ans;
            }
            //overlapping
            //merge both intervals and update the new interval
            //ex - currInterval [10,14] & newInterval - [12,22]
            // then new interval becomes [10,22] and proceed to check with next intervals
            else {
                newInterval.start = Math.min(currInterval.start, newInterval.start);
                newInterval.end = Math.max(currInterval.end, newInterval.end);
            }
        }

        //edge case
        // if the newInterval is outside of range of all intervals then at last
        //its pushed to ans.
        ans.add(newInterval);

        // for (Interval interval : ans) {
        //     System.out.println(interval.start + "," + interval.end);
        // }
        return ans;
    }
}