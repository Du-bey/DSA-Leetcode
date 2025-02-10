class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> h = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = arr[i];
            h.putIfAbsent(x, new ArrayList<>());
            h.get(x).add(i);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(new Pair(0, 0));
        vis[0] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int cost = p.cost;
            int ind = p.ind;
            if(ind == n-1) return cost;
            int val = arr[ind];
            if (h.containsKey(val)) {
                for(int v : h.get(val)){
                    if(!vis[v]){
                        q.add(new Pair(cost + 1, v));
                        vis[v] = true;
                    }
                }
                h.remove(val);
            }
            if(ind + 1 < n){
                int v = ind + 1;
                if(!vis[v]){
                    q.add(new Pair(cost + 1, v));
                    vis[v] = true;
                }
            }
            if(ind > 0){
                int v = ind - 1;
                if(!vis[v]){
                    q.add(new Pair(cost + 1, v));
                    vis[v] = true;
                }
            }
        }
        return -1;
    }
}

class Pair{
    int cost;
    int ind;
    public Pair(int cost, int ind){
        this.cost = cost;
        this.ind = ind;
    }
}