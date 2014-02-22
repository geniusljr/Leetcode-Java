public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length-2 && num[i] <= 0; i++) {
            if (i != 0 && num[i] == num[i-1])
                continue;
            int j = i+1, k = num.length-1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum > 0 || (k != num.length-1 && num[k] == num[k+1])) {
                    k--;
                } 
                else if (sum < 0 || (j != i+1 && num[j] == num[j-1])) {
                    j++;
                }
                else if (sum == 0) {
                    results.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j++], num[k--])));
                }
            }
        }
        return results;
    }
}