class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // First row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, n, m);
            }
        }

        // Last row
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, n, m);
            }
        }

        // First column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, n, m);
            }
        }

        // Last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, n, m);
            }
        }

        // Convert remaining O -> X and * -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board, int n, int m) {

        // Base condition
        if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] != 'O')
            return;

        board[r][c] = '*';

        dfs(r - 1, c, board, n, m);
        dfs(r + 1, c, board, n, m);
        dfs(r, c - 1, board, n, m);
        dfs(r, c + 1, board, n, m);
    }
}