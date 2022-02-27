package com.neu;

import com.sun.jdi.Value;

import java.util.*;

public class Assignment05 {

    // 107. Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    // 366. Find Leaves of Binary Tree
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        height(root,list);
        root = null;
        return list;
    }
    public int height(TreeNode root,List<List<Integer>> list){
        if(root == null) return 0;
        int level = 1+ Math.max(height(root.left,list),height(root.right,list));
        if(list.size() < level){
            list.add(new ArrayList<>());
        }
        list.get(level-1).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }

    // 662. Maximum Width of Binary Tree
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            int width = queue.getLast().val - queue.getFirst().val + 1;
            for(int i = 0; i< size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                    cur.left.val = cur.val * 2 +1;
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    cur.right.val = cur.val * 2+2;
                }
            }max = Math.max(max,width);
        }return max;
    }

    // 515. Find Largest Value in Each Tree Row
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                max = Math.max(max,cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right !=null){
                    queue.add(cur.right);
                }
            }
            list.add(max);
        }
        return list;
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