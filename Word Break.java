public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean[] word = new boolean[s.length()+1];
        for (int i = 0; i <= s.length(); i++)
            word[i] = false;
        word[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dict.contains(s.substring(j, i)) && word[j]) {
                    word[i] = true;
                    break;
                }
            }
        }
        return word[s.length()];
    }
}