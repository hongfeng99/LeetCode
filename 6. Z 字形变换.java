//第一次做用的方法
class Solution {
    public String convert(String s, int numRows) {
    	int n=s.length();
    	int r=numRows;
    	if(r==1||r>=n)
    	{
    		return s;
    	}
    	int t=2*(r-1);
    	int c=(n+t-1)/t*(t-1);/////////////////
    	int x=0,y=0;
    	char[][] arr=new char[r][c];
    	for(int i=0;i<n;i++)
    	{
    		if((i%(2*r-2)<r-1))
    		{
    			arr[x][y]=s.charAt(i);
    			x++;
    		}
    		else
    		{
    			arr[x][y]=s.charAt(i);
    			x--;
    			y++;
    		}
    	}
    	StringBuffer str=new StringBuffer();
    	for(char[] row:arr)
    	{
    		for(char pp:row)
    		{
    			if(pp!=0)
    			{
    				str.append(pp);
    			}
    		}
    	}
    	return str.toString();
    }
}
