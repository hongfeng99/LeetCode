//纯数学方法
class Solution {
    public int uniquePaths(int m, int n) {
        return (int)func(Math.min(m, n)-1,m+n-2);
    }
    
    public long func(int k,int n)
    {
    	long i=1;
    	long j=1;
    	int count=1;
    	while(count<=k)
    	{
    		i*=n-count+1;
    		j*=count;
    		count++;
    		if(i%j==0)
    		{
    			i/=j;
    			j=1;
    		}
    	}
    	return i/j;
    }
}
////////////动态规划方法
class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++)
        {
        	dp[i][0]=1;
        }
        for(int j=0;j<n;j++)
        {
        	dp[0][j]=1;
        }
        for(int i=1;i<m;i++)
        {
        	for(int j=1;j<n;j++)
        	{
        		dp[i][j]=dp[i-1][j]+dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
}
