public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return result;
        boolean[][] judge = new boolean[matrix.length+2][matrix[0].length+2];
        for (int i = 0; i < judge.length; i++) {
            for (int j = 0; j < judge[0].length; j++)
                judge[i][j] = (i == 0 || j == 0 || i == judge.length-1 || j == judge[0].length-1) ? true : false;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int mov = 0;
        int curI = 0, curJ = -1;
        while (true) {
            if (judge[curI+dx[mov]+1][curJ+dy[mov]+1]) {
                mov = (mov+1) % 4;
                if (judge[curI+dx[mov]+1][curJ+dy[mov]+1])
                    return result;
            }
            curI += dx[mov];
            curJ += dy[mov];
            judge[curI+1][curJ+1] = true;
            result.add(matrix[curI][curJ]);
        }
    }
}