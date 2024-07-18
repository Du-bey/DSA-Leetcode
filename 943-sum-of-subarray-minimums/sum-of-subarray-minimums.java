class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int[] nse = nse(arr);
        int[] pse = pse(arr);

        int ans = 0;
        for(int i =0;i<n;i++){
            int l = i - pse[i];
            int r = nse[i] - i;
            int lr = l*r;
            lr %= mod;
            long res = ((long) lr)* (long) arr[i];
            res = res % mod;
            ans += res;
            ans = ans % mod; 
        }
        return ans;
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}