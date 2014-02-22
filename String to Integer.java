public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str == null || str.length() == 0) return 0;
        int sign = 1;
        int idx = 0;
        
        while (str.charAt(idx) == ' ') {
            idx++;
        }
        if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        else if (str.charAt(idx) == '+') {
            idx++;
        }

        //return idx;
        int result = 0;
        while (idx < str.length()) {
            int num = str.charAt(idx) - '0';
            if (num > 9 || num < 0)
                return result*sign;
            if ((double)result * 10 + (double)num > (double)Integer.MAX_VALUE && sign == 1)
                return Integer.MAX_VALUE;
            else if ((double)result * 10 + (double)num > (double)Integer.MAX_VALUE+1 && sign == -1)
                return Integer.MIN_VALUE;
            result = result*10 + num;
            idx++;
        }
        return result*sign;
    }
}