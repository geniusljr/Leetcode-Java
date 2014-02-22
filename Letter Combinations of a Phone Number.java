public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> results = new ArrayList<String>();
        if (digits.length() == 0)
            results.add(new String(""));
        else results = getComb(digits, letters, 0);
        return results;          
    }
    
    public ArrayList<String> getComb(String digits, String[] letters, int index) {
        ArrayList<String> results = new ArrayList<String>();
        int num = digits.charAt(index) - '0';
        if (index == digits.length() - 1) {
            for (int i = 0; i < letters[num].length(); i++){
                results.add(String.valueOf(letters[num].charAt(i)));
            }
            return results;
        }
        ArrayList<String> nextLetterComb = getComb(digits, letters, index+1);
        for (int i = 0; i < letters[num].length(); i++) {
            String temp = String.valueOf(letters[num].charAt(i));
            for (int j = 0; j < nextLetterComb.size(); j++)
                results.add(temp+nextLetterComb.get(j));
        }
        return results;
    }
}