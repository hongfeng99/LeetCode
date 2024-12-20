import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {        
        StringBuffer ans=new StringBuffer();
        boolean []isused=new boolean[n+1];
        int[]count=new int[1];
        backtrack(ans,isused,n,count,k);
        return ans.toString();
    }
    public boolean backtrack(StringBuffer ans,boolean[] isused,int n,int[] count,int k)
    {
    	if(ans.length()==n)
    	{
    		count[0]++;
    		if(count[0]==k)
    		{    		
    			return true;
    		}
    		return false;
    	}
    	for(int i=1;i<=n;i++)
    	{
    		if(isused[i]==true)
    		{
    			continue;
    		}
    		ans.append(i);
    		isused[i]=true;
    		if(backtrack(ans,isused,n,count,k)==true)
    		{
    			return true;
    		}    		
    		ans.deleteCharAt(ans.length()-1);
    		isused[i]=false;
    	}
    	return false;
    }
}
