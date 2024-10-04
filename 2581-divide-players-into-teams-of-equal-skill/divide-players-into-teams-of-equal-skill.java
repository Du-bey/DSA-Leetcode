class Solution {
    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int tot = 0;
        for(int x : skill){
            tot += x;
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        int n = skill.length;
        tot *= 2;
        if((tot) % n != 0) return -1;
        int sum = tot / n;
        
        long ans = 0;
        for(int x : skill){
            if(h.get(x) > 0){
                int oth = sum - x;
                if(!h.containsKey(oth) || h.get(oth) < 1) return -1;
                ans += x * oth;
                h.put(x, h.get(x) - 1);
                h.put(oth, h.get(oth) - 1);
            }
        }
        return ans;
    }
}

