public class Solution {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 0, len = A.length;
        while (index < len) {
            A[index] = A[index] == elem ? A[--len] : A[index++];
        }
        return len;
    }
}