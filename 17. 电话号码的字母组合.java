import java.util.List;
import java.util.Map;

class Solution {
    Map<Character,String>map=new HashMap<>();
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuffer res=new StringBuffer();
        List<String>ans=new ArrayList<String>();
        if(n==0)
        {
        	return ans;
        }
        backtrack(ans,res,digits,0);
        return ans;
    }
    
    public void backtrack(List<String> ans,StringBuffer res,String digits,int begin)
    {
    	if(begin==digits.length())
    	{
    		ans.add(res.toString());
    		return;
    	}
    	String temp=map.get(digits.charAt(begin));
		for(int j=0;j<temp.length();j++)
		{
			res.append(temp.charAt(j));
			backtrack(ans,res,digits,begin+1);
			res.deleteCharAt(res.length()-1);    			
		}
    }
}
