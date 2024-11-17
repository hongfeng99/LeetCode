















class Solution {
    public boolean canPartition(int[] nums) {
          int n=nums.length;
          int sum=0;
          for(int i=0;i<n;i++)
          {
        	  sum+=nums[i];
          }
          if(sum%2==1)
          {
        	  return false;
          }
          int half=sum/2;
          Boolean[][]dp=new Boolean[n][half+1];
          for(int i=0;i<n;i++)
          {
            for(int j=0;j<half+1;j++)
            {
                dp[i][j]=false;
            }
          }
          for(int i=0;i<n;i++)
          {
        	  dp[i][0]=true;
          }
          for(int i=1;i<half+1;i++)
          {
        	  if(i==nums[0])
        	  {
        		  dp[0][i]=true;
        	  }
        	  else
        	  {
        		  dp[0][i]=false;
        	  }
          }
          for(int i=1;i<n;i++)
          {
        	  for(int j=1;j<half+1;j++)
        	  {
        		  if(nums[i]<=j)
        		  {
        			  if(dp[i-1][j]==true||dp[i-1][j-nums[i]]==true)
        			  {
        				  dp[i][j]=true;
        			  }
        		  }
        		  else
        		  {
        			  dp[i][j]=dp[i-1][j];
        		  }
        	  }
          }
          return dp[n-1][half];
    }
    
}