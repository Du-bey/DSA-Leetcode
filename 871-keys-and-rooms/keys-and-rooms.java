class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) { 
        Queue<Integer> q = new LinkedList<>();
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            cnt++;
            for(int v : rooms.get(u)){
                if(!vis[v]){
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
        return cnt == n;
    }
}