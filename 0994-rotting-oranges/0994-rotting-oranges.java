class Solution {
    class orange
    {
        int i;
        int j;
        int t;
        orange(int i,int j,int t)
        {
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<orange>q=new LinkedList<>();
        boolean [][]vis=new boolean [grid.length][grid[0].length];
        int freshCount=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    freshCount++;
                else if(grid[i][j]==2)
                {
                    q.add(new orange(i,j,0));
                    vis[i][j]=true;
                }
                else
                    continue;
            }
        }
        int time=0;
        int [][]dir={{0,1},{1,0},{0,-1},{-1,0}};
        while(q.size()>0)
        {
            orange fnt= q.remove();
            vis[fnt.i][fnt.j]=true;
            time=Math.max(time,fnt.t);
            for(int []d:dir)
            {
                int nr=fnt.i+d[0];
                int nc=fnt.j+d[1];
                if(isValid(nr,nc,grid) && grid[nr][nc]==1 && (vis[nr][nc]==false))
                {
                    freshCount--;
                    vis[nr][nc]=true;
                    q.add(new orange(nr,nc,fnt.t+1));
                }
            }
        }    
        if(freshCount==0)
            return time;
        else
            return -1;    
    }

    public boolean isValid(int r,int c,int [][]grid)
    {
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length)
            return true;
        else
            return false;
    }
}