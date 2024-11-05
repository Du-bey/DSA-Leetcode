class Solution {
    public int beautySum(String s) {
        int length = s.length();
        int ans = 0;

        for (int i = 0; i < length; i++) {
            int [] freq=new int [26];
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int max = -1;
                int min = 501;
                for(int k =0;k<26;k++){
                    if(freq[k]>0){
                        min=Math.min(min,freq[k]);
                        max=Math.max(max,freq[k]);
                    }
                }
                ans += (max - min);
            }
        }
        return ans;
    }
}