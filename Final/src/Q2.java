public class Q2 {
    /**
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
     * islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     */
    public int numIslands(char[][] grid) {
        //TODO: Write your code here
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n == 0) return 0;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        //else FloodFill
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}

