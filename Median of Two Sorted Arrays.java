class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        int median_position = (A.length + B.length)/2+1;
 
        int[] result = new int[A.length+B.length];
        while (indexA < A.length && indexB < B.length && index < median_position) {
            if (A[indexA] < B[indexB])
                result[index++] = A[indexA++];
            else
                result[index++] = B[indexB++];
        }
        while (indexA == A.length && index < median_position)
            result[index++] = B[indexB++];
        while (indexB == B.length && index < median_position)
            result[index++] = A[indexA++];
        
        if (((A.length + B.length) & 1) == 1)
            return result[index-1];
        else
            return (double)(result[index-1]+result[index-2])/2;
        
    }
}
