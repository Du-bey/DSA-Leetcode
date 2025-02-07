class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int size = n + m;
        int i = 0, j = 0, k = 0;
        int id1 = size/2;
        int id2 = (size - 1) / 2;
        int el1 = 0, el2 = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                if(k == id1) el1 = nums1[i];
                if(k == id2) el2 = nums1[i];
                i++;
            }
            else{
                if(k == id1) el1 = nums2[j];
                if(k == id2) el2 = nums2[j];
                j++;
            }
            k++;
        }
        while(i < n){
            if(k == id1) el1 = nums1[i];
            if(k == id2) el2 = nums1[i];
            i++;
            k++;
        }
        while(j < m){
            if(k == id1) el1 = nums2[j];
            if(k == id2) el2 = nums2[j];
            j++;
            k++;
        }
        
        double ans = 0;
        if(size % 2 == 1){
            ans = el1;
        }
        else{
            ans = (el1 + el2) / 2.0;
        }
        return ans;
    }
}