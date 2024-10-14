class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int x : nums) pq.add(x);
        
        while(k -- > 0){
            int no = pq.poll();
            ans += no;
            int rem = no % 3;
            no = no /3;
            if(rem > 0) no++;
            pq.add(no);
        }
        return ans;
    }
}