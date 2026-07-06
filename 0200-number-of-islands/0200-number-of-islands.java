class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,n,m);
                }
            }
        }
        return count;
     }
     public void dfs(int row,int col,char[][] grid,int n,int m){
        grid[row][col] = '*';
        if (row - 1 > -1 && grid[row - 1][col] == '1') dfs(row - 1, col, grid,n,m);
        if (row + 1 < n && grid[row + 1][col] == '1') dfs(row + 1, col, grid,n,m);
        if (col - 1 > -1 && grid[row][col - 1] == '1') dfs(row, col - 1, grid,n,m);
        if (col + 1 < m && grid[row][col + 1] == '1') dfs(row, col + 1, grid,n,m);
     }
}











// }class Solution {
//     public int numIslands(char[][] grid) {
//          int count = 0;
//         int n = grid.length;
//         int m = grid[0].length;
//          boolean visited[][] = new boolean[n][m];
//          Queue<Node> q = new LinkedList<>();
//          for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]=='1' && !visited[i][j])
//                 {  count++;
//                     q.offer(new Node(i,j));
//                     visited[i][j] = true;
//                      int drow[] = {-1,0,1,0};
//                      int dcol[] = {0,-1,0,1};
//                   while(!q.isEmpty()){
//                    int r = q.peek().first;
//                    int c = q.peek().second;
//                       q.remove();
//                        for(int k=0;k<4;k++){
//                           int nrow = r + drow[k];
//                           int ncol = c + dcol[k];
//                          if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !visited[nrow][ncol]){
//                             visited[nrow][ncol] = true;
//                             q.offer(new Node(nrow,ncol));
//                          }
//                        }
//                   }
                

            
//                 }
//             }
//          }
//          return count;
        
//     }
// }

// class Node {
//     int first, second;

//     Node(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }