public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return result;
        int minX = 0, maxX = matrix.length-1, minY = 0, maxY = matrix[0].length-1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int mov = 0;
        int curX = 0, curY = 0;
        while (true) {
            result.add(matrix[curX][curY]);
            if (!valid(curX+dx[mov], curY+dy[mov], minX, maxX, minY, maxY)) {
                mov = (mov+1) % 4;
                if (!valid(curX+dx[mov], curY+dy[mov], minX, maxX, minY, maxY))
                    return result;
                if (mov == 1) {minX++;}
                if (mov == 2) {maxY--;}
                if (mov == 3) {maxX--;}
                if (mov == 0) {minY++;}
            }
            curX += dx[mov];
            curY += dy[mov];
        }
    }
    
    public boolean valid(int x, int y, int minX, int maxX, int minY, int maxY) {
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
}