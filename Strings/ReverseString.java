// Problem Description
// Write a program to reverse the words present in a string. Everything else should be preserved.
// Check example input/output. Note: There are no punctuation and special characters in the string.
// The string will only contain alphanumeric characters and spaces.


// Example Input
// Everyone loves data science


// Example Output
// enoyrevE sevol atad ecneics

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        //Everyone loves data science

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        String temp = "";

        String[] array = word.split(" ");

        for (int i = 0; i < array.length; i++) {

            temp = "";
            String text = array[i];
            for (int j = 0; j < text.length(); j++) {
                temp = text.charAt(j) + temp;
            }
            if (i == array.length - 1) {
                System.out.print(temp);
            } else {
                System.out.print(temp + " ");
            }

        }

    }
}
