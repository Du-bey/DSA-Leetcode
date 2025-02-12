class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int x : piles){
            pq.add(x);
            sum += x;
        }
        for(int i =0;i<k;i++){
            int x = pq.poll();
            int val = x / 2;
            sum -= val;
            pq.add(x - (x/2));
        }
        return sum;
    }
}