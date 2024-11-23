import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m=s.length();	//m是大字符串长度
        int n=words.length;	//n是字符串数组长度
        int len=words[0].length();	//len是小字符串的长度
        List<Integer> ans=new ArrayList<>();	//记录答案
        if(m<len)
        {
        	return ans;	//如果字符串比小字符串还短，那么不存在
        }        
        Boolean[][]dp=new Boolean[m+1][m+1];  	//dp[i][j]代表大字符串中的第i-1个元素到第j-1个元素是否存在于小字符串数组
        for(Boolean a[]:dp)
        {
        	for(int i=0;i<=m;i++)
        	{
        		a[i]=false;	//初始值全设为false
        	}
        }
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	map.put(words[i], map.getOrDefault(map.get(words[i]), 0)+1);	//把小字符串数组中的所有小字符串统计在hashmap里
        }
        
        for(int i=1;i<=m;i++)
        {
        	if(i+len-1<=m&&map.containsKey(s.substring(i-1, i+len-1)))	//初始化
        	{
        		dp[i][i+len-1]=true;	
        	}
        	
        }
        
        for(int i=1;i<=m;i++)
        {
        	if(i+len-1<=m&&dp[i][i+len-1]==false)
        	{
        		continue;    	//如果开头就不匹配 那么跳过
        	}
        	else
        	{        		
        		int k=0;
        		Map<String,Integer> res=new HashMap<>();
        		for(int j=0;j<n;j++)	//如果第一个小字符串匹配，那么新建hash表res，初始存储小字符串数组中所有的小字符串和个数
                {
                	res.put(words[j], res.getOrDefault(words[j],0)+1);
                }
        		while(i+len-1 +k*len<=m&&dp[i +k*len][i+len-1 +k*len]==true)  //开始以len为单位处理后续的子字符串
        		{
        			if(!res.containsKey(s.substring(i +k*len-1, i+len-1 +k*len))||res.get(s.substring(i+k*len-1, i+len-1   +k*len))<=0)
        			{
        				break;
        			}
        			res.put(s.substring(i+k*len-1, i+len-1   +k*len), res.get(s.substring(i+k*len-1, i+len-1   +k*len))-1);
        			k++;
        			if(k==n)
            		{
            			ans.add(i-1);
            			break;
            		}
        		}
        		
        	}
        }
        return ans;
    }
}
