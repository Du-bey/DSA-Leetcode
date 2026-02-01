class Solution {
    public int minimumCost(int[] nums) {
        int a = 51, b = 51, c = 51;
        
        for(int x : nums){
            if(x <= a){
                c = b;
                b = a;
                a = x;
            }
            else if(x <= b){
                c = b;
                b = x;
            }
            else if(x <= c){
                c = x;
            }
        }

        c = Math.max(c, nums[0]);

        return a + b + c;
    }
}