class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] cb, int[] ib) {
        int n = status.length;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> box = new HashSet<>();
        Set<Integer> vis = new HashSet<>();

        for(int x : ib){
            box.add(x);
            if(status[x] == 1){
                q.add(x);
                vis.add(x);
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            ans += candies[x];

            for(int k : keys[x]){
                status[k] = 1;
                if(box.contains(k) && !vis.contains(k)){
                    q.add(k);
                    vis.add(k);
                }
            }

            for(int b : cb[x]){
                box.add(b);
                if(vis.contains(b)) continue;
                
                if(status[b] == 1){
                    q.add(b);
                    vis.add(b);
                }
            }
        }
        return ans;
    }
}
