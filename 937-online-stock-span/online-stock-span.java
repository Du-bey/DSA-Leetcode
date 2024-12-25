class StockSpanner {
    Stack<Pair> st;
    HashMap<Integer, Integer> h;
    int cnt;
    public StockSpanner() {
        st = new Stack<>();
        cnt = -1;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().first <= price){
            st.pop();
        }
        cnt++;
        int ans = st.isEmpty() ? -1 : st.peek().second;
        st.push(new Pair(price, cnt));
        return cnt - ans;
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