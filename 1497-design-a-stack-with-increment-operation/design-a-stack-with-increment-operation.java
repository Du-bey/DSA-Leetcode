class CustomStack {
    List<Integer> l;
    int cap;
    public CustomStack(int maxSize) {
        l = new ArrayList<>();
        cap = maxSize;
    }
    
    public void push(int x) {
        if(l.size() < cap){
            l.add(x);
        }
    }
    
    public int pop() {
        if(l.size() == 0) return -1;
        return l.remove(l.size() - 1);
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i<l.size();i++){
            if(k == 0) break;
            k--;
            l.set(i, l.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */