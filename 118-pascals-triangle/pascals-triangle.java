class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1;i<=n;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    public List<Integer> generateRow(int r) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int temp = 1;
        for(int i =1;i<r;i++){
            temp *= (r - i);
            temp /= i;
            ans.add(temp);
        }
        return ans;
    }
}