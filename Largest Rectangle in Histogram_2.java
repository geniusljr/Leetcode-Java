public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height == null || height.length == 0)
        	return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for (int i = 0; i <= height.length; i++) {
        	if (i < height.length && (stack.isEmpty() || height[stack.peek()] < height[i]))
        		stack.push(i);
        	else {
        		int flag = i == height.length ? 0 : height[i];
        		int start = 0;
        		while (!stack.isEmpty() && height[stack.peek()] >= flag) {
        			start = stack.pop();
		    		if ((i - start) * height[start] > result)
		    			result = (i-start) * height[start];
        		}
        		height[start] = flag;
        		stack.push(start);
        	}
        }
    	return result;
    }
}