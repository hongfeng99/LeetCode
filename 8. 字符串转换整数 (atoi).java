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
