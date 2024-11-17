package 力扣热题100;

public class L104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

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
    public int maxDepth(TreeNode root) {
        return maxdep(root,0);
        
    }
    public int maxdep(TreeNode root,int depth)
    {
    	if(root=null)
    	{
    		return depth;
    	}
    	return Math.max(maxdep(root.left,depth+1), maxdep(root.right,depth+1));
    }
}



















