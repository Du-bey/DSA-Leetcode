class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int n = nums.length;
        int i = 0;
        int ans = 0;
        int x = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int j =0;j<n;j++){
            h.put(nums[j], h.getOrDefault(nums[j], 0) + 1);

            while(h.size() > k){
                h.put(nums[i], h.get(nums[i]) - 1);
                if(h.get(nums[i]) == 0) h.remove(nums[i]);
                i++;
                x = i;
            }

            while(h.get(nums[i]) > 1){
                h.put(nums[i], h.get(nums[i]) - 1);
                i++;
            }
            if(h.size() == k) ans += i - x + 1;
        }
        return ans;
    }
}