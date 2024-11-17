package 力扣热题100;

public class L53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int pre=0;
        int ans=nums[0];
        for(int i=0;i<n;i++)
        {
        	pre=Math.max(pre+nums[i], nums[i]);
        	ans=Math.max(pre, ans);
        }
    	return ans;
    }
}