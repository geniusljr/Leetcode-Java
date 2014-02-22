public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int first = 0;
        int second = A.length-1;
        int mid = 0;
        while (first <= second) {
            mid = (first + second) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] > target)
                second = mid-1;
            else if (A[mid] < target)
                first = mid+1;
        }
        return first;
    }
}