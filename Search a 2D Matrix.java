public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target)
            return false;
        int i = 0, j = 0;
        while (i < matrix.length && matrix[i][0] <= target) {
            i++;
        }
        i--;
        while (j < matrix[0].length && matrix[i][j] != target) {
            j++;
        }
        if (j == matrix[i].length)
            return false;
        return true;
    }
}