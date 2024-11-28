class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int []res=new int[n+2];
        for(int i=0;i<n;i++)
        {
        	if(1<=nums[i]&&nums[i]<=n+1)
        	{
        		res[nums[i]]=1;
        	}
        }
        for(int i=1;i<=n+1;i++)
        {
        	if(res[i]==0)
        	{
        		return i;
        	}
        }
        return -1;
    }
}
