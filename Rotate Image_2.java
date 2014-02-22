public class Solution {
    public void rotate(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = matrix.length;
        if (n <= 1)
            return;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer, last = n-layer-1;
            for (int i = first; i < last; i++) {
                int offset = i-first;
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[last-offset][layer];
                matrix[last-offset][layer] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
        return;
    }
}