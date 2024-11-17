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
	int maxLen=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    	test(root);
        return maxLen;

    }
    
	public int test(TreeNode root)
    {
    	
    	if(root ==null)
        {
        	return 0;
        }
        int L=test(root.left);
        int R=test(root.right);
        maxLen=Math.max(maxLen, L+R);
        return Math.max(L, R)+1;
    }
}
///////////////////////



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
	
    public int diameterOfBinaryTree(TreeNode root) {
    	int[] maxLen=new int[1];
    	maxLen[0]=Integer.MIN_VALUE; 
    	test(root,maxLen);
        return maxLen[0];

    }
    
	public int test(TreeNode root,int maxLen[])
    {   	
    	if(root ==null)
        {
        	return 0;
        }
        int L=test(root.left,maxLen);
        int R=test(root.right,maxLen);
        maxLen[0]=Math.max(maxLen[0], L+R);
        return Math.max(L, R)+1;
    }
}