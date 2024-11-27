class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[]ans=new int[] {-1,-1};
        int ptr=0;
        while(ptr<n&&nums[ptr]<target)
        {
        	ptr++;
        }
        if(ptr==n||nums[ptr]>target||nums[0]>target||nums[n-1]<target)
        {
        	return ans;
        }
        ans[0]=ptr;
        while(ptr<n&&nums[ptr]==target)
        {
        	ptr++;
        }
        ans[1]=ptr-1;
        return ans;
    }
}
