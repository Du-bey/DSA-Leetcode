class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] temp = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            }
            else{
                temp[k++] = nums2[j++];
            }
        }
        while(i < n){
            temp[k++] = nums1[i++];
        }
        while(j < m){
            temp[k++] = nums2[j++];
        }
        int size = n + m;
        double ans = 0;
        if(size % 2 == 1){
            ans = temp[size/2];
        }
        else{
            ans = (temp[size/2] + temp[(size - 1) /2]) / 2.0;
        }
        return ans;
    }
}