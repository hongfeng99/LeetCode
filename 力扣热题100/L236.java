import java.util.List;

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
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<TreeNode>res=new ArrayList<>();//层序遍历
        func(root,res);
        int sitep=0;
        int siteq=0;
        while(res.get(sitep)!=p)
        {
        	sitep++;//找到p的次序
        }
        while(res.get(siteq)!=q)
        {
        	siteq++;//找到q的次序
        }
        
        list1.add(sitep);
        list2.add(siteq);
        while(sitep!=0)//从二叉树中p位置开始向祖先遍历到根节点，并依次记录在List1
        {
        	if(sitep%2==1)
        	{
        		sitep--;
        		sitep/=2;
        	}
        	
        	else
        	{
        		sitep-=2;
        		sitep/=2;
        	}
        	
        	list1.add(sitep);
        }
        
        while(siteq!=0)//从二叉树中p位置开始向祖先遍历到根节点，并依次记录在List2
        {
        	if(siteq%2==1)
        	{
        		siteq--;
        		siteq/=2;
        	}
        	
        	else
        	{
        		siteq-=2;
        		siteq/=2;
        	}
        	
        	list2.add(siteq);
        }
        
        int site=test(list1,list2);
        return res.get(site);
        
    }
    
    public void func(TreeNode root,List<TreeNode> res)
    {
    	Deque<TreeNode> deque=new LinkedList<>();
    	deque.offer(root);
    	while(!root.isEmpty())
    	{
    		int len=deque.size();
    		for(int i=0;i<len;i++)
    		{
    			deque.offer(deque.get(i).left);
    			deque.offer(deque.get(i).right);
    			res.add(deque.get(i));
    			deque.poll();
    		}
    	}
    }
    
    //编写一个辅助函数，用于查找两个列表中，出现的第一个相同的数字,返回它在list1中的次序
    public int test(List<Integer> list1,List<Integer> list2)
    {
    	int n1=list1.size();
    	int n2=list2.size();    	
    	for(int i=0;i<n1;i++)
    	{
    		for(int j=0;j<n2;j++)
    		{
    			if(list1.get(i)==list2.get(j))
    			{
    				return i;
    			}
    		}
    	}
    	
    	
    }
}