public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] num = {0, 0, 0};
        for (int i = 0; i < A.length; i++) {
            num[A[i]]++;
        }
        for (int i = 0; i < num[0]; i++)
            A[i] = 0;
        for (int i = num[0]; i < num[0]+num[1]; i++)
            A[i] = 1;
        for (int i = num[0]+num[1]; i < A.length; i++)
            A[i] = 2;
    }
}