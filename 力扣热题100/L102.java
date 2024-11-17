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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null)
        {
        	return ans;
        }
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
        	List<Integer> floor=new ArrayList<Integer>();
            int length=queue.size();
        	for(int i=1;i<=length;i++)
        	{
        		TreeNode a=queue.poll();
        		floor.add(a.val);
        		if(a.left!=null)
        		{
        			queue.offer(a.left);
        		}
        		if(a.right!=null)
        		{
        			queue.offer(a.right);
        		}
        	}
        	ans.add(floor);
        }
        return ans;
    }
}
