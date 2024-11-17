package 力扣热题100;

import java.util.Set;

public class L3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


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
        	}
        	maxLen=Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}