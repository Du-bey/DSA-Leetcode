class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i =0;
        int j =0;
        long ans = 0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(Math.abs(map.firstEntry().getKey() - map.lastEntry().getKey()) > 2){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++; 
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}