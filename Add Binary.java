public class Solution {
    public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String result = "";
        int idxA = a.length()-1, idxB = b.length()-1;
        int carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry == 1) {
            int valA = idxA >= 0 ? a.charAt(idxA)-'0' : 0;
            int valB = idxB >= 0 ? b.charAt(idxB)-'0' : 0;
            result += (char)('0' + (valA ^ valB ^ carry));
            carry = (valA & valB) | (valA & carry) | (valB & carry);
            idxA--; idxB--;
        }
        return new StringBuilder(result).reverse().toString();
        
    }
}