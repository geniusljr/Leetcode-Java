public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = recurGen("", n, n);
        return results;
    }
    
    public ArrayList<String> recurGen(String prefix, int left, int right) {
        ArrayList<String> results = new ArrayList<String>();
        if (left == 0) {
            for (int i = 0; i < right; i++) {
                prefix += ")";
            }
            results.add(prefix);
            return results;
        }
        results.addAll(recurGen(prefix+"(", left-1, right));
        if (left < right)
            results.addAll(recurGen(prefix+")", left, right-1));
        return results;
    }
}