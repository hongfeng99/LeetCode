class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		dp[i][j]=matrix[i][j];
        	}
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		matrix[j][n-i-1]=dp[i][j];
        	}
        }
        
    }
}
