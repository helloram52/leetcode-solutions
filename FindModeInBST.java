//501. Find Mode in Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindModeInBST {
    
    int max=-1;
    public int[] findMode(TreeNode root) {
        
        List<Integer> mode=new ArrayList<>();
        
        Integer[] prev=new Integer[1];
        int[] count=new int[1];
        count[0]=0;
        prev[0]=null;
        
        findModeUtil(root, mode, prev, count);
        
        int[] result=new int[mode.size()];
        
        for(int i=0; i<mode.size(); i++) {
            result[i]=mode.get(i);
        }
        
        return result;
    }
    
    void findModeUtil(TreeNode root, List<Integer> mode, Integer[] prev, int[] count) {
        
        if(root == null) {
            return;
        }
        
        findModeUtil(root.left, mode, prev, count);
        
        //if duplicate element found
        if(prev[0] != null) {
            if(prev[0] == root.val) {
                count[0]++;
            }
            else {
                count[0]=1;
            }
        }
        else {
            count[0]=1;
        }
        
        if(count[0] > max) {
            mode.clear();
            mode.add(root.val);
            max=count[0];
        }
        else if(count[0] == max) {
            mode.add(root.val);
        }
        
        prev[0]=root.val;
        
        findModeUtil(root.right, mode, prev, count);
    }
}
