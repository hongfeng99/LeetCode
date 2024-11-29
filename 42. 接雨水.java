class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int ans=0;
        int[] Lpeak=new int[n];
        int[] Rpeak=new int[n];
        Lpeak[0]=height[0];
        Rpeak[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
        	Lpeak[i]=Math.max(Lpeak[i-1], height[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
        	Rpeak[i]=Math.max(Rpeak[i+1], height[i]);
        }
        for(int i=0;i<n;i++)
        {
        	ans+=Math.min(Lpeak[i], Rpeak[i])-height[i];
        }
        return ans;
    }
}
