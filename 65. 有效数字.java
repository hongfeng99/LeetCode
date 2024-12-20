//有BUG需要解决
class Solution {
    public boolean isNumber(String s) {
        int n=s.length();
        if(n==1)
        {
        	char c=s.charAt(0);
        	if(c-'0'>=0&&c-'0'<=9)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        int countofe=0;
        for(int i=0;i<n;i++)
        {
        	char c=s.charAt(i);
        	if(c=='e'||c=='E')
        	{
        		countofe++;
        	}
        	if(countofe>1||!((c-'0'>=0&&c-'0'<=9)||c=='e'||c=='E'||c=='+'||c=='-'||c=='.'))
        	{
        		return false;
        	}        	
        }
        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();
        int ptr=0;
        while(ptr<n&&s.charAt(ptr)!='e'&&s.charAt(ptr)!='E')
        {
        	s1.append(s.charAt(ptr));
        	ptr++;
        }
        if(ptr==n) //假如不包含e与E
        {
        	int countofplus=0;
        	int countofspot=0;
        	for(int i=0;i<n;i++)
        	{
        		char c=s.charAt(i);
        		if(c=='+'||c=='-')
        		{
        			countofplus++;
        		}
        		if(c=='.')
        		{
        			countofspot++;
        		}
        	}
        	if(countofplus>1||countofspot>1)
        	{
        		return false;
        	}
        	if(s.charAt(0)=='+'||s.charAt(0)=='-')
        	{
        		int p=1;
        		while(p<n&&s.charAt(p)-'0'>=0&&s.charAt(p)-'0'<=9)
        		{
        			p++;
        		}
        		if(p==1||p==n-1)  //如果符号后面的数字以.开头或者以.结尾
        		{
        			return false;
        		}
        		else
        		{
        			return true;
        		}
        	}
        	else
        	{
        		int p=0;
        		while(p<n&&s.charAt(p)-'0'>=0&&s.charAt(p)-'0'<=9)
        		{
        			p++;
        		}
        		if(p==0||p==n-1)    //如果数字以.开头或者以.结尾
        		{
        			return false;
        		}
        		else
        		{
        			return true;
        		}
        	}
        }
        else         //如果包含e或者E,此时ptr就指向e或者E
        {
        	ptr++;
        	if(ptr==n)
        	{
        		return false;  //以e或者E结尾
        	}
        	while(ptr<n&&s.charAt(ptr)!='e'&&s.charAt(ptr)!='E')
        	{
        		s2.append(s.charAt(ptr));   //s1包含了e之前的部分，s2包含了e之后的部分
        		ptr++;
        	}
        	int n1=s1.length();
        	int n2=s2.length();
        	int p1=0;
        	int p2=0;
    		int countofplus=0;
    		int countofspot=0;
    		for(int i=0;i<n1;i++)
    		{
    			char c=s.charAt(i);
    			if(c=='+'||c=='-')
    			{
    				countofplus++;
    			}
    			if(c=='.')
    			{
    				countofspot++;
    			}
    			if(countofplus>1||countofspot>1)
    			{
    				return false;
    			}
    		}
        	if(s.charAt(0)=='+'||s.charAt(0)=='-')
        	{
        		p1++;
        		while(p1<n1&&s.charAt(p1)!='.')
        		{
        			p1++;
        		}
        		if(p1==1||p1==n1-1)  //如果s1以.开头或者结尾
        		{
        			return false;
        		}
        		else
        		{
        			return true;
        		}
        	}
        	else
        	{
        		while(p1<n1&&s.charAt(p1)!='.')
        		{
        			p1++;
        		}
        		if(p1==0||p1==n1-1)  //如果s1以.开头或者结尾
        		{
        			return false;
        		}
        		else
        		{
        			return true;
        		}
        	}
        	//接下来处理s2
        	int numofplus=0;
        	int numofspot=0;
        	if(n2==1)
        	{
        		char c=s2.charAt(0);
        		if(c-'0'>=0&&c-'0'<=9)
        		{
        			return true;
        		}
        		else
        		{
        			return false;
        		}
        	}
        	for(int i=0;i<s2.length();i++)
        	{
        		char c=s2.charAt(i);
        		if(c=='.')
        		{
        			numofspot++;
        		}
        		if(c=='+'||c=='-')
        		{
        			numofplus++;
        		}
        	}
    		if(numofspot>0||numofplus>1)
    		{
    			return false;
    		}
    		if(numofplus==0)
    		{
    			return true;
    		}
    		else
    		{
    			if(s2.charAt(0)=='+'||s2.charAt(0)=='-')
    			{
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
        }
        return false;
    }
}











