public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0)
            return 0;
        int result = 0;
        Stack<Integer> bar = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                bar.push(A[i-1]);
                index.push(i-1);
            } else if (A[i] > A[i-1]) {
                int low = A[i-1];
                while (!bar.isEmpty() && bar.peek() <= A[i]) {
                    result += (bar.peek() - low) * (i - index.pop() - 1);
                    low = bar.pop();
                }
                if (!bar.isEmpty() && bar.peek() > A[i]) {
                    result += (A[i] - low) * (i - index.peek() - 1);
                }
            }
        }
        
        return result;
    }
}