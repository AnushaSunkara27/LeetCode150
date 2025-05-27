/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> preorderList = new ArrayList<>();
        preOrderTraversal(root, preorderList);

        // Re-link nodes based on preorder list
        for (int i = 0; i < preorderList.size() - 1; i++) {
            TreeNode current = preorderList.get(i);
            TreeNode next = preorderList.get(i + 1);
            current.left = null;
            current.right = next;
        }
    }

    private void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        list.add(root);  // Visit root
        preOrderTraversal(root.left, list);  // Visit left
        preOrderTraversal(root.right, list); // Visit right
    }
}