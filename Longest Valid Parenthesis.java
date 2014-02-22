public class Solution {
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, last = -1;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                stack.push(index);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(max, index-last) : Math.max(max, index-stack.peek());
                } else {
                    last = index;
                }
            }
            index++;
        }
        return max;
    }
}   