public class Solution {
    public boolean canJump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) return false;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < i) return false;
            max = A[i] + i > max ? A[i]+i : max;
            if (max >= A.length-1) return true;
        }
        return false;
    }
}