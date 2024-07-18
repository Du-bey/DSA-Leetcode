class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        if(n == 1)
        return h[0];
        int[] nse = nse(h);
        int[] pse = pse(h);
        int ans = -1;
        for(int i =0;i<n;i++){
            int w = nse[i] - pse[i] - 1;
            int area = w * h[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
  
    public int[] pse(int[] h) {
        int n = h.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nse(int[] h) {
        int n = h.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && h[st.peek()] > h[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}