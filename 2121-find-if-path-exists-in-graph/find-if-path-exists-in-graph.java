class Solution {
    List<List<Integer>> graph;
    boolean[] visited;
    boolean dfs(int node, int destination) {
        if(node == destination)
            return true;
        visited[node] = true;
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                if(dfs(next, destination))
                    return true;
            }
        } 
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // adjency list
        graph = new ArrayList<>();
        visited = new boolean[n];
        // graph.size == number of nodes
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // directed graph is made
        for(int[] arr : edges){
            int x = arr[0];
            int y = arr[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // use dfs to check the path if exists from source to destination
        return dfs(source, destination); 
    }
}