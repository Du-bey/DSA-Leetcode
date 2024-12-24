class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = nse(arr, n);
        int[] pse = pse(arr, n);
        int ans = 0;
        for(int i =0;i<n;i++){
            int res = (nse[i] - 1 - pse[i]);
            res *= arr[i];
            ans = Math.max(res, ans);
        }
        return ans;
    }

    public int[] nse(int[] arr,int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;i>=0;i--){
            int num = arr[i];
            while(!st.isEmpty() && num <= arr[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] pse(int[] arr, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<n; i++){
            int num = arr[i];
            while(!st.isEmpty() && num < arr[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}