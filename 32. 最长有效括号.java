import java.util.List;


class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        if(n==0)
        {
        	return 0;
        }
        int[]dp1=new int[n];//(
        int[]dp2=new int[n];//)
        if(s.charAt(0)=='(')
        {
        	dp1[0]=1;
        	dp2[0]=0;
        }
        else
        {
        	dp1[0]=0;
        	dp2[0]=1;
        }
        for(int i=1;i<n;i++)
        {
        	if(s.charAt(i)=='(')
        	{
        		dp1[i]=dp1[i-1]+1;
        		dp2[i]=dp2[i-1];
        	}
        	else
        	{
        		dp1[i]=dp1[i-1];
        		dp2[i]=dp1[i-1]+1;
        	}
        }
                
        int maxLen=0;
        
        for(int i=n-1;i>0;i--)
        {
        	if(dp1[i]==dp2[i]&&fun(s,0,i)==true)
        	{
        		maxLen=i+1;
        		break;
        	}
        }
        for(int i=1;i<n&&n-i>maxLen;i++)
        {
        	for(int j=n-1;j>i&&j-i>maxLen;j--)
        	{
        		if(dp1[j]-dp1[i-1]!=dp2[j]-dp2[i-1])
        		{
        			continue;
        		}
        		else
        		{
        			if(fun(s,i,j)==true&&(j-i+1)>maxLen)
        			{
        				maxLen=j-i+1;        				
        				break;
        			}
        		}
        	}
        }
        return maxLen;
    }
    
    public Boolean fun(String s,int x,int y)
    {
    	if(!(s.charAt(x)=='('&&s.charAt(y)==')'))
    	{
    		return false;
    	}
    	else
    	{    		
    		Stack<Character> stack=new Stack<Character>();
    		int ptr=x+1;
    		stack.push(s.charAt(x));
    		while(ptr<=y)
    		{
    			if(s.charAt(ptr)=='(')
    			{
    				stack.push(s.charAt(ptr));
    				ptr++;
    			}
    			else
    			{
    				if(stack.isEmpty()||stack.pop()==')')
    				{
    					return false;
    				}
    				ptr++;
    			}    			
    		}
    		return stack.isEmpty();
            
    	}
    }
}
