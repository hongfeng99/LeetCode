class Solution {
    public int mySqrt(int x) {
        long p=x/2;
        while(p*p>x)
        {
        	p/=2;
        }
        while(p*p<=x)
        {
        	p++;
        }
        return (int)--p;
    }
}
//更为高效的回答
class Solution {
    public int mySqrt(int x) {
        if(x==0)
        {
        	return 0;
        }
        else
        {
        	int ans=(int)Math.exp(0.5*Math.log(x))+1;
        	return (long)ans*ans>x?ans-1:ans;
        }
    }
}
