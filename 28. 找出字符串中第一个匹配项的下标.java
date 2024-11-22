class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(m<n)
        {
        	return -1;
        }
        int count=0;
        for(int i=0;i<=m-n;i++)
        {
        	if(haystack.charAt(i)==needle.charAt(0))
        	{
        		int left=i;
        		int right=0;
        		while(left<m&&right<n&&haystack.charAt(left)==needle.charAt(right))
        		{
        			left++;
        			right++;
        		}
        		if(right==n)
        		{
        			return i;
        		}
        	}
        }
        return -1;
    }
}
