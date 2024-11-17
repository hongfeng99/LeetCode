









class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[20001];
        for(int i=0;i<n;i ++)
        {
        	ans[nums[i]+10000]++;
        }
        for(int i=20000;i>=0;i--)
        {
        	k=k-ans[i];
        	if(k<=0)
        	{
        		return i-10000;
        	}
        }
        return 0;
    }
}