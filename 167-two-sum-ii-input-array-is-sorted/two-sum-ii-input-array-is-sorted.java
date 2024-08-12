class Solution {
    public int[] twoSum(int[] num, int t) {
        int[] ans = new int[2];
        int n = num.length;
        int i = 0;
        int j = n-1;
        while(i < j){
            int a = num[i];
            int b = num[j];
            int sum = a + b;
            if(sum == t){
                ans[0] = i + 1;
                ans[1] = j + 1;
                i++;
                j--;
            }
            else if(sum > t) j--;
            else i++;
        }
        return ans;
    }
}