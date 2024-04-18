class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i =0;i<n;i++){
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int j = i+1;
            int k = n-1;
            while(j<k){
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if(sum < 0) j++;
                if(sum > 0) k--;
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(a, b, c);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}