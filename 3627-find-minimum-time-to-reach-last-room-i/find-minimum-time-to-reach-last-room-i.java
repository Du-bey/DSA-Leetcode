class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dis = new int[n][m];

        for(int[] r : dis){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        dis[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Pair(0, 0, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int x = p.x;
            int y = p.y;
            int w = p.w;

            if(x == n-1 && y == m-1) return w;

            for(int i =0;i<4;i++){
                int nr = x + dr[i];
                int nc = y + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int waitTime = Math.max(moveTime[nr][nc] - w, 0);
                    int arrvTime = w + waitTime + 1;

                    if(dis[nr][nc] > arrvTime){
                        pq.add(new Pair(nr, nc, arrvTime));
                        dis[nr][nc] = arrvTime;
                    }
                }
            }
        }

        return -1;
    }
}

class Pair{
    int x;
    int y;
    int w;

    public Pair(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}