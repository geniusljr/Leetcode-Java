public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        int total = 1;
        for (int i = 0; i < n; i++) {
        	num[i] = i+1;
        	total *= num[i];
        }
        k--; // this is very important
        String result = "";
        for (int i = 0; i < n; i++) {
        	total /= n-i;
        	int cur = k / total;
        	result += (char)(num[cur] + '0');
        	for (int j = cur; j < n-i-1; j++)
        		num[j] = num[j+1];
        	k %= total;
        }
        return result;
    }
}