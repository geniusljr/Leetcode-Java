public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = recurGen(n, n);
        return results;
    }
    
    public ArrayList<String> recurGen(int left, int right) {
        ArrayList<String> results = new ArrayList<String>();
        if (left == 0) {
            String result = new String("");
            for (int i = 0; i < right; i++) {
                result += ")";
            }
            results.add(result);
            return results;
        }
        ArrayList<String> tempR = recurGen(left-1, right);
        for (int i = 0; i < tempR.size(); i++) {
            String str = "(" + tempR.get(i);
            results.add(str);
        }
        if (left != right) {
            tempR = recurGen(left, right-1);
            for (int i = 0; i < tempR.size(); i++) {
                String str = ")" + tempR.get(i);
                results.add(str);
            }
        }
        return results;
    }
}