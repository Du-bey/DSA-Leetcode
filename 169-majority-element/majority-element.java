class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = 0;
        int cnt = 0;
        for(int num : nums){
            if(num == ele){
                cnt++;
            }
            else if(cnt == 0){
                ele = num;
                cnt = 1;
            }
            else{
                cnt--;
            }
        }
        return ele;
    }
}
