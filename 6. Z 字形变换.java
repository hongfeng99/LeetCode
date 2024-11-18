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
//重新做用的方法，图形化Z字形，把每一个的横纵坐标位置都用数学方法找到
package 力扣超级版本;

class Solution {
    public String convert(String s, int numRows) {
        int num=s.length();
        int m=numRows;
        if(m==1)
        {
            return s;
        }
        int count=num/(2*m-2)+1;//全部的组数
        int n=count*(m-1);
        char[][] dp=new char[m][n];
        for(int i=0;i<num;i++)
        {
        	int x=0;
        	int y=0;
        	int rank0=(i/(2*m-2)); //rank0是第几组
        	int rank1=(i%(2*m-2)); //rank1是组内的次序
        	if(rank1<m)
        	{
        		y=(m-1)*rank0;
        		x=rank1;
        	}
        	else
        	{
        		x=2*m-rank1-2;
        		y=(m-1)*rank0+rank1-m+1;
        	}
        	dp[x][y]=s.charAt(i);
        }
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(dp[i][j]!='\0')
        		{
        			ans.append(dp[i][j]);
        		}
        	}
        }
        return ans.toString();
    }
}
