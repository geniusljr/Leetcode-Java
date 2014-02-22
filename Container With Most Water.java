public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0, j = height.length-1;
        int result = 0;
        while (i < j) {
            int min = height[i] < height[j] ? height[i] : height[j];
            if (min * (j-i) > result)
                result = min * (j-i);
            if (height[i] < height[j])
                i++;
            else 
                j--;
        }
        return result;
        
    }
}