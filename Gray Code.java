public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n)); i++)
        	arrayList.add(i ^ (i >>> 1));
        return arrayList;
    }
}