public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> numList = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++)
            numList.add(num[i]);
        return permute(new ArrayList<Integer>(), numList);
    }
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> cur, ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num.size() == 0) {
            results.add(cur);
            return results;
        }
        for (int i = 0; i < num.size(); i++) {
            if (i > 0 && num.get(i) == num.get(i-1))
                continue;
            ArrayList<Integer> newCur = new ArrayList<Integer>(cur);
            newCur.add(num.get(i));
            ArrayList<Integer> newNum = new ArrayList<Integer>(num);
            newNum.remove(i);
            results.addAll(permute(newCur, newNum));
        }
        return results;
    }
}