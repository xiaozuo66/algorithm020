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
    //优化
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //自顶向下编程
        return appendChild(0,preorder.length,preorder,0,inorder.length,inorder);
    }

    private TreeNode appendChild(int preStart,int preEnd,int[] preorder, int inStart,int inEnd,int[] inorder){
        //其实就是给定一个节点，追加左右节点即可
        //如果左右节点都找不到，就退出循环
        if(preStart==preEnd){
            return null;
        }
        //前序遍历第一个节点就是根节点，即preStart
        TreeNode root=new TreeNode(preorder[preStart]);
        //找到中序遍历中该根节点所处位置，用于划分出左、右子树
        int rootIndex=map.get(preorder[preStart]);
        //下沉到下一层
        root.left=appendChild(preStart+1,preStart+rootIndex-inStart+1,preorder,inStart,rootIndex,inorder);
        root.right=appendChild(preStart+rootIndex-inStart+1,preEnd,preorder,rootIndex+1,inEnd,inorder);
        return root;
    }
}