class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int ind = st.pop();
                int prev = st.isEmpty() ? -1 : st.peek();
                int area = arr[ind] * (i - prev - 1);
                ans = Math.max(ans, area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ind = st.pop();
            int next = n;
            int prev = st.isEmpty() ? -1 : st.peek();
            int area = arr[ind] * (n - prev - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}