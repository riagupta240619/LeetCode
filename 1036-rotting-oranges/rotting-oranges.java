class Solution {
    public int orangesRotting(int[][] grid) {
        // Put all initially rotten oranges into the queue.
        // Count the number of fresh oranges.
        // Run BFS level by level.
        // Each level represents 1 minute.
        // Whenever a fresh orange becomes rotten:
        // mark it 2
        // decrease fresh
        // add it to the queue
        // If fresh oranges remain at the end, return -1.
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int min = 0;
        int[][] direc = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : direc){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR >=0 && newR < rows &&
                    newC>=0 && newC<cols && 
                    grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        fresh--;
                        q.offer(
                            new int[]{newR, newC}
                        );
                    }
                }
            }
            min++;
        }
        return (fresh == 0) ? min -1 : -1;
    }
}