/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursion(root,p,q);
    }

    private TreeNode recursion(TreeNode root,TreeNode p,TreeNode q){
        //结束条件
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode left=recursion(root.left,p,q);
        TreeNode right=recursion(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}