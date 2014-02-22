public class Solution {
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        LinkedList<String> queue = new LinkedList<String>();
        for (int i = 0; i < path.length(); i++) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            if (i == path.length()) break;
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            String cur = path.substring(start, i);
            if (cur.equals("..")) {
                if (!queue.isEmpty())
                    queue.removeLast();
            }
            else if (!cur.equals("."))
                queue.add("/"+cur);
        }
        String result = "";
        while (!queue.isEmpty()) {
            result += queue.pop();
        }
        return result == "" ? "/" : result;
    }
}