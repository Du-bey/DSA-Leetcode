class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        f(s, 0, ans, cur);
        return ans;
    }

    public void f(String s, int ind, List<List<String>> ans, List<String> temp){
        int n = s.length();
        if(ind == n){
            ans.add(new ArrayList<>(temp));
        }
        for(int i =ind;i<n;i++){
            if(isPalindrome(ind, i, s)){
                temp.add(s.substring(ind, i+1));
                f(s, i+1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int l, int r, String s){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}