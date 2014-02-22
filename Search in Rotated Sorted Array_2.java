public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0)
            return -1;
            
        int first = 0;
        int second = A.length-1;
        while (first <= second) {
            int mid = (first + second)/2;
            if (A[mid] == target)
                return mid;
            if (A[first] <= A[mid]) {
                if (A[first] <= target && target < A[mid])
                    second = mid-1;
                else
                    first = mid+1;
            }
            else {
                if (target > A[mid] && target < A[first])
                    first = mid+1;
                else second = mid-1;
            }
        }
        return -1;
    }
    
}