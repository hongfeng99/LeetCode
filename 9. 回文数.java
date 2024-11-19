class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0)
    	{
    		return false;
    	}
        int num=0;
        int y=x;
        //////////////统计x的位数
        while(y!=0)
        {
        	y/=10;
        	num++;
        }
        int begin=0;
        int end=num-1;
        String d=Integer.toString(x);
        while(begin<end&&(d.charAt(begin)==d.charAt(end)))
        {
        	begin++;
    		end--;
        }
        if(begin==end||begin-end==1)
        {
        	return true;
        }
        return false;
    }
}
