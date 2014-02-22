public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = i == 0 ? 1 : height[i-1][j]+1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int cur = largestRectangleArea(height[i]);
            max = cur > max ? cur : max;
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> stack = new Stack<Integer>();
        int[] h = Arrays.copyOf(height, height.length+1);
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] < h[i])
                stack.push(i++);
            else {
                int t = stack.pop();
                max = Math.max(max, h[t] * (stack.isEmpty() ? i : i-stack.peek()-1)); 
            }
        }
        return max;
    }
}