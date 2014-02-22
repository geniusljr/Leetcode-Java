public class Solution {
    public int totalNQueens(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] solutionNum = {0};
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        putQueens(board, 0, solutionNum);
        return solutionNum[0];
    }
    
    void putQueens(char[][] board, int row, int[] solutionNum) {
        if (row == board.length) {
            solutionNum[0]++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isLegal(board, row, i)) {
                board[row][i] = 'Q';
                putQueens(board, row+1, solutionNum);
                board[row][i] = '.';
            }
        }
        return;
        
    }
    
    boolean isLegal(char[][] board, int row, int col) {
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
                
            int tempCol = col - row + i;
            if (tempCol >= 0 && tempCol < board.length && board[i][tempCol] == 'Q')
                return false;
                
            tempCol = col + row - i;
            if (tempCol >= 0 && tempCol < board.length && board[i][tempCol] == 'Q')
                return false;
        }
        return true;
    }
}