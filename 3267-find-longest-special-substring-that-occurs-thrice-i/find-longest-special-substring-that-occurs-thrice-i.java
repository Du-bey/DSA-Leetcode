class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> m = new HashMap<>();
        for(int i =0 ;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i;j<n;j++){
                int len = sb.length();
                if(len == 0 || sb.charAt(len - 1) == s.charAt(j)){
                    sb.append(s.charAt(j));
                    String st = sb.toString();
                    m.put(st, m.getOrDefault(st, 0) + 1);
                }
                else break;
            }
        }
        int ans = -1;
        for(String t : m.keySet()){
            if(m.get(t) > 2){
                ans = Math.max(ans, t.length());
            }
        }
        return ans;
    }
}