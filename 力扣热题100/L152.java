













class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[]pos=new int[n];
        int[]neg=new int[n];
        pos[0]=nums[0];
        neg[0]=nums[0];
        int minvalue=nums[0];
        int maxvalue=nums[0];
        for(int i=1;i<n;i++)
        {
        	pos[i]=Math.max(Math.max(nums[i]*pos[i-1], nums[i]*neg[i-1]),nums[i]);
        	neg[i]=Math.min(Math.min(nums[i]*pos[i-1], nums[i]*neg[i-1]),nums[i]);
			maxvalue=Math.max(maxvalue, pos[i]);    			
			minvalue=Math.min(minvalue, neg[i]);
        }
        return maxvalue==Integer.MIN_VALUE?nums[0]:maxvalue;
    }
}






