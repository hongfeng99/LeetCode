//第一种思路,用数组记录每一个字母的位置，从数组最后一个元素起向前，如果位置连续那么即为单词
class Solution {
    public int lengthOfLastWord(String s) {
    	int n=s.length();
    	int[]nulList=new int[n];
        int[]chaList=new int[n];
        int n1=0;
        int n2=0;
        for(int i=0;i<n;i++)
        {
        	if(s.charAt(i)==' ')
        	{
        		nulList[n1++]=i;
        	}
            else
            {
                chaList[n2++]=i;
            }
        }
        if(n2==0)
        {
        	return 0;
        }
        if(n2==1)
        {
        	return 1;
        }
          if(n1==0)
        {
        	return n;
        }
        if(chaList[n2-1]==n-1)
        {
            return(n-1-nulList[n1-1]);
        }
        else
        {
             int j=0;
            while((n2-2-j)>=0 && (chaList[n2-1-j]-chaList[n2-2-j])==1)
            {
                j++;
            }
            return ++j;                 
    }
    }
}
//第二种思路，直接倒着计数
class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int num=0;
        int ptr=n-1;
        while(ptr>=0&&s.charAt(ptr)==' ')
        {
        	ptr--;
        }
        while(ptr>=0&&s.charAt(ptr)!=' ')
        {
        	num++;
        	ptr--;
        }
        return num;
    }
}
