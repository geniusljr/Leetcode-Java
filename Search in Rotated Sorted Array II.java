public class Solution {
    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A == null || A.length == 0)
            return false;
            
        int first = 0;
        int second = A.length-1;
        while (first <= second) {
            while (first != second && A[first] == A[second]) {
                second--;
            }
            int mid = (first + second)/2;
            if (A[mid] == target)
                return true;
            if (A[first] > A[mid]) {
                if (A[mid] < target && target <= A[second]) {
                    first = mid+1;
                } else second = mid-1;
            } 
            else if (A[first] < A[mid]) {
                if (A[first] <= target && target < A[mid]) {
                    second = mid-1;
                } else first = mid+1;
            } else {
                first = mid+1;
            }
        }
        return false;
    }
}