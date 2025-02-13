class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int x : nums) pq.add((long) x);
        int steps = 0;
        while(pq.size() > 1){
            long a = pq.poll();
            if(a >= k) break;
            long b = pq.poll();
            long newVal = (Math.min(a, b) * 2) + Math.max(a, b);
            pq.add(newVal);
            steps++;
        }
        return steps;
    }
}