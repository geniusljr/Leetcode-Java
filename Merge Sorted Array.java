public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index = m+n-1;
        while (index >= 0) {
            if (m == 0)
                A[index--] = B[--n];
            else if (n == 0)
                A[index--] = A[--m];
            else A[index--] = A[m-1] > B[n-1] ? A[--m] : B[--n];
        }
        return;
    }
}