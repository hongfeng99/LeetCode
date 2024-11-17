



class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
        	return nums[0];
        }
        Arrays.sort(nums);
        int count=1;
        for(int i=1;i<n;i++)
        {
        	if(nums[i]==nums[i-1])
        	{
        		count++;
        		if(count>n/2)
        		{
        			return nums[i];
        		}
        	}
        	if(nums[i]!=nums[i-1])
        	{
        		count=1;
        		continue;
        	}
        	
        }
        return -1;
    }
}












