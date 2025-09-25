class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if((long)n * (long)d < 0) sb.append("-");

        long absn = Math.abs((long)n);
        long absd = Math.abs((long)d);

        long id = absn / absd;
        sb.append(id);

        long rem = absn % absd;
        if(rem == 0) return sb.toString();

        sb.append(".");

        Map<Long, Integer> h = new HashMap<>();
        while(rem != 0){
            if(h.containsKey(rem)){
                int ip = h.get(rem);
                sb.insert(ip, "(");
                sb.append(")");
                break;
            }
            h.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / absd);
            rem %= absd;
        }

        return sb.toString();
    }
}