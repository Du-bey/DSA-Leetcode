class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(nums1, (a, b) -> a[0] - b[0]);
        Arrays.sort(nums2, (a, b) -> a[0] - b[0]);

        while(i < n && j < m){
            if(nums1[i][0] == nums2[j][0]){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i][0]);
                temp.add(nums1[i][1] + nums2[j][1]);
                i++;
                j++;
                ans.add(temp);
            }
            else if(nums1[i][0] < nums2[j][0]){
                List<Integer> temp = Arrays.asList(nums1[i][0], nums1[i][1]);  
                i++;
                ans.add(temp);
            }
            else{
                List<Integer> temp = Arrays.asList(nums2[j][0], nums2[j][1]);
                j++;
                ans.add(temp);
            }
        }
        while(i < n){
            List<Integer> temp = Arrays.asList(nums1[i][0], nums1[i][1]);  
            i++;
            ans.add(temp);
        }
        while(j < m){
            List<Integer> temp = Arrays.asList(nums2[j][0], nums2[j][1]);  
            j++;
            ans.add(temp);
        }

        return ans;
    }
}