class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int minute = 0;
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            minute++;

            for(int i=0; i < size; i++){
                int[] curr = q.poll();

                for(int[] d : dir){
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];
                if(ni >= 0 && nj >=0 && ni < m && nj < n && grid[ni][nj]==1){
                    grid[ni][nj]=2;
                    q.offer(new int[] {ni,nj});
                    fresh--;
                    }
                }
            }
        }
        return(fresh ==0 )? minute : -1;
    }
}