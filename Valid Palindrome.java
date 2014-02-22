public class Solution {
    public boolean isPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	for (int begin = getNext(s, 0, 1), end = getNext(s, s.length()-1, -1); begin < end;) {
    	    if (Character.toLowerCase(s.charAt(begin)) != Character.toLowerCase(s.charAt(end)))
                return false;
            begin = getNext(s, ++begin, 1);
    		end = getNext(s, --end, -1);
        }
        return true;
    }
    int getNext(String s, int pos, int delta) {
        while (pos < s.length() && pos >= 0 && !Character.isLetterOrDigit(s.charAt(pos))) {
            pos += delta;
        }
        return pos;
    }
}