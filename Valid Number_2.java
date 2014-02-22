public class Solution {
    public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index = 0;
        int state = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c == ' ') {
                if (state == 0)
                    continue;
                if (state == 2 || state == 4 || state == 6 || state == 8)
                    state = 8;
                else return false;
            }
            else if (c == '+' || c == '-') {
                if (state == 0)
                    state = 1;
                else if (state  == 5)
                    state = 7;
                else return false;
            }
            else if (c == '.') {
                if (state == 0 || state == 1)
                    state = 3;
                else if (state == 2)
                    state = 4;
                else return false;
            }
            else if (c == 'e' || c == 'E') {
                if (state == 2 || state == 4)
                    state = 5;
                else return false;
            }
            else if (Character.isDigit(c)) {
                if (state == 0 || state == 1 || state ==2)
                    state = 2;
                else if (state == 5 || state == 6 || state == 7)
                    state = 6;
                else if (state == 3 || state == 4)
                    state = 4;
                else return false;
            }
            else return false;
        }
        return state == 2 || state == 4 || state == 6 || state == 8;
    }
}