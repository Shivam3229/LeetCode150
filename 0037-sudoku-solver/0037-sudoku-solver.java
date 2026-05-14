// class Solution {

//     public void solveSudoku(char[][] board) {
//         solve(board);
//     }

//     public boolean solve(char[][] board) {

//         for (int i = 0; i < board.length; i++) {

//             for (int j = 0; j < board[0].length; j++) {

//                 if (board[i][j] == '.') {

//                     for (char c = '1'; c <= '9'; c++) {

//                         if (isValid(board, i, j, c)) {

//                             board[i][j] = c;

//                             if (solve(board))
//                                 return true;

                         
//                             board[i][j] = '.';
//                         }
//                     }

//                     return false;
//                 }
//             }
//         }

//         return true;
//     }

//     public boolean isValid(char[][] board, int row, int col, char c) {

//         for (int i = 0; i < 9; i++) {

//             // row check
//             if (board[row][i] == c)
//                 return false;

//             // column check
//             if (board[i][col] == c)
//                 return false;

//             // 3x3 box check
//             if (board[3 * (row / 3) + i / 3]
//                      [3 * (col / 3) + i % 3] == c)
//                 return false;
//         }

//         return true;
//     }
// }
class Solution {

    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // fill existing numbers
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    int num = board[i][j] - '0';

                    row[i][num] = true;
                    col[j][num] = true;

                    int boxIndex = (i / 3) * 3 + (j / 3);

                    box[boxIndex][num] = true;
                }
            }
        }

        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    int boxIndex = (i / 3) * 3 + (j / 3);

                    for (int num = 1; num <= 9; num++) {

                        if (!row[i][num] &&
                            !col[j][num] &&
                            !box[boxIndex][num]) {

                            // place number
                            board[i][j] = (char)(num + '0');

                            row[i][num] = true;
                            col[j][num] = true;
                            box[boxIndex][num] = true;

                            if (solve(board))
                                return true;

                            // backtrack
                            board[i][j] = '.';

                            row[i][num] = false;
                            col[j][num] = false;
                            box[boxIndex][num] = false;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}