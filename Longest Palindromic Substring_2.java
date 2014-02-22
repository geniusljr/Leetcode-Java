public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] flag = new boolean[s.length()][s.length()];
        int maxi = 0, maxj = -1;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length()-j; i++) {
                flag[i][i+j] = s.charAt(i)==s.charAt(i+j) && (j>=2?flag[i+1][i+j-1]:true);
                if (j != maxj && flag[i][i+j]) {
                    maxi = i;
                    maxj = j;
                }
            }
        }
        return s.substring(maxi, maxi+maxj+1);
    }
}