class Solution {
    public int[][] generateMatrix(int n) {
        int[][]matrix=new int[n][n];
        boolean[][]dp=new boolean[n][n];
        int num=1;
        int x=0;
        int y=0;
        matrix[0][0]=1;
        dp[0][0]=true;
        while(num<n*n)
        {
        	while(y+1<n&&dp[x][y+1]==false)
        	{
        		y++;
        		dp[x][y]=true;
        		num++;
        		matrix[x][y]=num;        		
        	}
        	while(x+1<n&&dp[x+1][y]==false)
        	{
        		x++;
        		dp[x][y]=true;
        		num++;
        		matrix[x][y]=num;
        	}
        	while(y-1>=0&&dp[x][y-1]==false)
        	{
        		y--;
        		dp[x][y]=true;
        		num++;
        		matrix[x][y]=num;        		
        	}
        	while(x-1>=0&&dp[x-1][y]==false)
        	{
        		x--;
        		dp[x][y]=true;
        		num++;
        		matrix[x][y]=num;
        	}
        }
        return matrix;
    }
}
