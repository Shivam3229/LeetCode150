class Solution {

    public boolean dfs(int node, List<List<Integer>> graph, int[] state) {

        state[node] = 1; // visiting

        for (int next : graph.get(node)) {

            if (state[next] == 1) {
                return false; // cycle found
            }

            if (state[next] == 0) {
                if (!dfs(next, graph, state))
                    return false;
            }
        }

        state[node] = 2; // completely processed
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {
                if (!dfs(i, graph, state))
                    return false;
            }
        }

        return true;
    }
}