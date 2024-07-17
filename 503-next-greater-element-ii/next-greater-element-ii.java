class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1; i>=0; i--){
            int ind = i % n;
            while(!st.isEmpty() && nums[ind] >= st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                if(i < n){
                    ans[ind] = st.peek();
                }
            }
            else{
                if(i < n){
                    ans[ind] = -1;
                }
            }
            st.push(nums[ind]);
        }
        return ans;
    }
}