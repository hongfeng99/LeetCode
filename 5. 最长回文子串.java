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
