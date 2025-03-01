class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int m = nums2.length;

        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = m - 1;i>=0;i--){
            int num = nums2[i];
            while(!st.isEmpty() && num >= st.peek()){
                st.pop();
            }
            int nge = st.isEmpty() ? -1 : st.peek();
            h.put(num, nge);
            st.push(num);
        }
        for(int i =0;i<n;i++){
            ans[i] = h.get(nums1[i]);
        }
        return ans;
    }
}