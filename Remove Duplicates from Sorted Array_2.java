public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null) return 0;
        if (A.length <= 1) return A.length;
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[index])
                A[++index] = A[i];
        }
        return index+1;
    }
}