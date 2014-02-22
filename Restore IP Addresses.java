public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return restoreIP(s, 4);
    }
    
    public ArrayList<String> restoreIP(String s, int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 1) {
            if (valid(s)) {
                result.add(s);
            }
            return result;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (valid(prefix)) {
                ArrayList<String> next = restoreIP(s.substring(i), n-1);
                if (next != null && next.size() > 0) {
                    for (String x : next)
                        result.add(new String(prefix+"."+x));
                }
            }
        }
        return result;
    }
    
    public boolean valid(String s) {
        if (s.length() == 0 || s.length() >= 4 || (s.charAt(0) == '0' && s.length() > 1))
            return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}