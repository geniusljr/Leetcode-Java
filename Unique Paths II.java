public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int height = obstacleGrid.length;
        if (height == 0)
            return 0;
        int width = obstacleGrid[0].length;
        if (width == 0)
            return 0;
        int[][] num = new int[height][width];
        num[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < width; i++) {
            num[0][i] = obstacleGrid[0][i] == 1 ? 0 : num[0][i-1];
        }
        for (int i = 1; i < height; i++) {
            num[i][0] = obstacleGrid[i][0] == 1 ? 0 : num[i-1][0];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                num[i][j] = obstacleGrid[i][j] == 1 ? 0 : num[i-1][j] + num[i][j-1];
            }
        }
        return num[height-1][width-1];
    }
}