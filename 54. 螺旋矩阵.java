import java.util.List;
//注意最后一个元素不要漏掉了
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer>ans=new ArrayList<>();
        boolean[][] isused=new boolean[m][n];
        int count=0;
        int x=0;
        int y=0;
        while(count<m*n)
        {
        	while(y+1<n&&isused[x][y+1]==false)
        	{
        		ans.add(matrix[x][y]);
        		isused[x][y]=true;
        		y++;
        		count++;
        	}
        	while(x+1<m&&isused[x+1][y]==false)
        	{
        		ans.add(matrix[x][y]);
        		isused[x][y]=true;
        		x++;
        		count++;
        	}
        	while(y-1>=0&&isused[x][y-1]==false)
        	{
        		ans.add(matrix[x][y]);
        		isused[x][y]=true;
        		y--;
        		count++;
        	}
        	while(x-1>=0&&isused[x-1][y]==false)
        	{
        		ans.add(matrix[x][y]);
        		isused[x][y]=true;
        		x--;
        		count++;
        	}
        	if(count==m*n-1)
        	{
        		ans.add(matrix[x][y]);
        		count++;
        	}
        }
        return ans;
    }
}
