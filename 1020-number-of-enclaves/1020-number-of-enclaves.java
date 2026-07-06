class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // first row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid,n,m);
            }
        }

        // Last Row
        for (int j = 0; j < m; j++) {
            if (grid[n - 1][j] == 1) {
                dfs(n - 1, j, grid,n,m);
            }
        }

        // First Column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid,n,m);
            }
        }

        // Last Column
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid,n,m);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
        if(grid[i][j] == 1)
            count++;


    return count;

    }
    public void dfs(int row,int col,int[][]grid,int n,int m){
        grid[row][col] = 0;
        if (row - 1 > -1 && grid[row - 1][col] == 1) dfs(row - 1, col, grid,n,m);
        if (row + 1 < n && grid[row + 1][col] == 1) dfs(row + 1, col, grid,n,m);
        if (col - 1 > -1 && grid[row][col - 1] ==1) dfs(row, col - 1, grid,n,m);
        if (col + 1 < m && grid[row][col + 1] == 1) dfs(row, col + 1, grid,n,m);
    }

}
// if any land is connected with the boundary and also connected with the another land then there is no land wiil ever get surrounded by water