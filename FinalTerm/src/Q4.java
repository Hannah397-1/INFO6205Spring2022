public class Q4 {
    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. According to the
     * definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as the lowest
     * node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //TODO: Write your code here
        if (root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (p == root || q == root) return root;
        if (left != null && right != null) return root;
        return left == null ? right : left;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

















