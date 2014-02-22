import java.math.BigInteger;
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i < rowIndex+1; i++) {
            result.add(BigInteger.valueOf(result.get(i-1)).multiply(BigInteger.valueOf(rowIndex+1-i)).divide(BigInteger.valueOf(i)).intValue());
        }
        return result;
    }
}