







class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        Boolean[][]dp=new Boolean[n][n];
        for(Boolean a[]:dp)
        {
        	for(int i=0;i<a.length;i++)
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
        	dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
        }
        for(int i=n-3;i>=0;i--)
        {
        	for(int j=i+2;j<n;j++)
        	{
        		dp[i][j]=((s.charAt(i)==s.charAt(j))&&dp[i+1][j-1]);
        	}
        }
        
        
        List<List<String>> combinations=new ArrayList<List<String>>();
        List<String>combination =new ArrayList<String>();
        backtrack(combinations,combination,s,dp,0);
        return combinations;
    }
    public void backtrack(List<List<String>> combinations,List<String>combination,String s,Boolean dp[][],int begin)
    {
    	if(begin==s.length())
    	{
    		combinations.add(new ArrayList<String>(combination));
    		return;
    	}
    	for(int i=begin;i<s.length();i++)
    	{
    		if(dp[begin][i])
    		{
    			combination.add(s.substring(begin, i+1));
    			backtrack(combinations,combination,s,dp,i+1);
        		combination.remove(combination.size()-1);
    		}
    		
    	}
    }
}