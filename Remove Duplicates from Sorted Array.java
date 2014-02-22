public class Solution {
    public static int removeDuplicates(int[] A) {
            // Start typing your Java solution below
	        // DO NOT write main() function
	        int num = 0;
	        int length = A.length;
	        for (int i = 1; i < length; i++) {
	            if (A[i] == A[i-1]) {
	                num++;
                    if (i < length-1)
	                    continue;
	            }
                
	            for (int j = i; j < length; j++) {
	                A[j-num] = A[j];
	            }
                length -= num;
                i -= num;
	            num = 0;
	        }
	        return length;
	    }
}