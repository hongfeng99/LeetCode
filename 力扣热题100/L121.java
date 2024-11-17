




















class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<2)
        {
        	return 0;
        }
        int minvalue=prices[0];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
        	minvalue=Math.min(minvalue, prices[i-1]);
        	ans=Math.max(ans, prices[i]-minvalue);
        }
        return ans>0?ans:0;
    }
}




class Solution {
    public int maxProfit(int[] prices) {
    	int minPrice=Integer.MAX_VALUE;
    	int maxProfit=0;
    	for(int i=0;i<prices.length;i++)
    	{
    		if(prices[i]<minPrice)
    		{
    			minPrice=prices[i];
    		}
    		if(prices[i]-minPrice>maxProfit)
    		{
    			maxProfit=prices[i]-minPrice;
    		}
    	}
    	return maxProfit;
    }
}
