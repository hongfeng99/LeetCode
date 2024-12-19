class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans=new ArrayList<List<String>>();
        ans=solveNQueens(n);
        return ans.size();
    }
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> ans=new ArrayList<List<String>>();    	
        char[][] matrix=new char[n][n];
        for(char[] a:matrix)   //全体初始化
        {
        	Arrays.fill(a, '.');
        }
        backtrack(ans,matrix,0);
        return ans;
    }
    
    public void backtrack(List<List<String>> ans,char[][] matrix,int row)
    {
    	if(row==matrix.length) //如果已经把最后一行的皇后填好了，那么结果增加一种
    	{
    		ans.add(construct(matrix));  
    		return;
    	}
    	for(int i=0;i<matrix[0].length;i++)
    	{
    		if(matrix[row][i]=='.'&&test(matrix,row,i)==true)//如果皇后可以放在这个格子就放下，然后回溯处理下一行
    		{
    			matrix[row][i]='Q';
    			backtrack(ans,matrix,row+1);
    			matrix[row][i]='.';
    		}
    	}
    }
    
    public List<String> construct(char[][]matrix)
    {
    	List<String> ans=new ArrayList<String>();
    	for(int i=0;i<matrix.length;i++)
    	{
    		StringBuffer res=new StringBuffer();
    		for(int j=0;j<matrix[0].length;j++)
    		{
    			res.append(matrix[i][j]);
    		}
    		ans.add(res.toString());
    	}
    	return ans;
    }
    
    public boolean test(char[][]matrix,int x,int y)
    {
    	for(int i=0;i<matrix.length;i++)
    	{
    		if(matrix[i][y]=='Q')
    		{
    			return false;
    		}
    	}
    	for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--)
    	{
    		if(matrix[i][j]=='Q')
    		{
    			return false;
    		}
    	}
    	for(int i=x-1,j=y+1;i>=0&&j<matrix[0].length;i--,j++)
    	{
    		if(matrix[i][j]=='Q')
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
