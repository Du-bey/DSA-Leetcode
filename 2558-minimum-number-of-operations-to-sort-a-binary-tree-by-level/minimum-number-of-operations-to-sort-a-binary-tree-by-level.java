class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int[] arr = new int[size];
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                arr[i] = node.val;
            }
            ans += solve(arr, size);
        }
        return ans;
    }

    public int solve(int[] arr, int n){
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            h.put(arr[i], i);
        }
        int ans = 0;
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        for(int i =0;i<n;i++){
            int val = sorted[i];
            if(arr[i] != val){
                int ind = h.get(val);
                int temp = arr[i];
                arr[i] = val;
                arr[ind] = temp;
                h.put(temp, ind);
                ans++;
            }
        }
        return ans;
    }
}