public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int mid = binarySearch(A, 0, A.length-1, target);
        int[] result = {mid, mid};
        
        int end1 = mid-1, mid1 = -1;
        while ((mid1 = binarySearch(A, 0, end1, target)) != -1) {
            result[0] = mid1;
            end1 = mid1-1;
        }
        int begin2 = mid+1, mid2 = -1;
        while ((mid2 = binarySearch(A, begin2, A.length-1, target)) != -1) {
        	result[1] = mid2;
            begin2 = mid2+1;
        }
        return result;
    }
    
    int binarySearch(int[] A, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (A[mid] == target)
                return mid;
            if (A[mid] > target)
                end = mid-1;
            else if (A[mid] < target)
                start = mid+1;
        }
        return -1;
    }
}