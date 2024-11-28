import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    	List<Integer>res=new ArrayList<Integer>();
    	backtrack(ans,res,candidates,0,target,0);
    	return ans;
    }
    
    public void backtrack(List<List<Integer>> ans,List<Integer>res,int[] candidates,int begin,int target,int sum)
    {
    	if(sum==target)
    	{
    		ans.add(new ArrayList<Integer>(res));
    		return;
    	}
    	if(sum>target)
    	{
    		 return;
    	}
    	for(int i=begin;i<candidates.length;i++)
    	{
    		res.add(candidates[i]);
    		sum+=candidates[i];
    		backtrack(ans,res,candidates,i,target,sum);
    		res.remove(res.size()-1);
    		sum-=candidates[i];
    	}
    }
}
