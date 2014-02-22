public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; i++) {
            int[] aRow = new int[i+1];
            aRow[0] = aRow[i] = 1;
            for (int j = 1; j < i; j++) {
                aRow[j] = results.get(i-1).get(j-1) + results.get(i-1).get(j); 
            }
            ArrayList<Integer> oneResult = new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++)
                oneResult.add(aRow[j]);
            results.add(oneResult);
        }
        return results;
    }
}