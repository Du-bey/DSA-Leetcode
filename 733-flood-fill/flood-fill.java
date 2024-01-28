class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalCol = image[sr][sc];
        int [] dr = {0, -1, 0, 1};
        int [] dc = {-1, 0, 1, 0};
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        vis[sr][sc] = true;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c =q.peek().second;
            q.remove();

            for(int i =0;i<4;i++){
                int newr = r +dr[i];
                int newc = c +dc[i];
                if(newr >=0 && newc >=0 && newr <n && newc < m && !vis[newr][newc] 
                    && image[newr][newc] == originalCol){
                    image[newr][newc] = color;
                    vis[newr][newc] = true;
                    q.add(new Pair(newr, newc));
                }
            }
        }
        return image;
    }
}

public class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}