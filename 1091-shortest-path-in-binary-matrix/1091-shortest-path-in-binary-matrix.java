class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or destination blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        // Single cell grid
        if (n == 1)
            return 1;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 0});

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int dis = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int i = 0; i < 8; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    dis + 1 < dist[nr][nc]) {

                    dist[nr][nc] = dis + 1;

                    if (nr == n - 1 && nc == n - 1)
                        return dis + 1;

                    q.offer(new int[]{dis + 1, nr, nc});
                }
            }
        }

        return -1;
    }
}