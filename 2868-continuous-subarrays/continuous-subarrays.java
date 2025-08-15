class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        TreeMap<Integer, Integer> h = new TreeMap<>();
        int n = nums.length;

        int i = 0;
        for(int j =0;j<n;j++){
            h.put(nums[j], h.getOrDefault(nums[j], 0) + 1);
            while(Math.abs(h.lastKey() - h.firstKey()) > 2){
                h.put(nums[i], h.get(nums[i]) - 1);
                if(h.get(nums[i]) == 0) h.remove(nums[i]);
                i++;
            }

            ans += j - i + 1;
        }
        return ans;
    }
}