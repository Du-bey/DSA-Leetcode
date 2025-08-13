class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for(int i = 0;i<k-1;i++){
            int num = nums[i];
            while(!st.isEmpty() && num > nums[st.getLast()]){
                st.removeLast();
            }
            st.addLast(i);
        }
        
        int ind = 0;
        for(int i = k-1;i<n;i++){
            int num = nums[i];
            if(!st.isEmpty() && st.getFirst() == i - k){
                st.removeFirst();
            }
            while(!st.isEmpty() && num > nums[st.getLast()]){
                st.removeLast();
            }
            st.addLast(i);
            ans[ind++] = nums[st.getFirst()];
        }
        return ans;
    }
}