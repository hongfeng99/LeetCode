package 力扣热题100;

public class L94 {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        test(root,ans);
        return ans;
    }	
    
    public static void test(TreeNode root,List<Integer> ans)
    {
    	if(root==null)
    	{
    		return;
    	}
    	test(root.left, ans);
    	ans.add(root.val);    	
    	test(root.right,ans);    	    
    }
}