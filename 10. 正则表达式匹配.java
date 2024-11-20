class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        Boolean[][]dp=new Boolean[m+1][n+1];
        for(Boolean a[]:dp)
        {
        	for(int i=0;i<a.length;i++)
        	{
        		a[i]=false;
        	}
        }
        dp[0][0]=true;
        for(int i=1;i<=n;i++)
        {
        	if(p.charAt(i-1)=='*')
        	dp[0][i]=dp[0][i-2];
        }
        for(int i=1;i<=m;i++)
        {
        	for(int j=1;j<=n;j++)
        	{
        		if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')
        		{
        			dp[i][j]=dp[i-1][j-1];
        		}
        		else
        		{
        			if(p.charAt(j-1)=='*')
        			{
        				if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')
        				{
        					dp[i][j]=dp[i][j-2]||dp[i-1][j];
        				}
        				else
        				{
        					dp[i][j]=dp[i][j-2];
        				}
        			}
        		}
        	}
        }
        return dp[m][n];
    }
}
