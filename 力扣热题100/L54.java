package 力扣热题100;

import java.util.List;

public class L54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}




class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	int m=matrix.length;
    	int n=matrix[0].length;
        if(m==0||matrix==null)
        {
            return new ArrayList<Integer>();
        }
    	Boolean[][] dp=new Boolean[m][n];
        for(Boolean a[]:dp)
        {
            for(int i=0;i<n;i++)
            {
                a[i]=false;
            }
        }
    	int row=0;
    	int col=0;
    	int count=0;
    	List<Integer> ans=new ArrayList<>();
    	ans.add(matrix[row][col]);
		dp[row][col]=true;
		count++;
    	while(count<m*n)
    	{    		
    		while(col+1<n&&dp[row][col+1]==false)
    		{
    			col++;
    			ans.add(matrix[row][col]);
    			dp[row][col]=true;
    			count++;
    		}
    		
    		while(row+1<m&&dp[row+1][col]==false)
    		{
    			row++;
    			ans.add(matrix[row][col]);
    			dp[row][col]=true;
    			count++;
    		}
    		
    		while(col-1>=0&&dp[row][col-1]==false)
    		{
    			col--;
    			ans.add(matrix[row][col]);
    			dp[row][col]=true;
    			count++;
    		}
    		
    		while(0<=row-1&&dp[row-1][col]==false)
    		{
    			row--;
    			ans.add(matrix[row][col]);
    			dp[row][col]=true;
    			count++;
    		}
    	}
    	return ans;
    }
}



