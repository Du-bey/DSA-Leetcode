class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        int n = a.length;

        int[] ans = new int[n];
        int tot = 0;
        for(int i =0;i<n;i++){
            int x = a[i];
            int y = b[i];
            if(x == y) tot++;
            if(s1.contains(y)) tot++;
            if(s2.contains(x)) tot++;
            ans[i] = tot;
            s1.add(x);
            s2.add(y);
        }
        return ans;
    }
}