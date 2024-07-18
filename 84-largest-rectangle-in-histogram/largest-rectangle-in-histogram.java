class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        if(n == 1)
        return h[0];
        int ans = -1;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && h[i] < h[st.peek()]){
                int no = h[st.pop()];
                int next = i;
                int prev = -1;
                if(!st.isEmpty()){
                    prev = st.peek();
                }
                int w = next - prev - 1;
                int a = w * no;
                ans = Math.max(ans, a);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int no = h[st.pop()];
            int next = n;
            int prev = st.isEmpty() ? -1 : st.peek();
            int w = next - prev - 1;
            int a = w * no;
            ans = Math.max(ans, a);
        }
        return ans;
    }
}