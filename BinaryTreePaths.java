//257. Binary Tree Paths

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result= new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        if(root.left == null && root.right == null) {
            result.add(""+root.val);
            return result;
        }
        
        List<String> left=null;
        
        if(root.left != null) {
            left=binaryTreePaths(root.left);
        }
        
        List<String> right=null;
        
        if(root.right != null) {
            right=binaryTreePaths(root.right);
        }
        
        if(left != null || right != null) {
            
            if(left != null) {
                
                for(String child:left) {
                    result.add(root.val+"->"+child);
                }
            }
            
            
            if(right != null) {
                
                for(String child:right) {
                    result.add(root.val+"->"+child);
                }
            }
        }
        
        return result;
    }
    
}
