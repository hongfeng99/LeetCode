import java.util.Collections;
import java.util.List;

class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        List<Integer> ans=new ArrayList<>();
        int jinwei=0;
        for(int i=n-1;i>=0;i--)
        {
        	int num=(i==n-1?digits[i]+1+jinwei:digits[i]+jinwei);
        	jinwei=num/10;
        	ans.add(num%10);
        }
        if(jinwei!=0)
        {
        	ans.add(1);
        }
        Collections.reverse(ans);
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
        	res[i]=ans.get(i);
        }
        return res;
    }
}
