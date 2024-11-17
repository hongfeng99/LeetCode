package 力扣热题100;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L128 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			System.out.println(longestConsecutive(a));
		}

	}	
	
	public static int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        Arrays.sort(nums);
        int maxLen=1;
        int[]dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
        	if(nums[i]==nums[i-1]+1)
        	{
        		dp[i]=dp[i-1]+1;
        	}
        	if(nums[i]==nums[i-1])
        	{
        		dp[i]=dp[i-1];
        	}
        	else
        	{
        		dp[i]=1;
        	}
        	maxLen=Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}


///////////////////////////////////


class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],false);
        }
        int maxLen=1;
        for(int i=0;i<n;i++)
        {
            if(map.get(nums[i])==true)
            {
                continue;
            }
            else
            {
                maxLen=Math.max(maxLen,test(map,nums[i]));
            }
        }
        return maxLen;
    }

    public static int test(Map<Integer,Boolean> map,int target)
    {
            int count=1;
            int left=target-1;
            while(map.containsKey(left))
            {
                map.put(left,true);
                count++;
                left--;
            }
            int right=target+1;
            while(map.containsKey(right))
            {
                map.put(right,true);
                count++;
                right++;
            }
        return count;
    }
}

////////////////////////////////////////



class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        int maxLen=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
        	set.add(nums[i]);
        }
        
        for(int i=0;i<n;i++)
        {
        	if(set.contains(nums[i]-1))
        	{
        		continue;
        	}
        	else
        	{
        		int count=1;
        		int temp=nums[i]+1;
        		while(set.contains(temp))
        		{
        			count++;
        			temp++;
        		}
        		maxLen=Math.max(maxLen,count);
        	}
        }
        return maxLen;
    }
}

















