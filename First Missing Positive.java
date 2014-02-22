public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i+1 && A[A[i]-1] != A[i]) {
                swap(A, i, A[i]-1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1)
                return i+1;
        }
        return A.length+1;
    }
    
    public void swap(int[] A, int i, int j) {
        A[i] ^= A[j];
        A[j] ^= A[i];
        A[i] ^= A[j];
    }
}