class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
            && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }
}
/////////////////////////////2024/11/18仍然有bug待解决
class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int ptr=0;
        if(n==0)
        {
        	return 0;
        }
        while(s.charAt(ptr)==' ')
        {
        	ptr++;
        }
        if(ptr==n)
        {
        	return 0;
        }
        if(s.charAt(ptr)=='-')
        {
        	ptr++;
        	if(ptr==n||s.charAt(ptr)<'0'||s.charAt(ptr)>'9')
        	{
        		return 0;
        	}
        	while(ptr<n&&s.charAt(ptr)=='0')
        	{
        		ptr++;
        	}
//        	if(ptr==n)
//        	{
//        		return 0;
//        	}
        	long num=0;
        	while(ptr<n&&s.charAt(ptr)!='0')
        	{
        		num*=10;
        		num+=s.charAt(ptr)-'0';
        		ptr++;
        	}
        	num*=(-1);
        	if(num<Integer.MIN_VALUE)
        	{
        		return Integer.MIN_VALUE;
        	}
        	else
        	{
        		return (int)num;
        	}
        }
        else
        {      
        	
        	if(s.charAt(ptr)=='+')
        	{
        		ptr++;
        		if(ptr==n||s.charAt(ptr)<'0'||s.charAt(ptr)>'9')
            	{
            		return 0;
            	} 
        		while(s.charAt(ptr)=='0')
        		{
        			ptr++;
        		}
        		if(ptr==n)
        		{
        			return 0;
        		}
        		int num=0;
        		while(ptr<n&&s.charAt(ptr)>='0'&&s.charAt(ptr)<='9')
        		{
        			num*=10;
        			num+=s.charAt(ptr)-'0';
        			ptr++;
        		}
        		return (int)num;
        	}
        }
        return 0;
    }
}
/////////////////////////////////////////////////////////////////已经DEbug
class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        //如果为空字符串
        if(n==0)
        {
        	return 0;
        }
        //定义一个从头开始遍历的指针
        int ptr=0;
        //读取并且跨过所有空格
        while(ptr<n&&s.charAt(ptr)==' ')
        {
        	ptr++;
        }
        //如果整个字符串都是空格
        if(ptr==n)
        {
        	return 0;
        }
        //如果去除所有前置空格得到的是'-'
        if(s.charAt(ptr)=='-')
        {
        	//如果以'-'结尾或者'-'后面紧跟的第一个字符不是数字
        	if(ptr==n-1||s.charAt(ptr+1)<'0'||s.charAt(ptr+1)>'9')
        	{
        		return 0;
        	}
        	ptr++;
        	//读取所有的0并且跨过
        	while(ptr<n&&s.charAt(ptr)=='0')
        	{
        		ptr++;
        	}
        	if(ptr==n)
        	{
        		return 0;
        	}
        	else
        	{
        		long sum=0;
        		while(ptr<n&&s.charAt(ptr)>='0'&&s.charAt(ptr)<='9')
        		{
        			sum*=10;
        			sum+=s.charAt(ptr)-'0';
        			if(sum*(-1)<Integer.MIN_VALUE)
            		{
            			return Integer.MIN_VALUE;
            		}
        			ptr++; 
        		}
        		sum*=(-1);
        		
        		return (int)sum;
        	}
        }
        if(s.charAt(ptr)=='+')
        {
        	if(ptr==n-1||s.charAt(ptr+1)<'0'||s.charAt(ptr)>'9')
        	{
        		return 0;
        	}
        	else
        	{
        		ptr++;
        		while(ptr<n&&s.charAt(ptr)=='0')
        		{
        			ptr++;
        		}
        		if(ptr==n)
        		{
        			return 0;
        		}
        		else
        		{
        			long sum=0;
        			while(ptr<n&&s.charAt(ptr)>='0'&&s.charAt(ptr)<='9')
        			{
        				sum*=10;
        				sum+=s.charAt(ptr)-'0';
        				ptr++;
        			}
        			if(sum>Integer.MAX_VALUE)
        			{
        				return Integer.MAX_VALUE;
        			}
        			return (int)sum;
        		}
        	}
        	
        }
        if(s.charAt(ptr)>='0'&&s.charAt(ptr)<='9')
        {
        	long sum=0;
        	while(ptr<n&&s.charAt(ptr)>='0'&&s.charAt(ptr)<='9')
        	{
        		sum*=10;
        		sum+=s.charAt(ptr)-'0';
        		if(sum>Integer.MAX_VALUE)
    			{
    				return Integer.MAX_VALUE;
    			}
        		ptr++;
        	}   	
        	return (int)sum;
        }
        return 0;
    }
}
