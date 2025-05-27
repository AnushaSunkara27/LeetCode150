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
    List<Integer> elements = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = inOrder(root);

        if(elements.size() == 0) return 0;

        return elements.get(k-1);
    }

    public List<Integer> inOrder(TreeNode root) {
        
        if(root == null)
            return elements;

        inOrder(root.left);
        elements.add(root.val);
        inOrder(root.right);

        return elements;
    }
}