import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        backtrack(ans,res,nums);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans,List<Integer>res,int[]nums)
    {
    	if(res.size()==nums.length)
    	{
    		ans.add(new ArrayList<Integer>(res));
    	}
    	for(int i=0;i<nums.length;i++)
    	{
    		if(res.contains(nums[i]))
    		{
    			continue;
    		}
    		res.add(nums[i]);
    		backtrack(ans,res,nums);
    		res.remove(res.size()-1);
    	}
    }
}
