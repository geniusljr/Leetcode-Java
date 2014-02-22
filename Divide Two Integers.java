public class Solution {
         public static int divide(int dividend, int divisor) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (divisor == 0)
		    return 0;
		long longDividend = Math.abs((long)dividend);
		long longDivisor = Math.abs((long)divisor);
		String strDividend = String.valueOf(longDividend);
		String strDivisor = String.valueOf(longDivisor);
		if (strDividend.length() < strDivisor.length())
			return 0;
		
		long result = 0;
		int end = strDivisor.length();
		long tempDividend = end == 1 ? 0 : Integer.parseInt(strDividend.substring(0, end-1));
		while (end <= strDividend.length()) {
		    result *= 10;
		    tempDividend = Integer.parseInt(strDividend.substring(end-1, end))+tempDividend*10;
		    while (tempDividend >= longDivisor) {
		        tempDividend -= longDivisor;
		        result++;
		    }
		    end++;
		}
		
		return (((dividend ^ divisor) >>> 31) == 1) ? (int)-result : (int)result  ;
	}
}