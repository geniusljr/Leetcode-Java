public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if (s == null)
            return results;
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalin(sub)) {
                if (i == s.length()) {
                    ArrayList<String> result = new ArrayList<String>();
                    result.add(sub);
                    results.add(result);
                } else {
                    for (ArrayList<String> list : partition(s.substring(i))) {
                        ArrayList<String> result = new ArrayList<String>(list);
                        result.add(0, sub);
                        results.add(result);
                    }
                }
            }
        }
        return results;
    }
    
    public boolean isPalin(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}