class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int a =0, b=0, c= 0;
        List<Integer> table = new ArrayList<>();
        table.add(1);
        while(table.size() < n){
           int next = Math.min(table.get(a)*2, Math.min(table.get(b)*3 , table.get(c)*5));
           table.add(next);
           if(table.get(a)*2 == next) a++;
           if(table.get(b)*3 == next) b++;
           if(table.get(c)*5 == next) c++;
        }
        return table.get(table.size() - 1);
    }
}