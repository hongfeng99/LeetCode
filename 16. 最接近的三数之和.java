import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int minDist=Integer.MAX_VALUE;
        int begin=0;
        int mid=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
        	if(i>0&&nums[i]==nums[i-1])
        	{
        		continue;
        	}        	
        	for(int j=i+1;j<n;j++)
        	{
        		if(j>i+1&&nums[j]==nums[j-1])
        		{
        			continue;
        		}
        		int k=n-1;
        		while(j<k)
        		{        		
        			if(Math.abs(nums[i]+nums[j]+nums[k]-target)<=minDist)
        			{
        				minDist=Math.abs(nums[i]+nums[j]+nums[k]-target);
            			begin=i;
            			mid=j;
            			end=k;            				
        			}
        			k--;
        		}    			
        	}
        }
        return nums[begin]+nums[mid]+nums[end];
    }
}
