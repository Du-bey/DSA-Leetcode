class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for(int i =0;i<n;i++){
            char c = nums[i].charAt(i) == '0' ? '1' : '0';
            sb.append(c);
        }
        return sb.toString();
    }
}