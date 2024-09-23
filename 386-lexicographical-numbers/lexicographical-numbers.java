class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        for(int j =1;j<=n;j++){
            ans.add(i);
            if(i * 10 <= n){
                i = i*10;
            }
            else{
                while(i % 10 == 9 || i == n){
                    i /= 10;
                }
                i++;
            }
        }
        return ans;
    }
}