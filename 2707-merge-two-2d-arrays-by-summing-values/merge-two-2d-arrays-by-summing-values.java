class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m){
            if(nums1[i][0] == nums2[j][0]){
                int[] temp = new int[2];
                temp[0] = nums1[i][0];
                temp[1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
                ans.add(temp);
            }
            else if(nums1[i][0] < nums2[j][0]){
                ans.add(nums1[i++]);
            }
            else{
                ans.add(nums2[j++]);
            }
        }
        while(i < n){
            ans.add(nums1[i++]);
        }
        while(j < m){
            ans.add(nums2[j++]);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}