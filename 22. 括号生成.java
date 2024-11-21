import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<String>();
        StringBuffer res=new StringBuffer();
        backtrack(ans,res,0,0,n);
        return ans;
    }
    
    public void backtrack(List<String> ans,StringBuffer res,int left,int right,int n)
    {
    	if(left==n&&right==n)
    	{
    		ans.add(res.toString());
    		return;
    	}
    	if(left<n)
    	{
    		res.append('(');
    		backtrack(ans,res,left+1,right,n);
    		res.deleteCharAt(res.length()-1);
    	}
    	if(right<left)
    	{
    		res.append(')');
    		backtrack(ans,res,left,right+1,n);
    		res.deleteCharAt(res.length()-1);
    	}
    }
}
