class NumArray {
    int[] segTree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildTree(0, 0, n-1, nums);
    }

    private void buildTree(int i, int l, int r, int[] nums){
        if(l == r){
            segTree[i] = nums[l];
            return;
        }
        int mid = (l+r) / 2;
        int left = 2*i + 1;
        int right = 2*i + 2;
        buildTree(left, l, mid, nums);
        buildTree(right, mid + 1, r, nums);
        segTree[i] = segTree[left] + segTree[right];
    }
    
    public void update(int index, int val) {
        updateQuery(index, val, 0, 0, n-1);
    }

    public void updateQuery(int ind, int val, int i, int l, int r){
        if(l == r){
            segTree[i] = val;
            return;
        }
        int mid = (l+r) / 2;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(ind <= mid) updateQuery(ind, val, left, l, mid);
        else updateQuery(ind, val, right, mid + 1, r);
        segTree[i] = segTree[left] + segTree[right];
    }
    
    public int sumRange(int left, int right) {
        return sumQuery(left, right, 0, 0, n-1);
    }

    public int sumQuery(int start, int end, int i, int l, int r){
        if(l > end || r < start) return 0;
        if(l >= start && r <= end) return segTree[i];
        int mid = (l+r) / 2;
        int left = 2*i + 1;
        int right = 2*i + 2;
        return sumQuery(start, end, left, l, mid) +
                sumQuery(start, end, right, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */