public class Solution {
    public int minPathSum(int[][] grid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] sum = new int[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                sum[i][j] = 0;
        sum[height-1][width-1] = grid[height-1][width-1];
        for (int i = width-2; i >= 0; i--)
            sum[height-1][i] = grid[height-1][i] + sum[height-1][i+1];
        for (int i = height-2; i >= 0; i--)
            sum[i][width-1] = grid[i][width-1] + sum[i+1][width-1];
        
        for (int i = height-2; i >= 0; i--)
            for (int j = width-2; j >= 0; j--) {
                sum[i][j] = grid[i][j] + Math.min(sum[i+1][j], sum[i][j+1]);
            }
        return sum[0][0];
            
    }
}