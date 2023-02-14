package com.demo.scaler.Advanced.Sorting

class KthSmallestNumberUsingMergeSort {
    //Problem Description
    //Find the Bth smallest element in given array A .
    //
    //NOTE: Users should try to solve it in less than equal to B swaps.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= B <= min(|A|, 500)
    //
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The first argument is an integer array A.
    //
    //The second argument is integer B.
    //
    //
    //
    //Output Format
    //Return the Bth smallest element in given array.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [2, 1, 4, 3, 2]
    //B = 3
    //Input 2:
    //
    //A = [1, 2]
    //B = 2
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 3rd element after sorting is 2.
    //Explanation 2:
    //
    // 2nd element after sorting is 2.

    fun kthsmallest(A: IntArray, K: Int): Int {
        //Using Merge Sort

        //Edge Case
        if (K > A.size) return -1

        val mergeSort = mergeSort(A, 0, A.size - 1)
        // print(mergeSort)
        // print(mergeSort[K - 1])
        return mergeSort[K - 1]
    }

    private fun mergeSort(A: IntArray, s: Int, e: Int): IntArray {
        //Base Case
        if (s >= e) return intArrayOf(A[s])

        //Rec Case
        var mid = (s + e) / 2
        var arr1 = mergeSort(A, s, mid)
        var arr2 = mergeSort(A, mid + 1, e)
        return merge(arr1, arr2)
    }

    fun merge(A: IntArray, B: IntArray): IntArray {
        var n = A.size
        var m = B.size
        var c = IntArray(n + m)
        var p = 0;
        var i = 0
        var j = 0
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                c[p] = A[i]
                p++
                i++
            } else {
                c[p] = B[j]
                j++
                p++
            }
        }

        while (i < n) {
            c[p] = A[i]
            i++
            p++
        }
        while (j < m) {
            c[p] = B[j]
            j++
            p++
        }
        return c
    }
}