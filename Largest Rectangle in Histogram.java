//not sure whether it's right

public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height == null || height.length == 0)
        	return 0;
        Stack<Rectangle> stack = new Stack<Rectangle>();
        int result = 0;

        stack.push(new Rectangle(1, 0));
        for (int i = 0; i < height.length; i++) {
        	if (stack.peek().height < height[i])
        		stack.push(new Rectangle(1, height[i]));
        	else {
        		int width = 0;
        		while (!stack.isEmpty() && stack.peek().height >= height[i])  {
        			Rectangle temp = stack.pop();
        			width += temp.width;
        			if (temp.height * width > result)
        				result = temp.height * width;
        		}
        		width++;
        		stack.push(new Rectangle(height[i], width));
        	}
        }

        int width = 0;
        while (!stack.isEmpty()) {
        	Rectangle temp = stack.pop();
			width += temp.width;
			if (temp.height * width > result)
				result = temp.height * width;
        }
        return result;
    }

    class Rectangle {
    	int width;
    	int height;
    	Rectangle(int _width, int _height) {
    		width = _width;
    		height = _height;
    	}
    }
}