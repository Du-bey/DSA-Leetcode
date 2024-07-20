class StockSpanner {
    Stack<Pair> st;
    int ind = -1;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int price) { 
        while(!st.isEmpty() && price >= st.peek().first){
            st.pop();
        }
        ind++;
        int ans = st.isEmpty() ? -1 : st.peek().second;
        ans = ind - ans;
        st.push(new Pair(price, ind));
        return ans;
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */