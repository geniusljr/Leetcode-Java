public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[][] result = new int[n][n];
        if (n == 0)
            return result;
        boolean[][] judge = new boolean[n+2][n+2];
        for (int i = 0; i < judge.length; i++) {
            for (int j = 0; j < judge[0].length; j++)
                judge[i][j] = (i == 0 || j == 0 || i == judge.length-1 || j == judge[0].length-1) ? true : false;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int mov = 0;
        int curI = 0, curJ = -1;
        int num = 1;
        while (true) {
            if (judge[curI+dx[mov]+1][curJ+dy[mov]+1]) {
                mov = (mov+1) % 4;
                if (judge[curI+dx[mov]+1][curJ+dy[mov]+1])
                    return result;
            }
            curI += dx[mov];
            curJ += dy[mov];
            judge[curI+1][curJ+1] = true;
            result[curI][curJ] = num++;
        }
    }
}