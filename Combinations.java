public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = combine(1, n, k);
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> combine(int start, int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (k == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        for (int i = start; i <= n-k+1; i++) {
            ArrayList<ArrayList<Integer>> tempResults = combine(i+1, n, k-1);
            for (ArrayList<Integer> tempResult : tempResults) {
                tempResult.add(0, i);
            }
            results.addAll(tempResults);
        }
        return results;
    }
}