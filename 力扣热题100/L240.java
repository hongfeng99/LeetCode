package 力扣热题100;

public class L240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int row=0;
    	int col=n-1;
    	while(row<m&&col>=0)
    	{
    		if(target==matrix[row][col])
    		{
    			return true;
    		}
    		if(target>matrix[row][col])
    		{
    			row++;
    		}
    		else
    		{
    			col--;
    		}
    	}
    	return false;
    	
    }
}


