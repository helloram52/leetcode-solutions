//99. Recover Binary Search Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        
        TreeNode[] nodes={null,null,null,null};
        TreeNode[] prev = {null};
        
        inorder(root, nodes, prev);
        
        if(nodes[2] == null && nodes[3] == null) {
            int temp=nodes[0].val;
            nodes[0].val = nodes[1].val;
            nodes[1].val=temp;
        }
        else {
            int temp=nodes[0].val;
            nodes[0].val = nodes[3].val;
            nodes[3].val=temp;
        }
        
        return;
    }
    
    public void inorder(TreeNode root, TreeNode[] nodes, TreeNode[] prev) {
        
        if(root == null) {
            return;
        }
        
        inorder(root.left, nodes, prev);

        //curr node
        if( prev[0] != null && prev[0].val <= root.val) {

        }
        else if( prev[0] != null ) {
            
            if(nodes[0] == null && nodes[1] == null) {
                nodes[0]=prev[0];
                nodes[1]=root;
            }
            else if( nodes[2] == null && nodes[3] == null) {
                nodes[2]=prev[0];
                nodes[3]=root;
            }
            
        }
        
        prev[0]=root;
        
        inorder(root.right, nodes, prev);
    }
}
