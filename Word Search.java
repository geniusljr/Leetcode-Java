public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (board.length == 0 || board[0].length == 0)
            return false;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0, flag))
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, int x, int y, String word, int index, boolean[][] flag) {
        if (index == word.length())
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || flag[x][y] || board[x][y] != word.charAt(index))
            return false;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            flag[x][y] = true;
            if (exist(board, x+dx[i], y+dy[i], word, index+1, flag))
                return true;
            flag[x][y] = false;
        }
        return false;
    } 
    
    
}