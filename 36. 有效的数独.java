import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Boolean [][]existrow=new Boolean[9][9];
        Boolean [][]existcol=new Boolean[9][9];
        for(Boolean a[]:existrow)
        {
        	for(int i=0;i<9;i++)
        	{
        		a[i]=false;
        	}
        }
        for(Boolean a[]:existcol)
        {
        	for(int i=0;i<9;i++)
        	{
        		a[i]=false;
        	}
        }
        for(int i=0;i<9;i++)
        {
        	for(int j=0;j<9;j++)
        	{
        		if(board[i][j]=='.')
        		{
        			continue;
        		}
        		char a=board[i][j];
        		if(existrow[i][a-'0'-1]==true)
        		{
        			return false;
        		}
        		existrow[i][a-'0'-1]=true;
        	}
        }
        
        for(int i=0;i<9;i++)
        {
        	for(int j=0;j<9;j++)
        	{
        		if(board[j][i]=='.')
        		{
        			continue;
        		}
        		char a=board[j][i];
        		if(existcol[a-'0'-1][i]==true)
        		{
        			return false;
        		}
        		existcol[a-'0'-1][i]=true;
        	}
        }
        for(int i=0;i<9;i+=3)
        {
        	for(int j=0;j<9;j+=3)
        	{
        		Set<Character>set=new HashSet<>();
        		for(int row=i+0;row<i+3;row++)
        		{
        			for(int col=j+0;col<j+3;col++)
        			{
        				if(set.contains(board[row][col]))
        				{
        					return false;
        				}
        				if(board[row][col]!='.')
        				{
        					set.add(board[row][col]);	
        				}
        				
        			}
        		}
        	}
        }
        return true;
    }
}
