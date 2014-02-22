public class Solution {
    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return s.charAt(0) == '0' ? 0 : 1;
        int result = 0;
        int[] count = new int[s.length()];
        count[0] = isValid(s, 0);
        count[1] = isValid(s, 0) * isValid(s,1) + isValidTwo(s, 1);
        for (int i = 2; i < s.length(); i++) {
            count[i] = count[i-2] * isValidTwo(s, i) + count[i-1] * isValid(s, i);
            if (count[i] == 0)
                return 0;
        }
        return count[s.length()-1];
    }
    
    int isValidTwo(String s, int bit) {
        char pre = s.charAt(bit-1), cur = s.charAt(bit);
        return (pre == '1' || pre == '2' && cur >= '0' && cur <= '6') ? 1 : 0;
    }
    
    int isValid(String s, int bit) {
        return s.charAt(bit) == '0' ? 0 : 1;
    }
}