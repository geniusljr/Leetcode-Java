public class Solution {
    public int totalNQueens(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int upper = (1 << n) -1;
        int[] count = {0};
        queen(0, 0, 0, upper, count);
        return count[0];
    }
    
    public void queen(int row, int ld, int rd, int upper, int[] count) {
        if (row != upper) {
            int pos = upper & (~(row | ld | rd));
            while (pos != 0) {
                int p = pos & (-pos);
                pos -= p;
                queen(row+p, (ld+p) << 1, (rd+p) >> 1, upper, count);
            }
        } else {
            count[0]++;
        }
    }
}