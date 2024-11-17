





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
































class Solution {
    public String longestPalindrome(String s) {
    	int len=s.length();
        int maxlen=1;
        int begin=0;
    	if(len<2)
    	{
    		return s;
    	}
    	boolean [][]istr=new boolean[len][len];
    	char[] charArray=s.toCharArray();
    	for(int m=0;m<len;m++)
    	{
    		istr[m][m]=true;
    	}
    	for(int L=2;L<len+1;L++)
    	{
    		for(int i=0;i<len;i++)
    		{
    			int j=i+L-1;
    			if(j>=len)
    			{
    				break;
    			}
    			if(charArray[j]!=charArray[i])
    			{
    				istr[i][j]=false;
    			}
    			else
    			{
    				if(j-i<3)
    				{
    					istr[i][j]=true;
    				}
    				else
    					
    				{
    					istr[i][j]=istr[i+1][j-1];
    				}
    			}
    			if(istr[i][j]==true&&j-i+1>maxlen)
    			{
    				maxlen=j-i+1;
    				begin=i;
    			}
    			
    		}
    	}
    	return s.substring(begin,begin+maxlen);
    }
}
