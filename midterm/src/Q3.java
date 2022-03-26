import java.util.HashMap;

public class Q3 {
    public static TreeNode constructTree(int[] preorder, int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length,inorder,0,inorder.length, map);
    }
    public static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){
        if(preStart == preEnd){
            return null;
        }
        // find root_val and find its index in inorder[]
        int root_val = preorder[preStart];

        TreeNode root = new TreeNode(root_val);
        int root_index = map.get(root_val);
        int leftSize = root_index - inStart;// 1
        root.left = helper(preorder,preStart+1,preStart + 1 + leftSize, inorder, inStart, root_index, map);
        root.right = helper(preorder,preStart + 1 + leftSize,preEnd, inorder, root_index + 1, inEnd, map);
        return root;
    }


//// Test --------------------------------------
//    public static void main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
//        constructTree(preorder,inorder);
//
//    }
//
//}
static class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
}


