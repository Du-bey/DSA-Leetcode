class ProductOfNumbers {
    List<Integer> l;
    public ProductOfNumbers() {
        l = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) l.clear();
        else{
            int x = 0;
            if(l.isEmpty()){
                x = num;
            }
            else{
                x = num * l.get(l.size() - 1);
            }
            l.add(x);
        }
    }
    
    public int getProduct(int k) {
        int n = l.size();
        if(k > n) return 0;
        if(k == n) return l.get(n-1);
        return (l.get(n-1) / l.get(n - k - 1));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */