/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        //跟二叉树前中后序遍历不同，这里是层序遍历，即逐层遍历
        //遍历每个节点的同时，将它的下一层节点保存，并保持顺序（先进先出）
        if(root==null){
            return list;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            Queue<Node> tempQueue=new LinkedList<>();
            List<Integer> temp=new ArrayList<>();
            for(Node node:queue){
                temp.add(node.val);
                tempQueue.addAll(node.children);
            }
            queue=tempQueue;
            list.add(temp);
        }
        return list;
    }
}