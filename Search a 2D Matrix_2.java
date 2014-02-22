public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target)
            return false;
        int row = 0, col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] > target)
                col--;
            else row++;
        }
        return false;
    }
}
