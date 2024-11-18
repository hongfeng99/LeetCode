//以下是质朴且笨拙的方法
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=Integer.MIN_VALUE;
        int begin=0;
        int end=0;
        for(int i=1;i<n;i++)
        {      	
        	if(i<n-1&&s.charAt(i-1)==s.charAt(i+1))
        	{
        		int len=1;
            	while(0<=i-len&&i+len<n&&s.charAt(i-len)==s.charAt(i+len))
            	{
            		len++;
            	}
            	if(len*2+1-2>maxLen)
            	{
            		begin=i-len+1;
            		end=i+len;
            		maxLen=len*2+1-2;
            	}	
        	}
        	if(i>0&&s.charAt(i)==s.charAt(i-1))
        	{
        		int len=1;
        		while(i-1-len>=0&&i+len<n&&s.charAt(i-1-len)==s.charAt(i+len))
        		{
        			len++;
        		}
        		if(2*len>maxLen)
        		{
        			begin=i-1-len+1;
        			end=i+len;
        			maxLen=2*len;
        		}
        	}
        	
        }
        if(begin==end)
        {
        	return (""+s.charAt(0));
        }
        return s.substring(begin, end);
    }
   
}
//以下是递归的方法

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0)
        {
        	return new String();
        }
        Boolean [][]dp=new Boolean[n][n];
        int maxLen=1;
        int begin=0;
        int end=0;
        for(Boolean a[]:dp)
        {
        	for(int i=0;i<n;i++)
        	{
        		a[i]=false;
        	}
        }
        for(int i=0;i<n;i++)
        {
        	dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++)
        {
        	dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
        	if(dp[i][i+1]==true&&maxLen==1)
        	{
        		maxLen=2;
        		begin=i;
        		end=i+1;
        	}
        }
        for(int i=n-3;i>=0;i--)
        {
        	for(int j=i+2;j<n;j++)
        	{
        		dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]);
        		if(j-i+1>maxLen&&dp[i][j]==true)
        		{
        			maxLen=j-i;
        			begin=i;
        			end=j;
        		}
        	}
        }
        return s.substring(begin,end+1);
    }
}
