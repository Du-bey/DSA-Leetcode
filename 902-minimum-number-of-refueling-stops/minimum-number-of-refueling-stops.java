class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = stations.length;
        int ans = 0;
        int i = 0;
       
        while(startFuel < target){
            while(i < n && startFuel >= stations[i][0]){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.isEmpty()) return -1;
            startFuel += pq.poll();
            ans++;
        }

       return ans;
    }
}