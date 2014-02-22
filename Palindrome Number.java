public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return false;
        int y = 1;
        while (x / y >= 10) {
            y *= 10;
        }
        while (x > 0) {
            int z = x % 10;
            if (y == 1)
                return x == z;
            else {
                if (z == 0 || x/y != z) return false;
                x = x - z - z*y;
                if (x == 0) return true;
                while (x % 10 == 0) {
                    x /= 10;
                    y /= 100;
                }
            }
        }
        return true;
        
    }
}