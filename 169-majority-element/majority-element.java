class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 1;
        int ele = nums[0];
        for(int i =1;i<n;i++){
            if(nums[i] == ele){
                cnt++;
            }
            else if(cnt == 0){
                ele = nums[i];
            }
            else{
                cnt--;
            }
        }
        return ele;
    }
}