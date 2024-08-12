class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
        return 0;
        HashSet<Integer> h = new HashSet<>();
        for(int no : nums){
            h.add(no);
        }
        int ans = 1;
        for(int i =0;i<n;i++){
            int x = nums[i];
            if(!h.contains(x - 1)){
                int m = x + 1;
                while(h.contains(m)){
                    m++;
                }
                ans = Math.max(ans, m - x);
            }
        }
        return ans;
    }
}