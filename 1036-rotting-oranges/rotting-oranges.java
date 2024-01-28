class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Triplet(0,i,j));
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int time = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();

            ans = Math.max(ans, time);

            int[] delr = {0, -1, 0, 1};
            int[] delc = {-1, 0, 1, 0};

            for(int i =0;i<4;i++){
                int newr = r + delr[i];
                int newc = c + delc[i];
                if(newr >=0 && newc >= 0 && newr < n && newc < m 
                    && grid[newr][newc] == 1 && !vis[newr][newc]){
                        q.add(new Triplet(time +1, newr, newc));
                        vis[newr][newc] = true;
                        ans = time;
                }
            }

        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]) return -1;
            }
        }
        return ans;
    }
}

public class Triplet{
    int first;
    int second;
    int third;


    public Triplet(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}