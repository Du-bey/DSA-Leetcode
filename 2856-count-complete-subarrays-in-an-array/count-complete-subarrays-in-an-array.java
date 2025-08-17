class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> h = new HashSet<>();

        for(int x : nums) h.add(x);
        int cnt = h.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int ans = 0;

        for(int j =0;j<n;j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() == cnt){
                ans += n - j;
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
        }
        return ans;
    }
}