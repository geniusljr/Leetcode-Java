    public static boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while (!queue1.isEmpty()) {
                TreeNode cur = queue1.poll();
                if (cur != null) {
                    queue2.add(cur.left);
                    queue2.add(cur.right);
                }
            }
            int[] num = new int[queue2.size()];
            int idx = 0;
            while (!queue2.isEmpty()) {
                TreeNode temp = queue2.poll();
                num[idx++] = temp == null ? 0 : temp.val;
                queue1.add(temp);
            }
            if (!isSym(num))
                return false;
        }
        return true;
    }
    
    public static boolean isSym(int[] num) {
        int idx = 0;
        while (idx < num.length - idx - 1) {
            if (num[idx] != num[num.length-idx-1])
                return false;
            idx++;
        }
        return true;
    }