class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<n-1;i++){
            int dif = heights[i+1] - heights[i];
            if(dif > 0){
                if(bricks >= dif){
                    bricks -= dif;
                    pq.add(dif);
                }
                else if(ladders > 0){
                    if(!pq.isEmpty()){
                        int maxPast = pq.peek();
                        if(dif <= maxPast){
                            bricks += maxPast;
                            bricks -= dif;
                            pq.poll();
                            pq.add(dif);
                        }
                    }
                    ladders--;
                }
                else{
                    return i;
                }
            }
        }
        return n-1;
    }
}