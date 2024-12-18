class Solution {
    public double myPow(double x, int n) {
    	long N=n;
        if(n<0)
        {
        	x=1/x;
        	N*=-1;
        }
        
        double result=1;
        double res=x;
        for(long i=N;i>0;i/=2)
        {
        	if(i%2==1)
        	{
        		result*=res;
        	}
        	res*=res;
        }
        return result;
    }
}
