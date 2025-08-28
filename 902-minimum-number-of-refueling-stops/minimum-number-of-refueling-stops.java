class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target == startFuel) return 0;
        //if(stations[0][0] > startFuel) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = stations.length;
        int ans = 0;
       
        for(int i = 0;i<n;i++){
            int p = stations[i][0];
            int f = stations[i][1];

            while(startFuel < p){
                if(pq.isEmpty()) return -1;
                startFuel += pq.poll();
                ans++;
            }
            pq.add(f);
        }

        while(startFuel < target){
            if(pq.isEmpty()) return -1;
            startFuel += pq.poll();
            ans++;
        }
       return ans;
    }
}