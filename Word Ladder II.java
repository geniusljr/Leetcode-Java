public class Solution {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<String>> preSet = new HashMap<String, ArrayList<String>>();
        dict.remove(start);
        dict.remove(end);
        LinkedList<String> queue1 = new LinkedList<String>();
        queue1.add(start);
        while (!queue1.isEmpty()) {
            LinkedList<String> queue2 = new LinkedList<String>();
            boolean finished = false;
            while (!queue1.isEmpty()) {
                String top = queue1.pop();
                for (int i = 0; i < top.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (top.charAt(i) == c)
                            continue;
                        char[] charTop = top.toCharArray();
                        charTop[i] = c;
                        String newTop = new String(charTop);
                        if (newTop.equals(end)) {
                            finished = true;
                            ArrayList<ArrayList<String>> oneResult = getAllPath(top, preSet, start);
                            for (ArrayList<String> list : oneResult) {
                                list.add(newTop);
                            }
                            results.addAll(oneResult);
                            
                        }
                        if (dict.contains(newTop)) {
                            if (!queue2.contains(newTop))
                            	queue2.add(newTop);
                            if (preSet.containsKey(newTop)) {
                                preSet.get(newTop).add(top);
                            } else {
                                preSet.put(newTop, new ArrayList<String>(Arrays.asList(top)));
                            }
                        }
                    }
                }   
            }
            if (finished) {
                return results;
            }
            dict.removeAll(queue2);
            queue1 = queue2;
        }
        return results;
    }
    
    public static ArrayList<ArrayList<String>> getAllPath(String str, HashMap<String, ArrayList<String>> preSet, String begin) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if (preSet.get(str) == null) {
        	ArrayList<String> result = new ArrayList<String>(Arrays.asList(str));
        	results.add(result);
        	return results;
        }
        for (String pre : preSet.get(str)) {
            ArrayList<ArrayList<String>> result = getAllPath(pre, preSet, begin);
            for (ArrayList<String> list : result) {
                list.add(str);
                results.add(list);
            }
        }
        return results;
    }
}