class Solution {
	public int maxArea(int[] height) {
        int n=height.length;
        int low=0;
        int high=n-1;
        int maxv=0;
        int tempv=0;
        while(low<=high)
        {
        	tempv=(high-low)*Math.min(height[low], height[high]);
        	maxv=Math.max(maxv, tempv);
        	if(height[low]<height[high])
        	{
        		low++;
        	}
        	else
        	{
        		high--;
        	}
        }
        return maxv;
    }
}
