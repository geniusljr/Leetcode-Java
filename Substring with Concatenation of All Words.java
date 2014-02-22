public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (S.length() == 0)
            return result;
            
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        for (String str : L) {
            expected.put(str, expected.containsKey(str) ? expected.get(str)+1 : 1);
        }
        
        int num = L.length, len = L[0].length();
        for (int i = 0; i < S.length() - num*len + 1; i++) {
            HashMap<String, Integer> appeared = new HashMap<String, Integer>(expected);
            int index = i;
            while (index <= i + (num-1)*len) {
                String str = S.substring(index, index+len);
                if (!appeared.containsKey(str) || appeared.get(str) == 0) break;
                appeared.put(str, appeared.get(str)-1);
                index += len;
            }
            if (index == i + num*len) {
                result.add(i);
            }
        }
        return result;
    }
}