package com.demo.scaler.Arrays;

public class MoveAllNegativeFirstAndPositiveEnd {
    //

    public static void main(String[] args) {
        //int arr[] = {1, 2,  -4, -5, 2, -7, 3, 2, -6, -8, -9, 3, 2,  1};
        //output = {-9 -8 -4 -5 -6 -7 3 2 2 2 1 3 2 1}
    }

    //two pointers, low=0 and high=n-1.
    //If A[low] < 0 then move low++
    //If A[high] > 0 then move high--
    //else swap only

    // Swap Function.
    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // Using Dutch National Flag Algorithm.
    void reArrange(int arr[], int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            if (arr[low] < 0) {
                low++;
            } else if (arr[high] > 0) {
                high--;
            } else {
                swap(arr[low], arr[high]);
            }
        }
    }
}