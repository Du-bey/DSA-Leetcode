class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 1){
            return nums[0] == val ? 0 : 1;
        }
        boolean same = true;
        for(int i =0;i<n;i++){
            if(nums[i] != val) same = false;
        }
        if(same) return 0;
        int j = n-1;
        int i =0;
        while(i <= j){
            if(nums[i] == val){
                if(nums[j] == val) j--;
                else{
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j--] = temp;
                }
            }
            else{
                i++;
            }
        }
        return i;
    }
}