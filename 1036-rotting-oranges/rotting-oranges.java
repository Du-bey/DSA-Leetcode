class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Triplet> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Triplet(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            Triplet trip = q.peek();
            int r= trip.r;
            int c = trip.c;
            int t = trip.tim;
            q.remove();
            ans = Math.max(ans, t);
            int[] delr = {-1, 0, 1, 0};
            int[] delc = {0, 1, 0, -1};

            for(int i =0;i<4;i++){
                int newr = r + delr[i];
                int newc = c + delc[i];
                if(newr >=0 && newc >= 0 && newr < n && newc < m 
                    && grid[newr][newc] == 1 && !vis[newr][newc]){
                        q.add(new Triplet(newr, newc, t +1));
                        vis[newr][newc] = true;
                        //ans = t;
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}

public class Triplet{
    int r;
    int c;
    int tim;
    public Triplet(int r, int c, int tim){
        this.r = r;
        this.c = c;
        this.tim = tim;
    }
}