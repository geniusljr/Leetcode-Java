public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (triangle.size() == 0)
            return 0;
        ArrayList<Integer> minimum = triangle.get(triangle.size()-1);
        int n = minimum.size();
        while (n-- > 1) {
            for (int i = 0; i < n; i++) {
                minimum.set(i, triangle.get(n-1).get(i) + Math.min(minimum.get(i), minimum.get(i+1)));
            }
        }
        return minimum.get(0);
    }
}