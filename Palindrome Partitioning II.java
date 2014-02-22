public class Solution {
    public int minCut(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j+i < len; j++)
                p[j][j+i] = (s.charAt(j) == s.charAt (j+i)) && (i >= 2 ? p[j+1][j+i-1] : true);
        
        int[] minCut = new int[len];
        minCut[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)  {
                    minCut[i] = p[j][i] ? 0 : i;
                } else {
                    minCut[i] = p[j][i] ? Math.min(minCut[i], minCut[j-1]+1) : minCut[i];
                }
            }
        }
        return minCut[len-1];
    }
}