import java.util.List;

public class Test {
    public static void main(String[] args) {

        // Q1
        /**
         * Input: "aabcccccaaa"
         * Output: "a2b1c5a3"
         * Input: "ab"
         * Output: "ab"
         */
        String str1 = "aabcccccaaa";
        Q1 q1Test = new Q1();
        String resQ1_1 = q1Test.compressString(str1);
        System.out.println("Q1 Test1: " + resQ1_1);

        String str2 = "ab";
        String resQ1_2 = q1Test.compressString(str2);
        System.out.println("Q1 Test2: " + resQ1_2);



        // Q2 Test
        /**
         * Input: grid = [
         *   ["1","1","1","1","0"],
         *   ["1","1","0","1","0"],
         *   ["1","1","0","0","0"],
         *   ["0","0","0","0","0"]
         * ]
         * Output: 1
         *
         * Input: grid = [
         *   ["1","1","0","0","0"],
         *   ["1","1","0","0","0"],
         *   ["0","0","1","0","0"],
         *   ["0","0","0","1","1"]
         * ]
         * Output: 3
         */

        char[][] grid1 = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Q2 q2Test = new Q2();
        int resQ2_1 = q2Test.numIslands(grid1);
        System.out.println("Q2 Test1: " +resQ2_1);

        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int resQ2_2 = q2Test.numIslands(grid2);
        System.out.println("Q2 Test2: " + resQ2_2);


        // Q3


        /**
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         *
         * Input: strs = [""]
         * Output: [[""]]
         *
         * Input: strs = ["a"]
         * Output: [["a"]]
         */
        String[] strs1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        Q3 q3Test = new Q3();
        List<List<String>> resQ3_1 = q3Test.groupAnagrams(strs1);

        String[] strs2 = new String[]{""};
        List<List<String>> resQ3_2 = q3Test.groupAnagrams(strs2);

        String[] strs3 = new String[]{"a"};
        List<List<String>> resQ3_3 =q3Test.groupAnagrams(strs3);


        // Q4
        /**
         * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
         * Output: 6
         * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
         * Output: 2
         * Input: root = [2,1], p = 2, q = 1
         * Output: 2
         */

        TreeNode root = new TreeNode(6);
        TreeNode p1 = new TreeNode(2);
        root.left = p1;
        TreeNode q1 = new TreeNode(8);
        root.right = q1;
        root.left.left = new TreeNode(0);
        TreeNode q2 = new TreeNode(4);
        root.left.right = q2;
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);


        Q4 q4Test = new Q4();
        TreeNode res1 = q4Test.lowestCommonAncestor(root, p1, q1);
        System.out.println("Q1 Test1: " +res1.val);
        TreeNode res2 = q4Test.lowestCommonAncestor(root, p1, q2);
        System.out.println("Q1 Test2: " + res2.val);


        TreeNode root1 = new TreeNode(2);
        TreeNode q = root1.left = new TreeNode(1);

        TreeNode res3 = q4Test.lowestCommonAncestor(root1, root1, q);
        System.out.println(("Q1 Test3: " + res3.val));






    }
}
