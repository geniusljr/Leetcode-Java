public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (S.length == 0)
            return results;
        results.add(new ArrayList<Integer>());
        for (int i = 0; i < (1 << S.length); i++) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int j = 0; j < 32; j++) {
                if (((i >> j) & 1) == 1)
                    result.add(S[j]);
            }
            results.add(result);
        }
        return results;
    }
}