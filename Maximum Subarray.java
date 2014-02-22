public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return 0;
        int max = A[0], temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i] + (temp > 0 ? temp : 0);
            max = temp > max ? temp : max;
        }
        return max;
        
    }
}