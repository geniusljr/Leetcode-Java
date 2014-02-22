public class Solution {
    public void rotate(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = matrix.length;
        if (n <= 1)
            return;
        int[] startX = {0, 0, n-1, n-1};
        int[] startY = {0, n-1, n-1, 0};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] judge = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                judge[i][j] = false;
        int mov = 0;
        while (true) {
            int temp = matrix[startX[0]][startY[0]];
            matrix[startX[0]][startY[0]] = matrix[startX[3]][startY[3]];
            matrix[startX[3]][startY[3]] = matrix[startX[2]][startY[2]];
            matrix[startX[2]][startY[2]] = matrix[startX[1]][startY[1]];
            matrix[startX[1]][startY[1]] = temp;
            for (int i = 0; i < 4; i++) {
                judge[startX[i]][startY[i]] = true;
            }
            for (int i = 0; i < 4; i++) {
                if (judge[startX[i]+dx[(i+mov)%4]][startY[i]+dy[(i+mov)%4]])
                    mov = (mov+1) % 4;
                startX[i] += dx[(i+mov)%4];
                startY[i] += dy[(i+mov)%4];
                if (judge[startX[i]][startY[i]])
                    return;
            }
        }
    }
}