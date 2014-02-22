public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x *= -1;
        }
        while (x > 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return positive ? result : (-1*result);
    }
}