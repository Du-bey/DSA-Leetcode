class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[n - k + 1];
        for(int i =0;i<k;i++){
            pq.add(nums[i]);
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = pq.peek();
        int st = 0;
        for(int i = k;i<n;i++){
            int start = nums[st++];
            h.put(start, h.get(start) - 1);
            pq.add(nums[i]);
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
            while(h.get(pq.peek()) <= 0) pq.poll();
            ans[st] = pq.peek();
        }
        return ans;
    }
}