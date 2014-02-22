public class Solution {
    public int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = T.length(), n = S.length();
        if (m > n || m == 0 || n == 0)
            return 0;
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 0;
            }
        }
        a[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            a[0][i] = a[0][i-1] + (S.charAt(i) == T.charAt(0) ? 1 : 0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                a[i][j] = a[i][j-1] + (T.charAt(i) == S.charAt(j) ? a[i-1][j-1] : 0);
            }
        }
        return a[m-1][n-1];
    }
}