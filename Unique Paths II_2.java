public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[] num = new int[width];
        num[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < width; i++) {
            num[i] = obstacleGrid[0][i] == 1 ? 0 : num[i-1];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                num[j] = obstacleGrid[i][j] == 1 ? 0 : (num[j] + (j != 0 ? num[j-1] : 0));
            }
        }
        return num[width-1];
        
    }
}