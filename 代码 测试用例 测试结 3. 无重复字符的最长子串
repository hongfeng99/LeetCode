class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0)
        {
            return 0;
        }
        int maxLen=1;
        for(int i=0;i<n;i++)
        {
        	Set<Character>set=new HashSet<>();
        	int j=i;
        	while(j<n&&!set.contains(s.charAt(j)))
        	{
        		set.add(s.charAt(j));
        		j++;
                if(set.contains(s.charAt(j)))
                {
                    break;
                }
        	}
        	maxLen=Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}
