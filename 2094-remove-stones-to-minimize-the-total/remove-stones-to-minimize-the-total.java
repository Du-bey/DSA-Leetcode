class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : piles) pq.add(x);
        for(int i =0;i<k;i++){
            int x = pq.poll();
            pq.add(x - (x/2));
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}