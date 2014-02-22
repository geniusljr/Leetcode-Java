public class Solution {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n < 0)
            return 1.0/power(x, -n);
        return power(x, n);
    }
    public double power(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double halfResult = pow(x, n/2);
        return halfResult * halfResult * (n % 2 == 1 ? x : 1);
    }
}