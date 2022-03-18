public class PalindromString {
    public static void main(String[] args) {
        solve("axax");
    }

    public static int solve(String A) {

        String res = "";
        for (int i = 0; i < A.length(); i++) {
            res = A.charAt(i) + res;
        }

        if (res.equals(A)) return 1;
        else return 0;
    }
}
