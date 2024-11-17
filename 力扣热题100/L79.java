class Solution {
	
    public boolean exist(char[][] board, String word) {
    	int m=board.length;
    	int n=board[0].length;
    	Boolean[][] isvisited=new Boolean[m][n];
    	for(Boolean a[]:isvisited)
    	{
    		for(int i=0;i<a.length;i++)
    		{
    			a[i]=false;
    		}
    	}
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			if(dfs(board,isvisited,word,i,j,0)==true)
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public Boolean dfs(char[][] board,Boolean[][] isvisited,String word,int x,int y,int begin)
    {
    	int m=board.length;
    	int n=board[0].length;
    	if(begin==word.length())
    	{
    		return true;
    	}
    	if(x<0||x>=m||y<0||y>=n||isvisited[x][y]==true||board[x][y]!=word.charAt(begin))
    	{
    		return false;
    	}
    	
		isvisited[x][y]=true;
		Boolean ans=
		dfs(board,isvisited,word,x-1,y,begin+1)||
		dfs(board,isvisited,word,x+1,y,begin+1)||
		dfs(board,isvisited,word,x,y-1,begin+1)||
		dfs(board,isvisited,word,x,y+1,begin+1);
		isvisited[x][y]=false;

    	return ans;
    }
}




