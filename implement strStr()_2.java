public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen)
            return null;
        if (nLen == 0)
            return haystack;
        int[] next = findNextOptimized(needle);
        int i=0, j=0;
        while (i < nLen && j < hLen) {
            if (i == -1 || haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
            }
            else i = next[i];
        }
        if (i >= nLen)
            return haystack.substring(j-nLen);
        else return null;
    }
    
    public int[] findNext(String str) {
    	int[] next = new int[str.length()];
		next[0] = -1;
		for (int i = 1; i < next.length; i++) {
			int k = next[i - 1];
			while (k > 0 && str.charAt(i - 1) != str.charAt(k)) {
				k = next[k];
			}
			if (k == 0 && str.charAt(i - 1) != str.charAt(k))
				next[i] = 0;
			else
				next[i] = k + 1;
		}
		return next;
	}

	public int[] findNextOptimized(String str) {
		int[] next = findNext(str);
		for (int i = 1; i < next.length; i++) {
			while (next[i] != -1 && str.charAt(i) == str.charAt(next[i])) {
				next[i] = next[next[i]];
			}
		}
		return next;
	}
}