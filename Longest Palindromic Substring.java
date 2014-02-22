public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0) return "";
        for (int len = s.length(); len > 0; len--) {
            for (int i = 0; i < s.length()-len+1; i++) {
                String str = s.substring(i, i+len);
                if (isPalindrome(str))
                    return str;
            }
        }
        return "";
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()-1-i; i++)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}