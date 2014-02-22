public class Solution {
    public int jump(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length <= 1)
            return 0;
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        queue1.add(0);
        int step = 0;
        int max = 0;
        while (!queue1.isEmpty()) {
            LinkedList<Integer> queue2 = new LinkedList<Integer>();
            while (!queue1.isEmpty()) {
                int top = queue1.pop();
                if (top+A[top] >= A.length-1)
                    return step+1;
                for (int i = max+1; i <= top + A[top]; i++) {
                    if (A[i] == 0) continue;
                    queue2.add(i);
                }
                max = top+A[top] > max ? top+A[top] : max;
            }
            queue1 = queue2;
            step++;
        }
        return 0;
    }
}