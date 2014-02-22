public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] isInter = new boolean[s1.length()+1][s2.length()+1];
        isInter[0][0] = true;
        for (int i = 1; i < s2.length()+1; i++)
            isInter[0][i] = s3.charAt(i-1) == s2.charAt(i-1) && isInter[0][i-1];
        for (int i = 1; i < s1.length()+1; i++)
            isInter[i][0] = s3.charAt(i-1) == s1.charAt(i-1) && isInter[i-1][0];
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                isInter[i][j] = (isInter[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) || (isInter[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        }
        return isInter[s1.length()][s2.length()];
    }
}