package com.neu;

import java.util.*;

public class Assignment06 {

    // 437. Path Sum III
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathNum(root,targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    public int pathNum(TreeNode root, int sum){
        if(root == null) return 0;
        int newSum = sum - root.val;
        int res = 0;
        if(newSum == 0){
            res = 1;
        }
        return res + pathNum(root.left,newSum) + pathNum(root.right,newSum);
    }

    // 236. Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    // 687. Longest Univalue Path
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        height(root,root.val);
        return max;
    }
    public int height(TreeNode root, int parentVal){
        if(root == null) return 0;
        int left = height(root.left,root.val);
        int right = height(root.right,root.val);

        max = Math.max(max, left + right);
        if(root.val != parentVal){
            return 0;
        }
        return 1+Math.max(left,right);
    }

    // 297. Serialize and Deserialize Binary Tree
    String NULL = "#";
    String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s: data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    // 987. Vertical Order Traversal of a Binary Tree
    // 优先队列，存储节点值，层数和列数三元组
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->
            a[2] == b[2] ? (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]) : a[2] - b[2]);

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preorder(root, 0, 0);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        // 以列作为键将节点值放入map中
        while (!q.isEmpty()){
            int[] poll = q.poll();
            List<Integer> lst = map.getOrDefault(poll[2], new ArrayList<>());
            lst.add(poll[0]);
            map.put(poll[2], lst);
        }
        return new ArrayList<>(map.values());
    }

    public void preorder(TreeNode root, int row, int col){
        if (root == null) return;
        q.offer(new int[]{root.val, row, col});
        preorder(root.left, row + 1, col - 1);
        preorder(root.right, row + 1, col + 1);
    }

    // 222. Count Complete Tree Nodes
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        int hLeft = height(root.left);
        int hRight = height(root.right);
        if(hLeft == hRight){//左子树遍满了
            count = (int)Math.pow(2,hLeft)  + countNodes(root.right);
        }else{ // 右子树遍满了，单算左子树
            count = (int)Math.pow(2,hRight) + countNodes(root.left);
        }
        return count;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    // 129. Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,0);
    }
    // 累加算到每个叶子结点，然后把每个叶子节点加起来
    public int dfs(TreeNode root, int preSum){
        if(root == null) return 0;
        preSum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return preSum;
        }
        return dfs(root.left,preSum) + dfs(root.right,preSum);

    }

    // 1325. Delete Leaves With a Given Value
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        TreeNode left = removeLeafNodes(root.left,target);
        TreeNode right = removeLeafNodes(root.right,target);
        root.left = left;
        root.right = right;
        if(left == null && right == null && root.val == target){
            return null;
        }
        return root;
    }

}



class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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