public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int carry = 0;
        int[] result = new int[digits.length+1];
        for (int i = digits.length-1; i >= 0; i--) {
            result[i+1] = digits[i] + carry + (i == digits.length-1 ? 1 : 0);
            carry = result[i+1] >= 10 ? 1 : 0;
            result[i+1] = result[i+1] - (result[i+1] >= 10 ? 10 : 0);
        }
        if (carry == 0) {
            int[] newResult = Arrays.copyOfRange(result, 1, result.length);
            return newResult;
        }
        else result[0] = 1;
        return result;
    }
}