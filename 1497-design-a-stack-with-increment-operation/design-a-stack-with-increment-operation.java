class CustomStack {
    int n;
    int[] inc;
    Stack<Integer> st;
    public CustomStack(int maxSize) {
        inc = new int[maxSize];
        st = new Stack<>();
        n = maxSize;
    }
    
    public void push(int x) {
        if(st.size() < n){
            st.push(x);
        }
    }
    
    public int pop() {
        int i = st.size() - 1;
        if(i < 0) return -1;
        if(i > 0) inc[i-1] += inc[i];
        int num = st.pop();
        num += inc[i];
        inc[i] = 0;
        return num;
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, st.size()) - 1; 
        if(k >=0) inc[k] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */