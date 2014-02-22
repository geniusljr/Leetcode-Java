/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return results;
        if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> oneResult = new ArrayList<Integer>();
            oneResult.add(root.val);
            results.add(oneResult);
            return results;
        }
        ArrayList<ArrayList<Integer>> leftResults = pathSum(root.left, sum-root.val);
        ArrayList<ArrayList<Integer>> rightResults = pathSum(root.right, sum-root.val);
        if (!leftResults.isEmpty()) {
            for (ArrayList<Integer> array : leftResults)
                array.add(0, root.val);
        }
        if (!rightResults.isEmpty()) {
            for (ArrayList<Integer> array : rightResults)
                array.add(0, root.val);
        }
        leftResults.addAll(rightResults);
        return leftResults;
    }
}