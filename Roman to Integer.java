public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int idx = 0;
        int result = 0;
        while (s.length() > 0) {
            if (s.startsWith(romans[idx])) {
                result += nums[idx];
                s = s.substring(romans[idx].length());
            }
            else
                idx++;
        }
        return result;
    }
}