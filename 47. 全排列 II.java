import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        boolean[]dp=new boolean[nums.length];
        Arrays.fill(dp, false);
        backtrack(ans,res,nums,0,dp);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans,List<Integer>res,int[]nums,int begin,boolean[]dp)
    {
    	if(begin==nums.length)
    	{
    		ans.add(new ArrayList<Integer>(res));
    	}
    	for(int i=0;i<nums.length;i++)
    	{
    		if(dp[i]==true||i>0&&dp[i-1]==false&&nums[i-1]==nums[i])
    		{
    			continue;
    		}
    		res.add(nums[i]);
    		dp[i]=true;
    		backtrack(ans,res,nums,begin+1,dp);
    		res.remove(res.size()-1);
    		dp[i]=false;
    	}
    }
}
