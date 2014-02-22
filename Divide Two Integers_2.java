public class Solution {
         public static int divide(int dividend, int divisor) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (divisor == 0)
		    return 0;
		long longDividend = Math.abs((long)dividend);
		long longDivisor = Math.abs((long)divisor);
		
        long result = 0;
        
        while (longDividend >= longDivisor) {
            long temp = longDivisor;
            for (int i = 0; longDividend >= temp; i++, temp <<= 1) {
                longDividend -= temp;
                result += 1<<i;
            }
        }
		
		return (((dividend ^ divisor) >>> 31) == 1) ? (int)-result : (int)result  ;
	}
}