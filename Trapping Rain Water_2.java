public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length <= 2)
            return 0;
        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];
        int max = A[0];
        for (int i = 1; i < A.length-1; i++) {
            maxL[i] = max;
            max = A[i] > max ? A[i] : max;
        }
        max = A[A.length-1];
        for (int i = A.length-2; i > 0; i--) {
            maxR[i] = max;
            max = A[i] > max ? A[i] : max;
        }
        
        int result = 0;
        for (int i = 1; i < A.length-1; i++) {
            result += Math.min(maxL[i], maxR[i])-A[i] > 0 ? Math.min(maxL[i], maxR[i])-A[i] : 0;
        }
        return result;
    }
}