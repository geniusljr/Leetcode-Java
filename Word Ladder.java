public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int distance = 1;
        LinkedList<String> queue1 = new LinkedList<String>();
        queue1.add(start);
        while (!dict.isEmpty() && !queue1.isEmpty()) {
            LinkedList<String> queue2 = new LinkedList<String>();
            while (!queue1.isEmpty()) {
                String top = queue1.pop();
                for (int i = 0; i < top.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (top.charAt(i) == c)
                            continue;
                        char[] charTop = top.toCharArray();
                        charTop[i] = c;
                        String newTop = new String(charTop);
                        if (newTop.equals(end))
                            return distance+1;
                        if (dict.contains(newTop)) {
                            dict.remove(newTop);
                            queue2.add(newTop);
                        }
                    }
                }   
            }
            queue1 = queue2;
            distance++;
        }
        return 0;
    }
}