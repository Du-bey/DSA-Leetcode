class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int[] nse = nse(arr, n);
        int[] pse = pse(arr, n);
        int ans = 0;
        for(int i =0;i<n;i++){
            int temp = nse[i] - i;
            temp %= mod;
            int temp2 = i - pse[i];
            temp2 %= mod;
            int t = temp * temp2;
            t %= mod;
            long res = ((long) t) * (long) arr[i];
            res %= mod;
            ans += res;
            ans %= mod;
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