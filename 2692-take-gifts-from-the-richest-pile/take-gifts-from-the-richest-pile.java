class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : gifts){
            pq.add(x);
        }
        for(int i =0;i<k;i++){
            int x = pq.poll();
            pq.add((int) Math.sqrt(x));
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}