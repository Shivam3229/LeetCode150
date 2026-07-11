class Solution {

    public boolean dfs(int node, int[] vis, int[] pathVis, int[] check, int[][] graph) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int next : graph[node]) {

            if (vis[next] == 0) {
                if (dfs(next, vis, pathVis, check, graph))
                    return true;
            } else if (pathVis[next] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, check, graph);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }

        return safeNodes;
    }
}