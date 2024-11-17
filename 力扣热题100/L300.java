import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
        	return 1;
        }
        int[]dp=new int[n];
        Arrays.fill(dp, 1);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
        	if(nums[i]>nums[i-1])
        	{
        		dp[i]=dp[i-1]+1;
        		ans=Math.max(ans,dp[i]);
        	}
        	if(nums[i]==nums[i-1])
        	{
        		dp[i]=dp[i-1];
        		ans=Math.max(ans,dp[i]);
        	}
        	else
        	{
        		for(int j=0;j<i;j++)
        		{
        			if(nums[i]>nums[j])
        			{
        				dp[i]=Math.max(dp[i], dp[j]+1);
        			}
        			if(nums[i]==nums[j])
        			{
        				dp[i]=dp[j];
        			}
        			ans=Math.max(ans,dp[i]);
        		}
        	}
        }
        return ans;
    }
}

























class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n=nums.length;
    	if(n==0)
    	{
    		return 0;
    	}
    	int[] dp=new int[n];
    	dp[0]=1;
    	for(int i=1;i<n;i++)
    	{
    		dp[i]=1;
    		for(int j=0;j<i;j++)
    		{
    			if(nums[j]<nums[i])
    			{
        			dp[i]=Math.max(dp[i],dp[j]+1);    				
    			}
    		}
    	}
    	Arrays.sort(dp);
    	return dp[n-1];
    }
}
