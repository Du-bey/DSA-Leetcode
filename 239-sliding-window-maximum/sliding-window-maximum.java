class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i =0;i<k-1;i++){
            while(!st.isEmpty() && nums[i] > nums[st.getLast()]){
                st.removeLast();
            }
            st.addLast(i);
        }
        int l = 0;
        int[] ans = new int[n - k + 1];
        int ind = 0;
        for(int i = k-1;i<n;i++){
            if(!st.isEmpty() && st.getFirst() <= i-k){
                st.removeFirst();
            }
            while(!st.isEmpty() && nums[i] > nums[st.getLast()]){
                st.removeLast();
            }
            st.addLast(i);
            ans[ind++] = nums[st.getFirst()];
            
        }
        return ans;
    }
}