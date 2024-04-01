class Solution {
    public int minDistance(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] prev = new int[n2+1];
        int[] cur = new int[n2+1];
        for(int i =0;i<=n2;i++){
            prev[i] = i;
        }
        for(int i =1;i<=n1;i++){
            cur[0] = i;
            for(int j =1;j<=n2;j++){
                if(c1[i-1] == c2[j-1]){
                    cur[j] = prev[j-1] ;
                }
                else{
                    cur[j] = 1 + Math.min(cur[j-1], Math.min(prev[j],prev[j-1]));
                }
            }
            prev = cur.clone();
        }
        return prev[n2];
    }
}