class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        TreeMap<Integer, Integer> h = new TreeMap<>();
        int ans = 0;
        int i =0;
        for(int j =0;j<n;j++){
            int x = nums[j];
            h.put(x, h.getOrDefault(x, 0) + 1);

            while(Math.abs(h.firstKey() - h.lastKey()) > limit){
                h.put(nums[i], h.get(nums[i]) - 1);
                if(h.get(nums[i]) == 0) h.remove(nums[i]);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}