public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return 0;
        int index = s.length()-1;
        while (index >= 0 && s.charAt(index) == ' ')
            index--;
        s = s.substring(0, index+1);
        int last = s.lastIndexOf(' ');
        return last == -1 ? s.length() : s.length()-last-1;
    }
}