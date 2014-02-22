public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null || p == null)
            return false;
        int pid=0, sid=0;
        int star = -1, matchStar = -1;
        while (sid < s.length()) {
            if (pid < p.length() && (s.charAt(sid) == p.charAt(pid) || p.charAt(pid) == '?')) {
                sid++;
                pid++;
                continue;
            }
            if (pid < p.length() && p.charAt(pid) == '*') {
                star = pid++;
                matchStar = sid;
                continue;
            }
            if (star != -1) {
                pid = star+1;
                sid = ++matchStar;
                continue;
            }
            return false;
        }
        while (pid < p.length() && p.charAt(pid) == '*') {
            pid++;
        }
        return pid == p.length();
    }
}