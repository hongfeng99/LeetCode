class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        if(n==0)
        {
        	return 0;
        }
        int low=0;
        int high=0;
        while(high<n)
        {
        	if(nums[high]!=val)
        	{
        		nums[low]=nums[high];
        		low++;
        		high++;
        	}
        	else
        	{
        		high++;
        	}
        }
        return low;
    }
}
