class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int x : hap) pq.add(x);
        
        for(int i = 0;i<k;i++){
            int h = pq.poll() - i;
            if(h > 0) ans += h;
        } 
        return ans;
    }
}