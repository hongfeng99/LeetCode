import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       int n=s.length();
       int begin=0;
       int end=0;
       Boolean[][]dp=new Boolean[n][n];
       for(int i=0;i<n;i++)
       {
    	   for(int j=i;j<n;j++)
    	   {
    		   if(wordDict.contains(s.substring(i, j+1)))
    		   {
    			   dp[i][j]=true;
    		   }
    		   else
    		   {
    			   dp[i][j]=false;
    		   }
    	   }
       }
       
       for(int len=2;len<=n;len++)
       {
    	   for(int i=0;i<n;i++)
    	   {
    		   int j=i+len-1;
    		   for(int k=i;k<j;k++)
    		   {
    			   if(j<n&&dp[i][k]==true&&dp[k+1][j]==true)
    			   {
    				   dp[i][j]=true;
    			   }
    		   }
    	   }
       }
       return dp[0][n-1];
    }
}