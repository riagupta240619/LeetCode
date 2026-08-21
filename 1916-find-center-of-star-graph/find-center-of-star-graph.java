class Solution {
    public int findCenter(int[][] edges) {
        // if(edges.length == 0) return 0;
        // List<List<Integer>> graph = new ArrayList<>();
        // int node = 0;
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < edges.length + 1; i++) {
        //     graph.add(new ArrayList<>());
        // }
        // for(int i = 0;i<edges.length;i++){
        //     for(int j = 0;j<2;j++){
        //         if(!set.contains(edges[i][j])){
        //             node++;
        //             set.add(edges[i][j]);
        //         }
        //         graph.get(i).add(edges[i][j]);
        //         graph.get(j).add(edges[i][j]);
        //     }
        // }
        // int idx = 0;
        // for(List<Integer> arr :graph){
        //     if(arr.size() == node -1) return idx;
        // }
        // return -1;

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}