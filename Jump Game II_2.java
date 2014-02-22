public class Solution {
    public int jump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int ret = 0, last = 0, cur = 0;
    	for (int i = 0; i < A.length; i++) {
    	    if (i > cur)
    	        return Integer.MAX_VALUE;
    		if (i > last) {
    			last = cur;
    			ret++;
    		}
    		cur = Math.max(cur, i+A[i]);
    	}
    	return ret;
    }
}