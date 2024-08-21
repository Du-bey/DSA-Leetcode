class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        f(0, n-1, nums);
        return nums; 
    }

    public void f(int l, int h, int[] nums){
        if(l>=h) return;
        int mid = (l + h)/2;
        f(l, mid, nums);
        f(mid+1, h, nums);
        merge(nums, l, mid, h);
    }

    public void merge(int[] nums, int l, int mid, int h){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l;
        int right = mid+1;
        int i = 0;
        while(left <= mid && right <= h){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= h){
            temp.add(nums[right]);
            right++;
        }
        for(int id =l;id<=h;id++){
            nums[id] = temp.get(id-l);
        }
    }
}
