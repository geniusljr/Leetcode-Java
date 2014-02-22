public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (x <= 0)
            return 0;
        int begin = 1, end = x, mid = end/2;
        if (x <= 2)
            return 1;
        while (begin <= end) {
            if (x / mid >= mid && x/(mid+1) < mid+1)
                return mid;
            if (x / mid < mid)
                end = mid-1;
            else begin = mid+1;
            mid = (begin + end)/2;
        }
        return begin;
    }
}