class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(nums[0]==0&&n>1)
        {
        	return false;
        }
        if(n==1)
        {
        	return true;
        }
        int maxLen=0;
        int begin=0;
        int nextbegin=0;
        while(maxLen<n-1)
        {
        	for(int i=begin+1;i<n&&i<=begin+nums[begin];i++)
        	{
        		if(i+nums[i]>maxLen)
        		{
        			maxLen=i+nums[i];
        			nextbegin=i;
        		}
        	}
        	if(nextbegin==begin)
        	{
        		return false;
        	}
        	begin=nextbegin;
        }
        return true;
    }
}
