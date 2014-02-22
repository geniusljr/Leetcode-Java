public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0)
            return 0;
        for (int i = 1; i < A.length; i++) {
            A[i] ^= A[i-1];
        }
        return A[A.length-1];
    }
}