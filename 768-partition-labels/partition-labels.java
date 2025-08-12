class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            h.put(c, i);
        }

        int i = 0;
        int j = h.get(s.charAt(i));
        int cnt = 0;
        while(i < n){
            char ch = s.charAt(i);
            j = Math.max(j, h.get(ch));
            i++;
            cnt++;
            if(i > j){
                ans.add(cnt);
                cnt = 0;
            }
        }
        return ans;
    }
}