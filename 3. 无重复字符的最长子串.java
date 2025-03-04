import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0)
        {
        	return 0;
        }
        int low=0;
        int high=0;
        int ans=1;
        Set<Character> set=new HashSet<>();
        while(high<n)
        {        	
        	while(high<n&&!set.contains(s.charAt(high)))
        	{
        		set.add(s.charAt(high));
        		high++;
        	}
        	ans=Math.max(ans, high-low);
        	set.remove(s.charAt(low));
        	low++;
        }
        return ans;
    }
}
