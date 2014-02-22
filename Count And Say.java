public class Solution {
    public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String start = "1";
        while (--n != 0) {
            String temp = "";
            char pre = start.charAt(0);
            int count = 1;
            for (int i = 1; i < start.length(); i++) {
                if (start.charAt(i) == pre) count++;
                else {
                    temp += count + "" + pre;
                    count = 1;
                    pre = start.charAt(i);
                }
            }
            temp += count + "" + pre;
            start = temp;
        }
        return start;
    }
}