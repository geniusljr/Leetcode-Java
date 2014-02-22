public class Solution {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && dp.get(i).size() == 0) continue;
            for (String x : dict) {
                if (i + x.length() <= s.length() && x.equals(s.substring(i, i+x.length()))) {
                    dp.get(i+x.length()).add(i);
                }
            }
        }
        result = wordBreak(s, s.length(), dp);
        return result;
    }
    
    public static ArrayList<String> wordBreak(String s, int cur, ArrayList<ArrayList<Integer>> dp) {
        ArrayList<String> result = new ArrayList<String>();
        for (Integer x : dp.get(cur)) {
            if (x == 0) {
                result.add(s.substring(x, cur));
            }
            ArrayList<String> pre = wordBreak(s, x, dp);
            for (String str : pre) {
                result.add(str + " " + s.substring(x, cur));
            }
        }
        return result;
    }
}