public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] num = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                num[i][j] = (i == 0 || j == 0) ? 1 : num[i-1][j] + num[i][j-1];
        return num[m-1][n-1];
    }
}