class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int p=n-2;
        while(p>=0&&nums[p]>=nums[p+1])
        {
        	p--;
        }
        if(p>=0)
        {
        	int pivot=n-1;
        	while(pivot>=0&&nums[pivot]<=nums[p])
        	{
        		pivot--;
        	}
        	swap(nums,pivot,p);
        	int begin=p+1;
        	reverse(nums,begin);
        }
        else
        {
        	reverse(nums,0);
        }
    }
    
    public void swap(int nums[],int x,int y)
    {
    	int temp=nums[x];
    	nums[x]=nums[y];
    	nums[y]=temp;
    }
    
    public void reverse(int nums[],int x)
    {
    	int n=nums.length;
    	int low=x;
    	int high=n-1;
    	while(low<high)
    	{
    		swap(nums,low,high);
    		low++;
    		high--;
    	}
    }
}