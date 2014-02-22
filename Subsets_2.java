public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        results.add(cur);
        generate(results, cur, S, 0);
        return results;
    }
    
    public void generate(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> cur, int[] S, int pos) {
        for (int i = pos; i < S.length; i++) {
            cur.add(S[i]);
            results.add(new ArrayList<Integer>(cur));
            generate(results, cur, S, i+1);
            cur.remove(cur.size()-1);
        }
    }
}