class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int num : nums){
            h.put(num, h.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> h.get(b) - h.get(a));
        for(int key : h.keySet()){
            pq.add(key);
        }
        int[] ans = new int[k];
        for(int i =0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}