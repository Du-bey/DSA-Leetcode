class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty() || st.peek().b > val){
            st.push(new Pair(val, val));
        }
        else{
            st.push(new Pair(val, st.peek().b));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().a;
    }
    
    public int getMin() {
        return st.peek().b;
    }
}
class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */