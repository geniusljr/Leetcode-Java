public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (nRows == 1)
            return s;
        String result = new String();
        int interval = 2*nRows-2;
        for (int i = 0; i < nRows; i++) {
         		if (i ==0 || i == nRows - 1) {
      			int idx = i;
          			while (idx < s.length()) {
                    result += s.charAt(idx);
                    idx += interval;
                }
    		    }
        		else {
                int idx1 = -i;
                int idx2 = +i;
                while (idx1 < s.length()) {
                    if (idx1 > 0)
                          result += s.charAt(idx1);
                    if (idx2 < s.length())
                        	result += s.charAt(idx2);
                  	idx1 += interval;
                  	idx2 += interval;
                }
        		}
        }
        return result;
    }
}
