package 力扣热题100;

public class L76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//以下算法超时了，但实际应该正确

class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int minLen=Integer.MAX_VALUE;
        int begin=0;
        int end=n+1;
        
        int[] source=new int[58];       
        for(int j=0;j<m;j++)
        {
        	source[t.charAt(j)-'A']++;
        } 
        
        for(int i=0;i<=n-m;i++)
        {
            int leftm=m;
            int []count=source.clone();
        	if(count[s.charAt(i)-'A']==0)
        	{
        		continue;
        	}
            
            for(int j=i;j<n;j++)
            {
            	if(j-i>end-begin)
            	{
            		continue;
            	}
            	if(count[s.charAt(j)-'A']!=0)
            	{
            		count[s.charAt(j)-'A']--;
            		leftm--;
            	}
            	if(leftm==0)
            	{
            		if(minLen!=Math.min(minLen, j-i+1))
            		{
            			minLen=Math.min(minLen, j-i+1);
            			begin=i;
            			end=j;
            		}
            		continue;
            	}
            }
            
            
        }
        if(minLen==Integer.MAX_VALUE)
        {
        	return new String("");
        }
        else
        {
        	return s.substring(begin, end+1);	
        }
        
        
    }
}


//////////////////////////滑动窗口方法，虽然超时了，但应该是正确的。

class Solution {
    public String minWindow(String s, String t) {
     int n=s.length();
     int m=t.length();
     int begin=0;
     int end=0;
     int low=0;
     int high=0;
     int minLen=Integer.MAX_VALUE;
     Map<Character,Integer> table=new HashMap<>();
     //遍历目标字符串t，用一个哈希表table统计所有元素的个数
     for(int i=0;i<m;i++)
     {
    	 if(!table.containsKey(t.charAt(i)))
    	 {
    		 table.put(t.charAt(i),1);
    	 }
    	 else
    	 {
    		 table.put(t.charAt(i),table.get(t.charAt(i))+1);
    	 }
     }
     //自定义一个哈希表仅存储临时窗口中包含的目标字符个数
     Map<Character,Integer> map=new HashMap<>();
     //遍历主字符串，创建一个滑动窗口一个一个元素处理
     while(low<=n-m)
     {
    	 //如果临时窗口还不符合条件
    	 if(test(map,table,t)==false)
    	 {    
    		 //如果high指针元素，是目标字符串中的元素,那么更新hashmap
    		 if(table.containsKey(s.charAt(high)))
    		 {
    			 if(!map.containsKey(s.charAt(high)))
    			 {
    				 map.put(s.charAt(high),1);	 
    			 }
    			 else
    			 {
    				 map.put(s.charAt(high),map.get(s.charAt(high))+1);
    			 }    			 
    		 }
    		 //high指针后移一位
    		 if(high<n-1)
    		 {
    			 high++;
    		 }
    	 }
    	 //如果临时窗口已经包含了全部目标元素，那么low指针开始右移，直到不符合条件
    	 else
    	 {
    		 if(high-low<minLen)
    		 {
    			 minLen=high-low;
    			 begin=low;
    			 end=high;
    		 }
    		 //如果low指针元素是目标字符串中的元素(table中包含该元素那么map中也一定包含，所以初始map中的值>=1）
    		 if(table.containsKey(s.charAt(low)))
    		 {
    			 map.put(s.charAt(low),map.get(s.charAt(low))-1);
    			 low++;
    		 }
    		 //如果low指针元素不是目标字符串中的元素
    		 else
    		 {
    			 low++;
    		 }
    	 }
     }
     return s.substring(begin,end+1);
    }
    //自定义test函数，如果临时窗口已经包含全部目标字符，则返回true
    public boolean test(Map<Character,Integer> a,Map<Character,Integer> b,String c)
    {
    	int n=c.length();
    	for(int i=0;i<n;i++)
    	{
    		if(!a.containsKey(c.charAt(i))||a.get(c.charAt(i))<b.get(c.charAt(i)))
    		{
    			return false;
    		}
    	}
        return true;
    }
}
////////////////////////标准答案

class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/minimum-window-substring/solutions/257359/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


/////////////////////////
设置一个动态窗口，high，low，map0统计所有目标字符串元素以及个数
用count统计窗口里已经有的有效字符个数
用map把动态窗口的有效元素存储
当count<m，high指针向右扫描，
如果此元素有效，
如果窗口里已经有的这个元素个数<目标个数
那么count++，同时更新map，
如果>=目标个数，那么更新map，但不改变count，然后high++，
如果此元素无效那么直接high++；
当count==m，low指针向右移动
如果low元素不是目标元素
直接low++；
如果low是目标元素
如果map中对应low元素个数>map0中的个数，那么map更新，然后low++
如果1<=low元素个数<=map0中的个数，那么map更新，count--；然后low++
（在low是目标元素的情况下，在map中low元素必定>=0)
class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int begin=Integer.MAX_VALUE;
        int end=Integer.MAX_VALUE;
        Map<Character,Integer> map0=new HashMap<>();
        for(int i=0;i<m;i++)
        {
        	map0.put(t.charAt(i),map0.getOrDefault(t.charAt(i),0)+1);
        }
        int count=0;
        int ans=Integer.MAX_VALUE;
        int low=0;
        int high=0;
        Map<Character,Integer>map=new HashMap<Character,Integer>();
        while(high<n&&low<n-m+1)
        {
        	if(!map0.containsKey(s.charAt(high)))
        	{
        		high++;
        	}
        	else  //只要high元素有效，那么就要更新map，只不过有时count++，有时不动count
        	{
        		if(map.getOrDefault(s.charAt(high),0)<map0.get(s.charAt(high)))
        		{
        			count++;       		       			
        		}
        		map.put(s.charAt(high),map.getOrDefault(s.charAt(high),0)+1);
        		high++;
        	}     
        	if(count==m)
        	{
        		if(high-low<ans)
        		{
        			begin=low;
        			end=high-1;
        			ans=high-low;
        		}
        	}
        	while(count==m)
        	{
        		if(!map0.containsKey(s.charAt(low)))
        		{
        			low++;
        		}
        		else//只要low元素有效，就要更新map，map中low对应元素初始个数一定>=1,有时需要更新count
        		{
        			if(1<=map.get(s.charAt(low))&&map.get(s.charAt(low))<=map0.get(s.charAt(low)))
        			{
        				count--;        				
        			}
        			map.put(s.charAt(low),map.get(s.charAt(low))-1);
        			low++;
        		}
            	if(count==m)
            	{
            		if(high-low<ans)
            		{
            			begin=low;
            			end=high-1;
            			ans=high-low;
            		}
            	}
        	}
        }
        if(begin==Integer.MAX_VALUE)
        {
            return new String();
        }
        return s.substring(begin,end+1);
    }
}






