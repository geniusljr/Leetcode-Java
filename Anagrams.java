public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String newStr = new String(strArr);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                ArrayList<String> arrList = new ArrayList<String>();
                arrList.add(str);
                map.put(newStr, arrList);
            }
        }
        ArrayList<String> results = new ArrayList<String>();
        for (String str : map.keySet()) {
            if (map.get(str).size() > 1)
                results.addAll(map.get(str));
        }
        return results;
    }
}