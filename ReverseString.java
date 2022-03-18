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
