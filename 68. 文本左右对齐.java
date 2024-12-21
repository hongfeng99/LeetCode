import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        List<String> ans=new ArrayList<String>();
        int ptr=0;
        while(ptr<n)
        {
        	StringBuffer res=new StringBuffer();
        	int begin=ptr;
        	int end=begin;
        	int spareLen=maxWidth;
        	if(maxWidth==words[begin].length())
        	{
        		res.append(words[begin]);
        		ans.add(res.toString());
        		ptr=begin+1;
        	}
        	else
        	{
        		while(end<n&&spareLen>=words[end].length()+1)
            	{
            		spareLen-=words[end].length(); 
            		spareLen--;    //放一个单词，再放一个空格
            		end++;
            	}  //此时这一行已经容纳不下word[end]外加一个空格的位置了，但有可能容纳下word[end]
            	if(end<n)
            	{
            		if(spareLen==words[end].length()) //这种情况是可以容纳words[end]，这一行从begin到end，每一个单词之间刚好一个空格
            		{
            			for(int i=begin;i<end;i++)
            			{
            				res.append(words[i]);   
            				res.append(' ');
            			}
            			res.append(words[end]);
            			ptr=end+1;
            		}
            		else   //无法容纳words[end]
            		{
            			int allspace=spareLen+end-begin; //所有的空格数量
            			int countofinterval=end-begin-1; //这一行需要的单词的间隔数量
            			if(countofinterval==0)  //如果只能放一个单词
            			{
            				res.append(words[end-1]);
            				for(int i=words[end-1].length();i<maxWidth;i++)
            				{
            					res.append(' ');
            				}
//            				if(allspace%2==0)
//            				{
//            					for(int i=0;i<allspace/2;i++)
//            					{
//            						res.append(' ');
//            					}
//            					res.append(words[begin]);
//            					for(int i=0;i<allspace/2;i++)
//            					{
//            						res.append(' ');
//            					}
//            				}
//            				else
//            				{
//            					for(int i=0;i<=allspace/2;i++)
//            					{
//            						res.append(' ');
//            					}
//            					res.append(words[begin]);
//            					for(int i=0;i<allspace/2;i++)
//            					{
//            						res.append(' ');
//            					}
//            				}
            			}        				
            			else   //这一行可以放两个及以上的单词
            			{
            				if(allspace%countofinterval==0) //如果空格可以均匀分配
                			{
                				for(int i=begin;i<end-1;i++)
                				{
                					res.append(words[i]);
                					for(int j=0;j<allspace/countofinterval;j++)
                					{
                						res.append(' ');
                					}
                				}
                				res.append(words[end-1]);
                			}
                			else   //如果空格不可以均匀分配
                			{
                				int countOfUnfairSpace=allspace-countofinterval*(allspace/countofinterval);//不均匀的空格数目
                				for(int i=begin;i<end-1;i++)
                				{
                					res.append(words[i]);
                					for(int j=0;j<allspace/countofinterval;j++)
                					{
                						res.append(' ');
                					}
                					if(countOfUnfairSpace>0)
                					{
                						res.append(' ');
                						countOfUnfairSpace--;
                					}
                				}
                				res.append(words[end-1]);
                			}
            			}
            			ptr=end;
            		}
        		ans.add(res.toString());
            	}
            	else  //如果这一行涉及到words[end]，也就意味着要处理最后一行了
            	{
            		int used=0;        	
            		for(int i=begin;i<n;i++)
            		{
            			res.append(words[i]);
            			res.append(' ');
            			used+=words[i].length();
            			used++;
            		}
            		for(int i=used;i<maxWidth;i++)
            		{
            			res.append(' ');
            		}
            		ans.add(res.toString());        		
            		ptr=n;//停止处理
            	}   
        	}
        }
        return ans;
    }
}
