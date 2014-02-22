public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        generateParenthesis(result, "", n, n);
        return result;
    }
    
    public void generateParenthesis(ArrayList<String> result, String prefix, int left, int right) {
        if (left == 0) {
            for (int i = 0; i < right; i++) {
                prefix += ')';
            }
            result.add(prefix);
            return;
        }
        generateParenthesis(result, prefix+"(", left-1, right);
        if (left < right)
            generateParenthesis(result, prefix+")", left, right-1);
    }
}