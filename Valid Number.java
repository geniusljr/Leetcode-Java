public class Solution {
    public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int index = 0;
        int state = 0;
        boolean oneDot = false;
        boolean oneE = false;
        boolean oneSign = false;
        boolean haveNum = false;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if ( (c == '.' && oneDot) || ((c == '+' || c == '-') && oneSign) || ((c == 'e' || c == 'E') && oneE) )
                return false;
            if (state == 0) {
                if (c == ' ')
                    continue;
                if (c == '+' || c == '-')
                    state = 1;
                else if (Character.isDigit(c))
                    state = 2;
                else if (c == '.') {
                    state = 3;
                    oneDot = true;
                }
                else return false;
            } else if (state == 1) {
                if (Character.isDigit(c))
                    state = 2;
                else if (c == '.') {
                    state = 3;
                    oneDot = true;
                } 
                else return false;
            } else if (state == 2) {
                if (Character.isDigit(c))
                    continue;
                else if (c == 'e' || c == 'E') {
                    state = 4;
                    oneE = true;
                    oneDot = true;
                } else if (c == '.') {
                    state = 3;
                    oneDot = true;
                } else if (c == ' ')
                    state = 5;
                else return false;
            } else if (state == 3) {
                if (Character.isDigit(c))
                    state = 2;
                else if (c == ' ')
                    state = 5;
                else if (haveNum && (c == 'e' || c == 'E')) {
                    state = 4;
                    oneE = true;
                    oneDot = true;
                } 
                else return false;
            } else if (state == 4) {
                if (Character.isDigit(c))
                    state = 2;
                else if (c == '+' || c == '-') {
                    state = 1;
                    oneSign = true;
                }
                else return false;
            } else if (state == 5) {
                if (c != ' ')
                    return false;
            }
            if (state == 2)
                haveNum = true;
        }
        return haveNum && (state == 2 || state == 5 || state == 3);
    }
}