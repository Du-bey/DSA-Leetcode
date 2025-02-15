class ProductOfNumbers {
    List<Integer> l;
    public ProductOfNumbers() {
        l = new ArrayList<>();
    }
    
    public void add(int num) {
        l.add(num);
    }
    
    public int getProduct(int k) {
        int ans = 1;
        int size = l.size();
        for(int i = size - 1; i>=0 && k > 0;i--){
            k--;
            ans *= l.get(i);
            if(ans == 0) return 0;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */