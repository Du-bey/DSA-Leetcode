class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1;i >= 0;i--){
            int val = nums[i];
            while(!st.isEmpty() && val >= st.peek()) st.pop();
            st.push(val);
        }
        for(int i = n-1;i>=0;i--){
            int val = nums[i];
            while(!st.isEmpty() && val >= st.peek()) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(val);
        }
        return ans;
    }
}