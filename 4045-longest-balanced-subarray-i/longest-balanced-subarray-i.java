class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i =0;i<n;i++){
            Set<Integer> s = new HashSet<>();
            int ev = 0;
            int odd = 0;
            for(int j =i;j<n;j++){    
                int x = nums[j];
                
                if(s.add(x)){
                    if(x % 2 == 0) ev++;
                    else odd++;
                }
                if(ev == odd) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}