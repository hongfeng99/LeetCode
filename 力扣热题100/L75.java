




class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p=0;
        for(int i=0;i<n;i++)
        {
        	if(nums[i]==0)
        	{
        		int temp=nums[i];        		
        		nums[i]=nums[p];
        		nums[p]=temp;
        		p++;
        	}
        }
        for(int i=p;i<n;i++)
        {
        	if(nums[i]==1)
        	{
        		int temp=nums[i];
        		nums[i]=nums[p];
        		nums[p]=temp;
        		p++;
        	}
        }
    }
}











