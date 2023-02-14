package com.demo.scaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidPath {
    //Problem Description
    //There is a rectangle with left bottom as (0, 0) and right up as (x, y).
    //
    //There are N circles such that their centers are inside the rectangle.
    //
    //Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
    //
    //Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
    //
    //
    //
    //Problem Constraints
    //0 <= x , y, R <= 100
    //
    //1 <= N <= 1000
    //
    //Center of each circle would lie within the grid
    //
    //
    //
    //Input Format
    //1st argument given is an Integer x , denoted by A in input.
    //
    //2nd argument given is an Integer y, denoted by B in input.
    //
    //3rd argument given is an Integer N, number of circles, denoted by C in input.
    //
    //4th argument given is an Integer R, radius of each circle, denoted by D in input.
    //
    //5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
    //
    //6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
    //
    //
    //
    //Output Format
    //Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // x = 2
    // y = 3
    // N = 1
    // R = 1
    // A = [2]
    // B = [3]
    //Input 2:
    //
    // x = 1
    // y = 1
    // N = 1
    // R = 1
    // A = [1]
    // B = [1]
    //
    //
    //Example Output
    //Output 1:
    //
    // NO
    //Output 2:
    //
    // NO
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // There is NO valid path in this case
    //Explanation 2:
    //
    // There is NO valid path in this case

    public static void main(String[] args) {

    }

    public static String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        return isValidPath(A, B, C, D, E, F) ? "YES" : "NO";
    }

    public static boolean isValid(int i, int j, int n, int m, boolean[][] visited, ArrayList<Integer> E, ArrayList<Integer> F, int radius) {
        return i >= 0 && j >= 0 && i < n && j < m && !visited[i][j] && !isPointInsideCircle(i, j, E, F, radius);
    }

    public static boolean isPointInsideCircle(int x, int y, ArrayList<Integer> E, ArrayList<Integer> F, int radius) {
        double k = 0;
        boolean ans = true;
        for (int i = 0; i < E.size(); ++i) {
            k = Math.pow(E.get(i) - x, 2) + Math.pow(F.get(i) - y, 2) - radius * radius;
            int q = k <= 0 ? 1 : 0;
            if (q == 1) {
                return true;//point is inside or on boundary
            }
        }
        return false; //No transition is done
    }

    public static boolean dfs(int i, int j, int n, int m, boolean[][] visited, int[] dx, int[] dy, ArrayList<Integer> E, ArrayList<Integer> F, int radius) {
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean ans = false;
        for (int k = 0; k < dx.length; ++k) {
            if (isValid(i + dx[k], j + dy[k], n, m, visited, E, F, radius)) {
                ans = ans | dfs(i + dx[k], j + dy[k], n, m, visited, dx, dy, E, F, radius);
            }
        }
        return ans;
    }

    public static boolean isValidPath(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        boolean[][] visited = new boolean[A + 1][B + 1];
        int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
        for (int i = 0; i <= A; ++i) {
            Arrays.fill(visited[i], false);
        }
        //If (0,0) or (A,B) are within the circle that means circle is exceeding the rectangle and we will
        //assume that in this case circle passes from the corner points (0,0) && (A,B);
        if (isPointInsideCircle(0, 0, E, F, D) || isPointInsideCircle(A, B, E, F, D)) {
            return false;
        }

        return dfs(0, 0, A + 1, B + 1, visited, dx, dy, E, F, D);
    }
}