public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0)
            return 0;
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i < n+1; i++) {
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
        
    }
}