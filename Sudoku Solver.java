public class Solution {
    public boolean solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        board[i][j] = (char)('1'+k);
                        if (isValid(board, i, j) && solveSudoku(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        return true;
    }
    
    boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++)
            if ( (i != y && board[x][i] == board[x][y]) || (i != x && board[i][y] == board[x][y]))
                return false;
        for (int i = 3*(x/3); i < 3*(x/3 + 1); i++)
            for (int j = 3*(y/3); j < 3*(y/3 + 1); j++)
                if (i != x && j != y && board[i][j] == board[x][y])
                    return false;
        return true;
    }
}