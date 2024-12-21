class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        for(int i =prices.length - 1; i >=0 ;i--){
            while(!st.isEmpty() && st.peek() > prices[i]) st.pop();
            int dis = 0;
            if(!st.isEmpty()){
                dis = st.peek();
            }
            st.push(prices[i]);
            prices[i] -= dis;
        }
        return prices;
    }
}