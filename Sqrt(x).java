public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (x <= 0)
            return 0;
        int begin = 1, end = x, mid = end/2;
        while (begin <= end) {
            if (mid > 46340 || power(mid) > x)
                end = mid-1;
            else if (power(mid+1) <= x)
                begin = mid+1;
            else if (power(mid) <= x && power(mid+1) > x)
                return mid;
            mid = (begin + end)/2;
        }
        return mid;
    }
    
    public int power(int x) {
        return x*x;
    }
}