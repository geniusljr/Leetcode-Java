public class Solution {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0)
            return;
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    firstRow = i == 0 || firstRow ? true : false;
                    firstCol = j == 0 || firstCol ? true : false;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (firstRow)
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;
        if (firstCol)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        return;
    }
}