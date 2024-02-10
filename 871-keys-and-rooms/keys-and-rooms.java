class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : rooms.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        for(int i =0;i<n;i++){
            if(!vis[i]) {
                return false;
            }
        }
        return true;
    }
}