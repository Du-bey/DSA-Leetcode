class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> radj = new ArrayList<>();
        List<List<Integer>> badj = new ArrayList<>();
        for(int i =0;i<n;i++){
            radj.add(new ArrayList<>());
            badj.add(new ArrayList<>());
        }
        for(int[] edge : redEdges){
            radj.get(edge[0]).add(edge[1]);
        }
        for(int[] edge : blueEdges){
            badj.get(edge[0]).add(edge[1]);
        }
        int[] r = new int[n];
        int[] b = new int[n];
        int[] ans = new int[n];
        Arrays.fill(r, 100000000);
        Arrays.fill(b, 100000000);
        r[0] = 0;
        b[0] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        q.add(new Pair(0, 1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int u = p.first;
            int col = p.second;
            
            if(col == 0){
                for(int v : badj.get(u)){
                    if(b[v] > r[u] + 1){
                        b[v] = r[u] + 1;
                        q.add(new Pair(v, 1));
                    }
                }
            }

            if(col == 1){
                for(int v : radj.get(u)){
                    if(r[v] > b[u] + 1){
                        r[v] = b[u] + 1;
                        q.add(new Pair(v, 0));
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            int t = Math.min(r[i], b[i]);
            if(t >= 100000000){
                t = -1;
            }
            ans[i] = t;
        }
        return ans;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;

    }
}