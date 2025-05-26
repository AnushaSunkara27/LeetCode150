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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != 
        postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder,
    int preStart, int preEnd,HashMap<Integer,Integer> hm){
        if (preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(postorder[preEnd]);
        int numsLeft = hm.get(postorder[preEnd]);
        TreeNode leftchild = buildTreePostIn(inorder, inStart, numsLeft-1, postorder, preStart,
        preStart+numsLeft-inStart-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,numsLeft+1, inEnd, postorder, 
        preStart+numsLeft-inStart, preEnd-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

}