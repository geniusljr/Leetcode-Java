public class Solution {
    public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (ratings.length == 0)
            return 0;
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        int sum = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                num[i] = num[i-1]+1;
            }
        }
        sum += num[ratings.length-1];
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                num[i] = num[i] < num[i+1]+1 ? num[i+1]+1 : num[i];
            }
            sum += num[i];
        }
        
        return sum;
    }
}