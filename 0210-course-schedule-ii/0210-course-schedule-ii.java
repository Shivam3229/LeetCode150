class Solution {

    public boolean dfs(int node, int[] state,
                       ArrayList<ArrayList<Integer>> adj,
                       ArrayList<Integer> ans) {

        state[node] = 1; // Visiting

        for (int next : adj.get(node)) {

            if (state[next] == 1) {
                return false; // Cycle found
            }

            if (state[next] == 0) {
                if (!dfs(next, state, adj, ans))
                    return false;
            }
        }

        state[node] = 2; // Completely processed
        ans.add(node);   // Store in reverse topological order

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, state, adj, ans)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(ans);

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}