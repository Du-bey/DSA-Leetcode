class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    int n;
    int m;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        if(oc == color) return image;

        n = image.length;
        m = image[0].length;    

        image[sr][sc] = color;
        dfs(sr, sc, color, oc, image);
        return image;
    }

    public void dfs(int r, int c, int color, int oc, int[][] image){
        for(int i = 0;i < 4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >=0 && nr < n && nc < m && image[nr][nc] == oc){
                image[nr][nc] = color;
                dfs(nr, nc, color, oc, image);
            }
        }
    }
}

public class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}