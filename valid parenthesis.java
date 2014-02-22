public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> stack = new Stack<String>();
        stack.add("0");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(String.valueOf(s.charAt(i)));
            }
            else {
                String top = stack.pop();
                if (s.charAt(i) == ')' && !top.equals("("))
                    return false;
                else if (s.charAt(i) == ']' && !top.equals("["))
                    return false;
                else if (s.charAt(i) == '}' && !top.equals("{"))
                    return false;
            }
        }
        if (!stack.pop().equals("0"))
            return false;
        return true;
    }
}