public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        combine(candidates, 0, target, results, cur);
        return results;
    }
    
    public void combine(int[] candidates, int index, int target, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> cur) {
        if (target < 0) return;
        if (target == 0) {
            results.add(cur);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combine(candidates, i, target-candidates[i], results, new ArrayList<Integer>(cur));
            cur.remove(cur.size()-1);
        }
        return;
    }
}