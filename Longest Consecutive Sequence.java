public class Solution {
    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++)
            set.add(num[i]);
        int maxL = 0;
        for (Integer x : num) {
            int temp = x, count = 1;
            while (set.contains(temp+1)) {
                set.remove(temp++);
                count++;
            }
            temp = x;
            while (set.contains(temp-1)) {
                set.remove(temp--);
                count++;
            }
            maxL = Math.max(maxL, count);
        }
        return maxL;
    }
}