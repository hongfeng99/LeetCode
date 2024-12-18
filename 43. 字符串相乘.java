class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        if(num1.equals("0")||num2.equals("0"))
        {
        	return new String("0");
        }
        String ans="0";
        for(int i=n-1;i>=0;i--)
        {
        	StringBuffer cur=new StringBuffer();
        	for(int j=n-1;j>i;j--)
        	{
        		cur.append(0);
        	}
        	int add=0;
        	for(int j=m-1;j>=0;j--)
        	{
        		int Num1=num1.charAt(j)-'0';
        		int Num2=num2.charAt(i)-'0';
        		int Num=Num2*Num1+add;
        		add=Num/10;
        		cur.append(Num%10);
        	}
        	if(add!=0)
        	{
        		cur.append(add);
        	}
        	ans=func(cur.reverse().toString(),ans);
        }
        return ans;
    }
    
    public String func(String cur,String ans)
    {
    	int i=cur.length()-1;
    	int j=ans.length()-1;
    	int add=0;
    	StringBuffer Ans=new StringBuffer();
    	while(i>=0||j>=0||add!=0)
    	{
    		int Num1=i>=0?cur.charAt(i)-'0':0;
    		int Num2=j>=0?ans.charAt(j)-'0':0;
    		int Num=Num1+Num2+add;
    		Ans.append(Num%10);
    		add=Num/10;
    		i--;
    		j--;
    	}    
    	return Ans.reverse().toString();
    }
}
