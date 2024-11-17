package 力扣热题100;

public class L73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] testrow=new boolean[m];
        boolean[] testcol=new boolean[n];
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(matrix[i][j]==0)
        		{
        			testrow[i]=true;
        			testcol[j]=true;
        		}
        	}
        }
        
        for(int i=0;i<m;i++)
        {
        	if(testrow[i]==true)
        	{
        		for(int j=0;j<n;j++)
        		{
        			matrix[i][j]=0;
        		}
        	}
        }
        
        for(int j=0;j<n;j++)
        {
        	if(testcol[j]==true)
        	{
        		for(int i=0;i<m;i++)
        		{
        			matrix[i][j]=0;
        		}
        	}
        }
        
    }
}