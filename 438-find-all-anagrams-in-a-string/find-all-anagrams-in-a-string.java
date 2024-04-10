class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n < m) return ans;
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i =0;i<m;i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch,0) + 1);
        }

        for(int i =0;i<m;i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0) + 1);
        }

        int i = 0;
    
        
        for(int j = m;j <n;j++){
            if(smap.equals(pmap)) ans.add(i);
            char cj = s.charAt(j);
            char ci = s.charAt(i);
            smap.put(cj, smap.getOrDefault(cj,0) + 1);
            if(smap.get(ci) == 1){
                smap.remove(ci);
            }
            else{
                smap.put(ci, smap.get(ci) - 1);
            }
            i++;
        }
        if(smap.equals(pmap)) ans.add(i);
        return ans;
    }
}