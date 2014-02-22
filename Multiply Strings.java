public class Solution {
	public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        char[] charNum1 = num1.toCharArray();
        char[] charNum2 = num2.toCharArray();
        char[] result = new char[num1.length()+num2.length()];
        for (int i = 0; i < result.length; i++)
        	result[i] = '0';
        for (int j = 0; j < charNum2.length; j++) {
            int num2_j = charNum2[j]-'0';
            int s = 0;
            for (int i = 0; i < charNum1.length; i++) {
                 int num1_i = charNum1[i]-'0';
                 int temp = num1_i * num2_j + result[i+j]-'0';
                 s = temp / 10;
                 num1_i = temp % 10;
                 
                 result[i+j] = (char)(num1_i + '0');
                 result[i+j+1] += s;
            }
        }
        String strResult = String.valueOf(result);
        int index = strResult.length()-1;
        while (index >=0 && strResult.charAt(index) == '0') {
        	index--;
        }
        if (index == -1) return "0";
        return new StringBuilder(strResult.substring(0, index+1)).reverse().toString(); 
    }
}