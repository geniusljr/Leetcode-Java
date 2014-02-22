public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int result = Integer.MAX_VALUE;
        
        Arrays.sort(num);

        for (int i = 0; i < num.length-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            int start = i+1;
            int end = num.length-1;
            while (start < end) {
                int curSum = num[start] + num[end] + num[i];
                if (curSum > target) {
                    end--;
                }
                else if (curSum < target) {
                    start++;
                }
                else {
                    return target;
                }
                int compTarget = result == Integer.MAX_VALUE ? result : result-target;
                if (Math.abs(curSum - target) < Math.abs(compTarget))
                    result = curSum;
            }
        }
        return result;
    }
}