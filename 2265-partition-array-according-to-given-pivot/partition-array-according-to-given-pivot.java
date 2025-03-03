class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int eq = 0;
        int less = 0;

        int[] ans = new int[n];
        for(int x : nums){
            if(x == pivot) eq++;
            else if(x < pivot) less++;
        }
        int greater = eq + less;
        int start = 0;
        for(int x : nums){
            if(x == pivot){
                ans[less++] = x;
            }
            else if(x > pivot){
                ans[greater++] = x;
            }
            else{
                ans[start++] = x;
            }
        }
        return ans;
    }
}