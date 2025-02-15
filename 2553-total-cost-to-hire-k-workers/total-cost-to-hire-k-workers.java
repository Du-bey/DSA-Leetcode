class Solution {
    public long totalCost(int[] costs, int k, int c){
        int n = costs.length;
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        long ans = 0;
        int li = 0;
        int ri = n-1;
        for (int i = 0; i < c; i++) {
            l.add(costs[li++]);
        }

        for (int i = 0; i < c && ri >= li; i++) {  
            r.add(costs[ri--]);
        }

        for(int i =0;i<k;i++){
            if(!l.isEmpty() && (r.isEmpty() || l.peek() <= r.peek())){
                ans += l.poll();
                if(li <= ri) l.add(costs[li++]);
            }
            else{
                ans += r.poll();
                if(li <= ri) r.add(costs[ri--]);
            }
        }
        return ans;
    }
}