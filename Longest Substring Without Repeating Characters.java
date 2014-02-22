public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> chars = new HashSet<String>();
            int j = i;
            while (j < s.length() && !chars.contains(s.substring(j,j+1))) {
                chars.add(s.substring(j,j+1));
                j++;
            }
            int cur = j-i;
            if (cur > max)
                max = cur;
        }
        return max;
    }
}
