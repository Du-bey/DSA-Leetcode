class Fancy {
    List<Long> l;
    long add;
    long mul;
    long mod = 1_000_000_007;
    public Fancy() {
        l = new ArrayList<>();
        add = 0;
        mul = 1;
    }
    
    public void append(int val) {
        long x = ((val - add) % mod + mod) * power(mul, mod - 2) % mod; 
        l.add(x);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % mod;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= l.size()) return -1;
        long num = l.get(idx);
        num = (num * mul) % mod;
        num = (num + add) % mod;
        return (int) ((l.get(idx) * mul + add) % mod);
    }

    long power(long a, long b) {
        if (b == 0)
            return 1;

        long half   = power(a, b / 2);
        long result = (half * half) % mod;

        if (b % 2 == 1) {
            result = (result * a) % mod;
        }

        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */