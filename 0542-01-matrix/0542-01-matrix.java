import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        // Push all 0's into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Node current = q.poll();

            int row = current.first;
            int col = current.second;
            int steps = current.third;

            distance[row][col] = steps;

            for (int i = 0; i < 4; i++) {

                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] == 0) {

                    visited[nrow][ncol] = 1;
                    q.offer(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return distance;
    }
}

class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}