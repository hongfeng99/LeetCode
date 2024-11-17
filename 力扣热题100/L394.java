



class Solution {
    public String decodeString(String s) {
        
    }
}




///////////////////////以下是错误的
class Solution {
    public String decodeString(String s) {
        int n=s.length();
        int p=0;
        StringBuffer ans=new StringBuffer();
        int begin=0;
        int end=0;
        while(p<n)
        {
        	if(s.charAt(p)-'0'>=0&&9-(s.charAt(p)-'0')>=0)
        	{
        		int sum=0;
        		while(s.charAt(p)-'0'>=0&&9-(s.charAt(p)-'0')>=0)
        		{
        			sum*=10;
        			sum+=s.charAt(p)-'0';
        			p++;
        		}
        		begin=p;//此时的p，指向本段数字+字母组合的第一个字母，num是数字。
        		while(p<n&&!(s.charAt(p)-'0'>=0&&9-(s.charAt(p)-'0')>=0))
        		{
        			p++;
        		}
        		end=p;//此时的p指向本段数字+字母组合的最后一个字母的下一个位置
        		for(int i=0;i<sum;i++)
        		{
        			ans.append(s.substring(begin,end));
        		}
        	}
        }
        return ans.toString();
    }
}