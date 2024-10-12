import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);
        TreeNode startNode = search(root, start);
        
        Map<TreeNode, Boolean> visited = new HashMap<>();
        return bfsInfection(startNode, visited, parentMap);
    }

    public TreeNode search(TreeNode root, int start) {
        if (root == null || root.val == start) return root;
        TreeNode left = search(root.left, start);
        if (left != null) return left;
        return search(root.right, start);
    }

    public int bfsInfection(TreeNode startNode, Map<TreeNode, Boolean> visited, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        visited.put(startNode, true);
        
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisLevel = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null && !visited.getOrDefault(node.left, false)) {
                    queue.add(node.left);
                    visited.put(node.left, true);
                    infectedThisLevel = true;
                }
                
                if (node.right != null && !visited.getOrDefault(node.right, false)) {
                    queue.add(node.right);
                    visited.put(node.right, true);
                    infectedThisLevel = true;
                }
                
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.getOrDefault(parent, false)) {
                    queue.add(parent);
                    visited.put(parent, true);
                    infectedThisLevel = true;
                }
            }

            if (infectedThisLevel) {
                time++;
            }
        }

        return time;
    }

    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left, root);
            markParent(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            markParent(root.right, parentMap);
        }
    }
}
