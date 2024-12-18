import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>>ans=new ArrayList<List<String>>();
        Map<String,String>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	char[] cur=strs[i].toCharArray();
        	Arrays.sort(cur);
        	map.put(strs[i], new String(cur));
        }
        boolean[]dp=new boolean[n];
        Arrays.fill(dp,false);
        for(int i=0;i<n;i++)
        {
        	if(dp[i]==true)
        	{
        		continue;
        	}
        	List<String> cur=new ArrayList<String>();
        	for(int j=i;j<n;j++)
        	{
        		if(dp[j]==false&&map.get(strs[j]).equals(map.get(strs[i])))
        		{
        			cur.add(strs[j]);
        			dp[j]=true;
        		}
        	}
        	ans.add(new ArrayList<String>(cur));
        }
        return ans;
    }
}
