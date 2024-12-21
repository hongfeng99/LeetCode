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
