public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) 
            return 0;
        Arrays.sort(A);
        int first = 0;
        int second = A.length-1;
        int mid = (first+second)/2;
        while (first <= second) {
            if (A[mid] > elem) 
                second = mid-1;
            else if (A[mid] < elem) 
                first = mid+1;
            else break;
            mid = (first+second)/2;
        }
        if (first > second)
            return A.length;
        int num = 0;
        int i = 0;
        for (i = mid; i < A.length; i++)
            if (A[i] == elem) num++;
            else break;
        for (i = mid; i >= 0; i--)
            if (A[i] == elem) num++;
            else break;
        for (int j = i+1; j < A.length-num+1; j++)
            A[j] = A[j+num-1];
        return A.length-num+1;
        
    }
}