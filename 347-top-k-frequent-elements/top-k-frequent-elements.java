class Solution {    
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : nums){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        List<Integer> bucket[] = new ArrayList[n+1];
        for(int x : h.keySet()){
            int freq = h.get(x);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(x);
        }
        int[] ans = new int[k];
        int ind = 0;
        for(int i =n;i>=0;i--){
            if(bucket[i] != null){
                for(int val : bucket[i]){
                    ans[ind++] = val;
                    if(ind == k) return ans;
                }
            }
        }
        return ans;
    }
}