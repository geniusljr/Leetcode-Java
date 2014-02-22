public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1)
            return A.length;
        int index=1, cur=1, count=0, length=A.length;
        while (index < A.length) {
            if (A[index] == A[cur-1]) {
                count++;
                if (count >= 2) {
                    index++;
                    length--;
                    continue;
                }
            }
            else count = 0;
            A[cur++] = A[index++];
        }
        return length;
    }
}