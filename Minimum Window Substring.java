public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] appeared = new int[256];
        int[] expected = new int[256];
        for (int i = 0; i < 256; i++) {
            appeared[i] = 0;
            expected[i] = 0;
        }
        for (int i = 0; i < T.length(); i++) {
            expected[(int)T.charAt(i)]++;
        }
        int minW = Integer.MAX_VALUE, minStart = 0, left = 0, right = 0, count = 0;
        for (right = 0; right < S.length(); right++) {
            int ch = (int)S.charAt(right);
            if (expected[ch] == 0) continue;
            appeared[ch]++;
            if (appeared[ch] <= expected[ch])
                count++;
            if (count == T.length()) {
                while (expected[(int)S.charAt(left)] == 0 || appeared[(int)S.charAt(left)] > expected[(int)S.charAt(left)]) {
                    appeared[(int)S.charAt(left)]--;
                    left++;
                }
                if (minW > right - left + 1) {
                    minW = right - left + 1;
                    minStart = left;
                }
            }
        }
        return minW == Integer.MAX_VALUE ? "" : S.substring(minStart, minStart + minW);
    }
}