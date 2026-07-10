class Solution {
public boolean dfs(int node, int col, int colour[], int[][] graph) {
    colour[node] = col;

    for (int neighbour : graph[node]) {

        if (colour[neighbour] == -1) {
            if (!dfs(neighbour, 1 - col, colour, graph))
                return false;
        }
        else if (colour[neighbour] == col) {
            return false;
        }
    }

    return true;
}
    public boolean isBipartite(int[][] graph) {
        int colour [] = new int[graph.length];
        // filled Array with -1
        for(int i=0;i<graph.length;i++){
            colour[i] = -1;
        }
        for(int i=0;i<graph.length;i++){
            if(colour[i] == -1){
                 if(dfs(i,0,colour,graph)==false) return false;
            }
        }
   return true;
    }
}