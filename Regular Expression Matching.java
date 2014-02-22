public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || p == null) return false;
        if (p.length() == 0) 
            return s.length() == 0;   
        return recurMatch(s, p, 0, 0);
    }
    
    public boolean recurMatch(String s, String p, int idx1, int idx2) {
        if (idx2 == p.length()) 
            return idx1 == s.length();
        if (idx2 == p.length()-1 || p.charAt(idx2+1) != '*') {
            if (idx1 == s.length()) return false;
            if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.')
                return isMatch(s.substring(idx1+1), p.substring(idx2+1));
            else return false;
        }
        else {
            while (idx1 < s.length() && (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.')) {
                if (recurMatch(s, p, idx1, idx2+2)) return true;
                idx1++;
            }
            return recurMatch(s, p, idx1, idx2+2);
        }
    }
}



