class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        h.put('I', 1);
        h.put('V', 5);
        h.put('X', 10);
        h.put('L', 50);
        h.put('C', 100);
        h.put('D', 500);
        h.put('M', 1000);
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(i+1 < n && h.get(c) < h.get(s.charAt(i+1))){
                ans -= h.get(c);
            }
            else{
                ans += h.get(c);
            }
        }
        return ans;
    }
}