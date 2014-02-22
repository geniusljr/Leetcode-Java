public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] bitCount = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            bitCount[i] = 0;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) != 0)
                    bitCount[i] = (bitCount[i] + 1) % 3;
            }
            result |= bitCount[i] << i;
        }
        return result;
    }
}