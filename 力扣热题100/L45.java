











class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++)
        {
        	if(dp[i]==Integer.MAX_VALUE)
        	{
        		continue;
        	}
        	int dist=nums[i];
        	for(int j=i+1;j<=i+dist&&j<n;j++)
        	{
        		dp[j]=Math.min(dp[j], dp[i]+1);
        	}
        }
        return dp[n-1];
    }
}


































class Solution {
    public int jump(int[] nums) {
    	int end=0;
    	int disTance = 0;
    	int step=0;
    	int len=nums.length-1;
    	for(int i=0;i<len;i++)
    	{
    		disTance=Math.max(disTance,nums[i]+i);
    		if(i==end)
    		{
    			end=disTance; 
    			step++;
    		}
    	}
    	return step;
    }
}