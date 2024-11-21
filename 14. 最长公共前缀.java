class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n==1)
        {
        	return strs[0];
        }
        int count=0;
        int maxLen=Integer.MAX_VALUE;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
        	minLen=Math.min(minLen, strs[i].length());
        }
        while(count<n-1)
        {
        	int ptr=0;
        	while(ptr<minLen&& strs[count].charAt(ptr)==strs[count+1].charAt(ptr))
        	{
        		ptr++;
        	}
        	maxLen=Math.min(maxLen, ptr);
        	count++;
        }
        return strs[0].substring(0,maxLen);
    }
}
