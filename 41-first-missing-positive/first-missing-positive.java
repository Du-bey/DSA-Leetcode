class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int x : nums){
            if(x > 0 && x < n+2)
            arr[x]++;
        }
        for(int i =1;i<n+2;i++){
            if(arr[i] == 0){
                return i;
            }
        }
        return n+1;
    }
}