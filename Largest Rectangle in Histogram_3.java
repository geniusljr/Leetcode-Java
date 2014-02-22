public class Solution {
    public int largestRectangleArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (height.length == 0)
            return 0;
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