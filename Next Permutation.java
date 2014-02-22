public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = num.length - 2;
        while (index >= 0 && num[index] >= num[index+1]) {
            index--;
        }
        reverse(num, index+1, num.length-1);
        if (index != -1) {
            int i = index;
            while(num[++i] <= num[index]);
            swap(num, index, i);
        }
        return; 
    }
    
    public void reverse(int[] num, int first, int second) {
        while (first < second)
            swap(num, first++, second--);
        return;
    }
    
    public void swap(int[] num, int first, int second) {
        if (first >= num.length || second >= num.length || first < 0 || second < 0)
            return;
        num[first] ^= num[second];
        num[second] ^= num[first];
        num[first] ^= num[second];
    }
}