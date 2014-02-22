public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length-3; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            for (int j = i+1; j < num.length-2; j++) {
                if (j > i+1 && num[j] == num[j-1]) continue;
                int k = j+1;
                int p = num.length-1;
                target = target - num[i] - num[j]; 
                while (k < p) {
                    if ((k != j+1 && num[k] == num[k-1]) || (num[k] + num[p] < target)) {
                        k++;
                    }
                    else if ((p != num.length-1 && num[p] == num[p+1]) || (num[k] + num[p] > target)) {
                        p--;
                    }
                    else if (num[k] + num[p] == target) {
                        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k++], num[p--]));
                        results.add(result);
                    }
                }
                target += num[i] + num[j];
            }
        }
        return results;  
    }
}