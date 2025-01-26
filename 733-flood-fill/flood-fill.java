class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int oc = image[sr][sc];
        if(oc == color) return image;
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.a;
            int c = p.b;
            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == oc){
                    q.add(new Pair(nr, nc));
                    image[nr][nc] = color;
                }
            }            
        }
        return image;
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