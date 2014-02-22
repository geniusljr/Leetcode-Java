public class Solution {
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s1.length() != s2.length())
            return false;
        int[] num = new int[26];
        for (int i = 0; i < 26; i++)
            num[i] = 0;
        for (int i = 0; i < s1.length(); i++) {
            num[s1.charAt(i)-'a']++;
            num[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (num[i] != 0)
                return false;
        }
        if (s1.length() == 1) return true;
        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()))) || (isScramble(s1.substring(0, i), s2.substring(s2.length()-i, s2.length())) && isScramble(s1.substring(i, s1.length()), s2.substring(0, s1.length()-i))))
                return true;
        }
        return false;
    }
}