class Solution {
    public String countAndSay(int n) {      
        String res=Integer.toString(1);
        return fun(res,1,n);
    }
    
    public String fun(String res,int times,int target)
    {    	
    	if(times<target)
    	{
    		int ptr=0;
        	StringBuffer ans=new StringBuffer();
        	while(ptr<res.length())
        	{
        		int begin=ptr;
        		char temp=res.charAt(ptr);
        		while(ptr+1<res.length()&&res.charAt(ptr+1)==res.charAt(ptr))
        		{
        			ptr++;
        		}
        		ans.append(ptr-begin+1);
        		ans.append(temp);
        		ptr++;
        	}
        	res=ans.toString();	
        	return fun(ans.toString(),times+1,target);
    	}    
    	else
    	{
    		return res;
    	}
    	 
    }
}
