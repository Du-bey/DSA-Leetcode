class Solution {
    public int numBusesToDestination(int[][] routes, int s, int t) {
        if(s == t) return 0;
        int n = routes.length;
        boolean[] vis = new boolean[n];
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            int[] r = routes[i];
            for(int x : r){
                if(x == s){
                    q.add(i);
                    vis[i] = true;
                }
                h.putIfAbsent(x, new ArrayList<>());
                h.get(x).add(i);
            }
        }
        
        int jumps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            jumps++;
            for(int i =0;i<size;i++){
                int bus = q.poll();
                for (int stop : routes[bus]) { 
                    if (stop == t) return jumps;
                    for(int nextBus : h.get(stop)){
                        if(!vis[nextBus]){
                            q.add(nextBus);
                            vis[nextBus] = true;
                        }
                    }
                }
            }
        }
        return -1;

    }
}