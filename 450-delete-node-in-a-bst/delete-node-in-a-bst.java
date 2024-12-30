class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);

        TreeNode temp = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                root = root.left;
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                root = root.right;
            }
        }
        return temp;
    }

    public TreeNode helper(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        TreeNode rightChild = root.right;
        TreeNode rightLast = last(root.left);
        rightLast.right = rightChild;
        return root.left;
    }

    public TreeNode last(TreeNode root){
        while(root.right != null) root = root.right;
        return root;
    }

}