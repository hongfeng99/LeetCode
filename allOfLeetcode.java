我会用一点点github啦 哈哈哈
package leetcode;

import java.util.Map;

//999_1：两数之和

//如果没有找到两个数的和等于target，那么也要记得返回一个空数组int[0]；
import java.util.ArrayList;  
import java.util.List;  
class Solution{
	public int[] twoSum(int []nums,int target)
	{
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int n=nums.length;
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return new int[0];
	}
}

//999—2. 两数相加




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei=0;
        ListNode ans=new ListNode(0);
        ListNode p=ans;
        while(l1!=null&&l2!=null)
        {
        	p.next=new ListNode((l1.val+l2.val+jinwei)%10);
        	p=p.next;
        	jinwei=(l1.val+l2.val+jinwei)/10;
        	l1=l1.next;
        	l2=l2.next;
            if(l1==null&&l2==null&&jinwei==1)
            {
                p.next=new ListNode(1);
            }
        }
        while(l1!=null)
        {
        	 p.next=new ListNode((l1.val+jinwei)%10);
        	 p=p.next;
        	 jinwei=(l1.val+jinwei)/10;
        	 l1=l1.next;
             if(l1==null&&jinwei==1)
             {
                p.next=new ListNode(1);
             }
        }
        while(l2!=null)
        {
        	p.next=new ListNode((l2.val+jinwei)%10);
        	p=p.next;
        	jinwei=(l2.val+jinwei)/10;
        	l2=l2.next;
            if(l2==null&&jinwei==1)
             {
                p.next=new ListNode(1);
             }
        }return ans.next;
    }
}


//999_4:寻找两个正序数组的中位数

方法一：/////////////////////////////////////////////////////////////////////
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1=nums1.length;
//        int len2=nums2.length;
//        int i=0,j=0,count=0;
//        if((len1+len2)%2==1)
//        {
//        	while(count<=(len1+len2)/2)
//        	{
//        		if(nums1[i]<nums2[j])
//        		{
//        			i++;
//        		}
//        		else
//        		{
//        			j++;
//        		}
//        		count++;      
//        	}
//    		return (double)Math.min(nums1[--i],nums2[--j]);
//        }
//        else
//        {
//        	while(i<len1&&j<len2&&count<=(len1+len2)/2-1)
//        	{
//        		if(nums1[i]<nums2[j])
//        		{
//        			i++;
//        		}
//        		else
//        		{
//        			j++;
//        		}
//        	}	
//        		double m1=Math.min(nums1[i-1],nums2[j-1]);
//        		double m2;
//        		if(m1==nums1[i-1])
//        		{
//        			m2=Math.min(nums2[j-1],nums1[i]);
//        		}
//        		else
//        		{
//        			m2=Math.min(nums1[i-1],nums2[j]);
//        		}
//        		return (m1+m2)/2;
//        		
//        }
//    }
//}
方法二：/////////////////////////////////////////////////////////////////////

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1=nums1.length;
    	int len2=nums2.length;
    	int[]nums3 =new int[len1+len2];
    	for(int i=0;i<len1;i++)
    	{
    		nums3[i]=nums1[i];
    	}
    	for(int j=0;j<len2;j++)
    	{
    		nums3[j+len1]=nums2[j];
    	}
    	quickSort(nums3,0,len1+len2-1);
    	if((len1+len2)%2==1)
    	{
    		return (double)nums3[(len1+len2)/2];
    	}
    	else
    	{
    		return (double)(nums3[(len1+len2)/2]+nums3[(len1+len2)/2-1]);
    	}
    }
    public int partition(int []nums,int low,int high)
    {
    	int pivot=nums[low];
    	while(low<=high)
    	{
    		while(low<=high&&nums[high]>pivot)
    		{
    			high--;
    		}
    		nums[low]=nums[high];
    		while(low<=high&&nums[low]<pivot)
    		{
    			low++;
    		}
    		nums[high]=nums[low];
    	}
    	nums[low]=pivot;
    	return low;
    }
    public void quickSort(int []nums,int low,int high)
    {
    	if(low<high) {
    		int mid=partition(nums,low,high);
        	quickSort(nums,low,mid-1);
        	quickSort(nums,mid+1,high);	
    	}
    	
    }
}
方法三(正确)/////////////////////////////////////////////////////////////////////
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}




//999_4:寻找两个正序数组的中位数


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n3=n1+n2;
    	int i=0;
    	int j=0;
    	int num=0;
    	int count=0;
        if(n3%2==1)
        {
        	while(i<n1&&j<n2)
        	{
        		if(nums1[i]<nums2[j])
        		{
        			
        			num=nums1[i];
        			i++;
        		}
        		else
        		{
        			
        			num=nums2[j];
        			j++;
        		}
        		count++;
        		if(count==(n3/2))
        		{
        			return num;
        		}
        	}
        	
        	while(i<n1)
        	{
        		
        		num=nums1[i];
        		i++;
        		if(count==(n3/2))
        		{
        			return num;
        		}
        	}
        	while(j<n2)
        	{
        		
        		num=nums2[j];
        		j++;
        		if(count==(n3/2))
        		{
        			return num;
        		}
        	}       	       	
        }
        
        if(n3%2==0)
        {
        	int lastnum1=0;
        	int lastnum2=0;
        	while(i<n1&&j<n2)
        	{
        		if(nums1[i]<nums2[j])
        		{
        			
        			num=nums1[i];
        			i++;
        		}
        		else
        		{
        			
        			num=nums2[j];
        			j++;
        		}
        		count++;
        		if(count==(n3)/2-1)
        		{
        			lastnum1=num;
        			if(i<n1&&j<n2)
        			{
        				if(nums1[i]<nums2[j])
        				{
        					return (lastnum1+nums1[i])/2;
        				}
        				else
        				{
        					return (lastnum1+nums2[j])/2;
        				}
        			}
        			if(i<n1)
        			{
        				return (lastnum1+nums2[j])/2;
        			}
        			if(j<n2)
        			{
        				return (lastnum1+nums1[i])/2;
        			}
        		}
        	}
        	
        	while(i<n1)
        	{
        		if()
        		i++;
        	}
        }
    }
}




//999_5:最长回文子串
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public String longestPalindrome(String s) {
    	int len=s.length();
        int maxlen=1;
        int begin=0;
    	if(len<2)
    	{
    		return s;
    	}
    	boolean [][]istr=new boolean[len][len];
    	char[] charArray=s.toCharArray();
    	for(int m=0;m<len;m++)
    	{
    		istr[m][m]=true;
    	}
    	for(int L=2;L<len+1;L++)
    	{
    		for(int i=0;i<len;i++)
    		{
    			int j=i+L-1;
    			if(j>=len)
    			{
    				break;
    			}
    			if(charArray[j]!=charArray[i])
    			{
    				istr[i][j]=false;
    			}
    			else
    			{
    				if(j-i<3)
    				{
    					istr[i][j]=true;
    				}
    				else
    					
    				{
    					istr[i][j]=istr[i+1][j-1];
    				}
    			}
    			if(istr[i][j]==true&&j-i+1>maxlen)
    			{
    				maxlen=j-i+1;
    				begin=i;
    			}
    			
    		}
    	}
    	return s.substring(begin,begin+maxlen);
    }
}



import java.util.ArrayList;  
import java.util.List;  

public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

/////////////////////////////////////////我自己写的
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public String longestPalindrome(String s) {
    	int L=1,j=0,i=0,begin=0;
    	int len=s.length();
    	if(len<2)
    	{
    		return s;
    	}
    	char []a=new char[len];
    	a=s.toChar;
    	boolean[][] dp=new boolean[len][len];
    	for(int i=0;i<len;i++)
    	{
    		dp[i][i]=true;
    	}
    	int maxLen=0;
    	for(L=2;L<len;L++)
    	{
    		for(i=0;i<len;i++)
    		{    		
    			int j=L+i-1;
    			if(j>=len)
    			{
    				break;
    			}
    			if(a[i]!=a[j])
    			{
    				return false;
    			}
    			if(a[i]==a[j])
    			{
    				if(j-i<3)
    				{
    					dp[L][j]=true;
    				}
    				else
    				{
    					dp[i][j]=dp[i+1][j+1];
    				} 					
    			}
    			if(d[i][j]==true&&j-i+1>maxLen)
    			{
    				maxLen=j-L+1;
    				begin=i;
    			}
    		}
    		
    	}
    	return s.substring(begin,begin+maxLen);
    	
    }
}

//999_6:Z字形变换
import java.util.ArrayList;  
import java.util.List;  
class Solution {  
    public String convert(String s, int numRows) {  
        // 如果 numRows 小于 2，则不需要进行任何变换，直接返回原字符串  
        if(numRows < 2) return s;  
          
        // 创建一个 StringBuilder 列表，用于存储每一行的字符  
        List<StringBuilder> rows = new ArrayList<StringBuilder>();  
          
        // 初始化每一行为一个新的 StringBuilder 对象  
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());  
          
        // i 表示当前字符应该放在哪一行，flag 用于控制 i 的增减，模拟“Z”字形路径  
        int i = 0, flag = -1;  
          
        // 遍历字符串 s 中的每一个字符  
        for(char c : s.toCharArray()) {  
            // 将当前字符添加到对应的行  
            rows.get(i).append(c);  
              
            // 当字符到达第一行或最后一行时，改变方向  
            if(i == 0 || i == numRows -1) flag = - flag;  
              
            // 根据 flag 的值调整 i 的值，模拟“Z”字形路径  
            i += flag;  
        }  
          
        // 创建一个 StringBuilder 对象，用于构建最终的字符串  
        StringBuilder res = new StringBuilder();  
          
        // 遍历每一行，将每一行的字符添加到结果字符串中  
        for(StringBuilder row : rows) res.append(row);  
          
        // 返回最终的字符串  
        return res.toString();  
    }  
}

import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public String convert(String s, int numRows) {
    	int n=s.length();
    	int r=numRows;
    	if(r==1||r>=n)
    	{
    		return s;
    	}
    	int t=2*(r-1);
    	int c=(n+t-1)/t*(t-1);/////////////////
    	int x=0,y=0;
    	char[][] arr=new char[r][c];
    	for(int i=0;i<n;i++)
    	{
    		if((i%(2*r-2)<r-1))
    		{
    			arr[x][y]=s.charAt(i);
    			x++;
    		}
    		else
    		{
    			arr[x][y]=s.charAt(i);
    			x--;
    			y++;
    		}
    	}
    	StringBuffer str=new StringBuffer();
    	for(char[] row:arr)
    	{
    		for(char pp:row)
    		{
    			if(pp!=0)
    			{
    				str.append(pp);
    			}
    		}
    	}
    	return str.toString();
    }
}

//999_7:整数反转
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int reverse(int x) {
         long sum = 0;
        if (x > 0) {
            while (x != 0) {
                sum = sum * 10 + x % 10;
                x /= 10;
            }
        }
        if (x < 0) { 
            x *= (-1);
            while (x != 0) {
                sum = sum * 10 + x % 10;
                x /= 10;
            }
            sum *= (-1);
        } 
        if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
        {
            return 0;
        }
        else
        {
            return (int)sum;
        }
    }
}

//999_8:字符串转换整数 (atoi)
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int myAtoi(String s) {
        
    }
}

// 999_9:回文数
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0)
    	{
    		return false;
    	}
    	if(x%10==0&&x!=0)
    	{
    		return false;
    	}
    	int invertNum=0;
    	int originalNum=x;
    	while(x>0)
    	{
    		invertNum=invertNum*10+x%10;
    		x=x/10;
    	}
    	if(originalNum==invertNum)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}

//999_11：盛最多水的容器
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int maxArea(int[] height) {
    	int res=0;
    	int n=height.length;
    	int i=0;
    	int j=n-1;
    	while(i<j)
    	{
    		if(height[i]<height[j])
    		{
    			res=Math.max(res,(j-i)*height[i++]);
    		}
    		else
    		{
    			res=Math.max(res,(j-i)*height[j--]);
    		}
    	}
    	return res;
    }
}
//999_12. 整数转罗马数字
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public String intToRoman(int num) {
        StringBuilder a=new StringBuilder();        
            while(num>=1000)
            {
                a.append('M');
                num-=1000;
            }
            while(num>=900)
            {
                a.append("CM");
                num-=900;
            }        
             while(num>=500)
            {
                a.append('D');
                num-=500;
            }
            while(num>=400)
            {
                a.append("CD");
                num-=400;
            }            
             while(num>=100)
            {
                a.append('C');
                num-=100;
            }
            while(num>=90)
            {
                a.append("XC");
                num-=90;
            } 

             while(num>=50)
            {
                a.append('L');
                num-=50;
            }
             while(num>=40)
            {
                a.append("XL");
                num-=40;
            }
             while(num>=10)
            {
                a.append('X');
                num-=10;
            }
            while(num>=9)
            {
                a.append("IX");
                num-=9;
            }            
             while(num>=5)
            {
                a.append('V');
                num-=5;
            }
            while(num>=4)
            {
                a.append("IV");
                num-=4;
            }
            while(num>=1)
            {
                a.append('I');
                num-=1;
            }            
            return a.toString();
                                                                        
    }
}




//999_13:罗马数字转整数
//   if(map.get(s.charAt(i))<map.get(s.charAt(i+1))&&i<(n-1))和
//   (i<(n-1)&&map.get(s.charAt(i))<map.get(s.charAt(i+1)))是不一样的。
//   将i<(n-1)放在前面通常是一个好习惯，因为它可以防止在i等于n-1时访问s.charAt(i+1)，
//   从而避免StringIndexOutOfBoundsException异常。
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int romanToInt(String s) {
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	map.put( 'I'            ,1);
    	map.put( 'V'            ,5);
    	map.put( 'X'            ,10);
    	map.put( 'L'            ,50);
    	map.put( 'C'            ,100);
    	map.put( 'D'            ,500);
    	map.put( 'M'            ,1000);
    	int money=0;
    	int n=s.length();
    	for(int i=0;i<n;i++)
    	{
    		if(i<(n-1)&&map.get(s.charAt(i))<map.get(s.charAt(i+1)))
    		{
    			money-=map.get(s.charAt(i));
    		}
    		else
    		{
    			money+=map.get(s.charAt(i));
    		}
    	}
    	return money;
    }
}

//999_14:最长公共前缀
//  public String类型返回值的函数，如果不存在字符串符合，要记得返回""而不是false
//  如果str代表一个字符串的话，str.substring（0,6)等于第0个到第5个字符。
import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs==null||strs.length==0)
    	{
    		return "";
    	}
    	int n=strs.length;
    	String value=strs[0];
    	for(int i=1;i<n;i++)
    	{
    		value=longestCommonPrefix(value,strs[i]);
    	}
    	return value;
    }
    public String longestCommonPrefix(String a,String b) {
    	int len=Math.min(a.length(),b.length());
    	int count=0;
    	while(count<len&&a.charAt(count)==b.charAt(count))
    	{
    		count++;
    	}
    	return a.substring(0,count);
    }
}


import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public String longestCommonPrefix(String[] strs) {
    	int n=strs.length;
    	if(strs==null||n==0)
    	{
    		return "";
    	}
    	String prefix=strs[0];
    	for(int i=1;i<n;i++)
    	{
    		prefix=longestCommonPrefix(prefix,strs[i]);
    		if(prefix=="")
    		{
    			return "";
    		}
    	}
    	return prefix;
    	
    }
    public String longestCommonPrefix(String str1,String str2) {
    	int len=Math.min(str1.length(),str2.length());
    	int count=0;
    	while(count<len&&str1.charAt(count)==str2.charAt(count))
    	{
    		count++;
    	}
    	return new String(str1.substring(0,count));
    }
}


//999_15:三数之和
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
    	Arrays.sort(nums);
    	List<List<Integer>> num=new ArrayList<List<Integer>>();
    	int first,second,third;
    	for(first=0;first<n-2;first++)
    	{
    		if(first>0&&nums[first]==nums[first-1])
    		{
    			continue;
    		}
            	third=n-1;
    		int target=-nums[first];
    		for(second=first+1;second<n-1;second++)
    		{
    			if(second>first+1&&nums[second]==nums[second-1])
    			{
    				continue;
    			}
    		
    			while(second<third && nums[second]+nums[third]>target)
    			{
    				third--;
    			}
    				if(third==second)
    				{
    					break;
    				}
    				if(nums[second]+nums[third]==target)
    				{
    					List<Integer> a=new ArrayList<Integer>();
    					a.add(nums[first]);
    					a.add(nums[second]);
    					a.add(nums[third]);
    					num.add(a);
    				}

    			
    		}
    	}return num;
    }
}


//24.10.31重新做


package 力扣热题100;

import java.util.List;

public class L15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> threeSum(int[] nums)
	 {
		 int n=nums.length;
		 Arrays.sort(nums);
		 int i=0;
		 int j=0;
		 int k=0;
		 List<List<Integer>> ans=new ArrayList<List<Integer>>();
		 for(i=0;i<n;i++)
		 {
			 if(i>0&&nums[i]==nums[i-1])
			 {
				 continue;
			 }
			 k=n-1;
			 for(j=i+1;j<n;j++)
			 {
				 if(j>i+1&&nums[j]==nums[j-1])
				 {
					 continue;
				 }
				 while(j<k&&nums[k]+nums[j]+nums[i]>0)
				 {
					 k--;
					 if(j==k)
					 {
						 break;
					 }
				 }
				 if(j==k)
				 {
					 break;
				 }
				 if(nums[j]+nums[k]+nums[i]==0)
				 {
					 List<Integer> temp=new ArrayList<>();
					 temp.add(nums[i]);
					 temp.add(nums[j]);
					 temp.add(nums[k]);
					 ans.add(temp);
				 }
			 }
		 }
		 return ans;
	 }

}






//999_16:最接近的三数之和
import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, 
    		                   String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}


//999_17:电话号码的字母组合
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}



import java.util.ArrayList;  
import java.util.List;  




class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> combinations=new ArrayList<String>();
    	if(digits.length()==0)
    	{
    		return combinations;
    	}
    	Map<Character,String> map=new HashMap<Character,String>();
    	map.put('2',"abc");
    	map.put('3',"def");
    	map.put('4',"ghi");
    	map.put('5',"jkl");
    	map.put('6',"mno");
    	map.put('7',"pqrs");
    	map.put('8',"tuv");
    	map.put('9',"wxyz");
    	backtrack(combinations,new StringBuffer(),map,0,digits);
    	return combinations;
    }
    public void backtrack(List<String> combinations,StringBuffer combination,Map<Character,String>map,int index,String digits)
    {
    	if(index==digits.length())
    	{
    		combinations.add(combination.toString());
    	}
    	else
    	{
    		String letters=map.get(digits.charAt(index));
        	for(int i=0;i<letters.length();i++)
        	{        		
        		combination.append(letters.charAt(i));
        		backtrack(combinations,combination,map,index+1,digits);
        		combination.deleteCharAt(index);
        	}    		
    	}

    }
}




//999_18:四数之和
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int first, second, third, last;
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 4)
            return result;
        Arrays.sort(nums);
        for (first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                for (third = second + 1; third < n - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1])
                        continue;
                    last = n - 1;
                    while (last > third && nums[last] + nums[third] > target - nums[first] - nums[second]) {
                        last--;
                    }
                    if (last > third && nums[last] + nums[third] == target - nums[first] - nums[second]) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[last]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
//999_19:删除链表的倒数第 N 个结点
import java.util.ArrayList;  
import java.util.List;  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=new ListNode();
        curr=head;
        int m=0,j=0;
        while(curr!=null)
        {
            curr=curr.next;
            m++;      //总结点数为i+1；
        }
        ListNode c=new ListNode();
        c=dummy;
        while(j!=m-n)
        {
            c=c.next;
            j++;
        }
        c.next=c.next.next;
        return dummy.next;
    }
}



//24.11.1重做


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map=new HashMap<>();
        int count=0;
        ListNode p=new ListNode(0);
        p.next=head;
        while(head!=null)
        {
            count++;
        	map.put(count,head);        	
        	head=head.next;
        }
        int target=count-n+1;
        if(count-n+1==1)
        {
        	p.next=p.next.next;
        	return p.next;
        }
        else
        {
        	map.get(count-n+1-1).next=map.get(count-n+1).next;
        	return p.next;
        }
    }
}







//999_20:有效的括号
//    当栈 stack为空的，因为还没有任何元素被推入栈中，调用 stack.peek() 
//    将会抛出一个 EmptyStackException错误
import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public boolean isValid(String s) {
    	Map<Character,Character> map=new HashMap<Character,Character>();
    	map.put(')','(');
    	map.put(']','[');
    	map.put('}','{');
    	Stack<Character> stack=new Stack<Character>();
    	int n=s.length();
    	for(int i=0;i<n;i++)
    	{
    		if(map.containsKey(s.charAt(i)))
    		{
    			if(!stack.isEmpty()&&stack.peek()==map.get(s.charAt(i)))
    			{
    				stack.pop();
    			}
    			else
    			{
    				return false;
    			}
    		}
    		else
    		{
        		stack.push(s.charAt(i));    			
    		}

    	}
    	if(stack.isEmpty())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
}
}
// 999_21:合并两个有序链表
import java.util.ArrayList;  
import java.util.List;  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}


//24.11.1重做



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {                
        ListNode head=new ListNode(0);
        ListNode begin=head;
        while(list1!=null&&list2!=null)
        {
        	if(list1.val<list2.val)
        	{
        		head.next=list1;        		
        		list1=list1.next;
        	}
        	else
        	{
        		head.next=list2;
        		list2=list2.next;
        	}
        	head=head.next;
        }
        if(list1!=null)
        {
        	head.next=list1;
        }
        else
        {
        	head.next=list2;
        }return begin.next;
    }
}




//999_22:括号生成
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<String>();
    	StringBuffer combination =new StringBuffer();
    	backtrack(res,combination,0,0,n);
        return res;
    }
    public void backtrack(List<String> combinations,StringBuffer combination,int left,int right,int max)
    {
    	if(combination.length()==max*2)
    	{
    		combinations.add(combination.toString());
    		return;
    	}
    	if(left<max)
    	{
    		combination.append('(');
    		backtrack(combinations,combination,left+1,right,max);
    		combination.deleteCharAt(combination.length()-1);
    	}
    	if(right<left)
    	{
    		combination.append(')');
    		backtrack(combinations,combination,left,right+1,max);
    		combination.deleteCharAt(combination.length()-1);
    	}
    }
}



//999_23. 合并 K 个升序链表


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	return merge(lists,0,lists.length-1);
    }
    
    public ListNode merge(ListNode[] lists,int low,int high)
    {
    	if(low==high)
    	{
    		return lists[low];
    	}
    	if(low>high)
    	{
    		return null;
    	}
    	int mid=(low+high)>>1;
    	return mergeTwoLists(merge(lists,low,mid),merge(lists,mid+1,high));
    }
    
    public ListNode mergeTwoLists(ListNode a,ListNode b)
    {
    	if(a==null||b==null)
    	{
    		return (a==null)?b:a;
    	}
    	ListNode head=new ListNode(0);
    	ListNode tail=head;
    	ListNode pointa=a;
    	ListNode pointb=b;
    	while(pointa!=null&&pointb!=null)
    	{
    		if(pointa.val<pointb.val)
    		{
    			tail.next=pointa;
    			pointa=pointa.next;
    		}
    		else
    		{
    			tail.next=pointb;
    			pointb=pointb.next;
    		}
    		tail=tail.next;  		
    	}
    	tail.next=(pointa==null)?pointb:pointa;
    	return head.next;
    }
}


///////////////////////24.11.4 自己做出来的对的


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        int numofnull=0;
        int sum=0;        
        for(int i=0;i<n;i++)
        {
        	if(lists[i]==null)
        	{
        		numofnull++;
        	}
        	else
        	{
        		ListNode x=lists[i];
            	while(x!=null)
            	{
            		sum++;
            		x=x.next;
            	}	
        	}
       	
        }
        
        if(n==0||numofnull==n)
        {
        	return null;
        }
        ListNode[] pointer=new ListNode[n];
        for(int i=0;i<n;i++)
        {
        	pointer[i]=lists[i];
        }        
        int count=0;
        ListNode ans=new ListNode(0);
        ListNode endofans=ans;
        while(count<sum)
        {
            int siteofmin=0;
        	int minValue=Integer.MAX_VALUE;
        	for(int i=0;i<n;i++)
        	{
        		if(pointer[i]==null)
        		{
        			continue;
        		}
        		else
        		{
        			if(pointer[i].val<minValue)
        			{
        				minValue=pointer[i].val;
        				siteofmin=i;        				
        			}
        		}
        	}
        	// if(pointer[siteofmin].next==null)
        	// {
        	// 	endofans.next=pointer[siteofmin];
        	// 	endofans=endofans.next;
        	// 	pointer[siteofmin]=null;
        	// }
        	// else
        	// {
            	ListNode temp=pointer[siteofmin].next;
            	pointer[siteofmin].next=null;
            	endofans.next=pointer[siteofmin];
            	endofans=endofans.next;
            	pointer[siteofmin]=temp;
        	// }
        	count++;
        }
        return ans.next;
    }
}


















//	999_24:两两交换链表中的节点
	
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    public ListNode swapPairs(ListNode head) {
	    	if(head==null||head.next==null)
	    	{
	    		return head;
	    	}
	    	ListNode newHead=head.next;
	    	head.next=swapPairs(newHead.next);
	    	newHead.next=head;
	    	return newHead;
	    }
	}
	
	
//	24.11.1重做
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    public ListNode swapPairs(ListNode head) {
	    	if(head==null||head.next==null)
	    	{
	    		return head;
	    	}
	    	else
	        {
	    		ListNode x=head.next;
	    		head.next=x.next;
	    		x.next=head;
	    		
	    		ListNode p=head;
	    		ListNode q=new ListNode(0);
	    		while(p.next!=null&&p.next.next!=null)
	    		{
	    			q=p.next;            	
	            	p.next=q.next;
	            	q.next=q.next.next;
	            	p.next.next=q;
	            	p=q;
	            	q=q.next;            	
	    		}
	    		return x;
	        	
	        }
	    }
	}
	
	
	
//999_26:删除有序数组中的重复项
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Character> map=new HashMap<Integer,Character>();
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                nums[count++]=nums[i];
                map.put(nums[i],'k');
            }
 
        }
        return --count;
    }
}


//999_27：移除元素
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=val)
            {
                nums[count++]=nums[i];
            }
        }
        return count;
   
    }
}

//999_28：找出字符串中第一个匹配项的下标
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int strStr(String haystack, String needle) {
        int n1=haystack.length();
        int n2=needle.length();
        int count;
        for(int i=0;i<=n1-n2;i++)
        {
            count=0;
                while(count<n2&&(i+count)<n1&&haystack.charAt(i+count)==needle.charAt(count))
                {
                    count++;
                }
                if(count==n2)
                {
                    return i;
                }         
        }
        return -1;
    }
}


//999——29：两数相除

class Solution {
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        
        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/divide-two-integers/solutions/1041939/liang-shu-xiang-chu-by-leetcode-solution-5hic/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//999_31:下一个排列
class Solution {
    public void nextPermutation(int[] nums) {
    	int left=nums.length-2;
    	while(left>=0&&nums[left]>=nums[left+1])
    	{
    		left--;
    	}
        if(left>=0)
        {
        	int right=nums.length-1;
    	while(right>=0&&nums[right]<=nums[left])
    	{
    		right--;
    	}
    	swap(nums,left,right);
        }
            reverse(nums,left+1,nums.length-1);
    }
    public void reverse(int []nums,int low,int high)
    {
    	while(low<high)
    	{
    		swap(nums,low,high);
    		low++;
    		high--;
    	}
    }
    public void swap(int[] nums,int x,int y)
    {
    	int temp=nums[x];
    	nums[x]=nums[y];
    	nums[y]=temp;
    }
}

//999_35:搜索插入位置
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int j=0;
        while(j<n&&nums[j]!=target)
        {
            j++;
        }
        if(j<n)
        {
            return j;
        }
        else
        {
            int i=0;
            while(i<n&&nums[i]<=target)
            {
                i++;
            }
             int[] newnums=new int [n+1];
            {
                for(int k=0;k<i;k++)
                {
                    newnums[k]=nums[k];
                }
                for(int m=i+1;m<n+1;m++)
                {
                    newnums[m]=nums[m-1];
                }
                newnums[i]=target;
            }
            return i;
        }
    }
}



import java.util.ArrayList;  
import java.util.List;  //999_36:有效的速度
class Solution {
    public boolean isValidSudoku(char[][] board) {
    	int[][] line=new int[9][9];
    	int[][] row=new int[9][9];
    	int[][][] kun=new int[3][3][9];
    	for(int i=0;i<9;i++)
    	{
    		for(int j=0;j<9;j++)
    		{
				char c=board[i][j];
    			
    			if(c!='.')
    			{
                    int chara=c-'0'-1;
        			line[i][chara]++;
        			row[j][chara]++;
        			kun[i/3][j/3][chara]++;
        			if(line[i][chara]>1||row[j][chara]>1||kun[i/3][j/3][chara]>1)
        				return false;	
    			}
    			
    		}
    	}
    	return true;
    }
}


//999_39:组合总和
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(candidates); // 对 candidates 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }
}



//999_41:确实的第一个正数


class Solution {
    public int firstMissingPositive(int[] nums) {
     int n=nums.length;
     int mins=nums[0];
    
     int[] test=new int[n+2];
     for(int i=0;i<n;i++)
     {
    	 if(1<=nums[i]&&nums[i]<=n+1)
    	 {
    		 test[nums[i]]=1;
    	 }
     }
     int p=1;
     while(test[p]==1)
     {
    	 p++;
     }
     return p;
    }
}


//999_42:接雨水
	package 力扣热题100;

	import java.util.*;

	public class L42 {

		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			int m=s.nextInt();
			for(int i=0;i<m;i++)
			{
				int n=s.nextInt();
				int[]a=new int[n];
				for(int j=0;j<n;j++)
				{
					a[j]=s.nextInt();
				}
				System.out.println(test(a));
			}

		}
		
		public static int test(int height[]) {
			int n=height.length;
			int[] leftmax=new int[n];
			int[] rightmax=new int[n];
			leftmax[0]=height[0];
			rightmax[n-1]=height[n-1];
			for(int i=1;i<n;i++)
			{
				leftmax[i]=Math.max(leftmax[i-1], height[i]);			
			}
			for(int i=n-2;i>=0;i--)
			{
				rightmax[i]=Math.max(rightmax[i+1], height[i]);
			}
			int count=0;
			for(int i=1;i<n-1;i++)
			{
				count+=(Math.min(rightmax[i], leftmax[i])-height[i]);
			}
			return count;
	}

	//我的初步思考：从每一个柱子a开始，如果它的下一个柱子b比他矮，并且右方存在高度>=a的柱子,那么有蓄水池。


	}

//999_45. 跳跃游戏 II
import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public int jump(int[] nums) {
    	int end=0;
    	int disTance = 0;
    	int step=0;
    	int len=nums.length-1;
    	for(int i=0;i<len;i++)
    	{
    		disTance=Math.max(disTance,nums[i]+i);
    		if(i==end)
    		{
    			end=disTance; 
    			step++;
    		}
    	}
    	return step;
    }
}


//999_46:全排列

import java.util.ArrayList;  
import java.util.List;  
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	backtrack(res,new ArrayList<Integer>(),nums);
    	return res;
    }
    public void backtrack(List<List<Integer>>combinations,List<Integer>combination,int[]nums)
    {
    	if(combination.size()==nums.length)
    	{
    		combinations.add(new ArrayList<Integer>(combination));
    	}
    	else
    	{
        	for(int i=0;i<nums.length;i++)
        	{
        		if(combination.contains(nums[i]))
        		{
        			continue;
        		}
        		combination.add(nums[i]);
        		backtrack(combinations,combination,nums);
            	combination.remove(combination.size()-1);
        	}
    	}
    }
}



import java.util.ArrayList;  
import java.util.List;  



	class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	
    }
    public void backTrack(int nums[],List<List<Integer>> arr)
    {
    	int len=nums.length;
    	list a=new Arraylist();
    	for(int i=0;i<len;i++)
    	{
    		a.append(nums[i]+'0');
    	}
    }
}
	
//	999_47:全排列 II
	import java.util.ArrayList;  
	import java.util.List;  
		class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	    	Arrays.Sort(nums);
	    	int n=nums.lenth();
	    	int count=0;	    
	    	List<List<Integer>>res = new ArrayList<List<Integer>>();
	    	backtrack(res,new ArrayList<Integer>(combination),nums);	    	
	    	return res;
	    	
	    }
	    public void backtrack(List<List<Integer>>combinations,List<Integer>combination,int []nums)
	    {
	    	nums.Sort();
	    	if(combination.size()==nums.size())
	    	{
	    		combinations.add(new ArrayList<Integer>(combination));
	    	}
	    	else
	    	{
	    		for(int j=0;j<num.length();j++)
	    		{
	    			if(j>0&&nums[j]==nums[j-1])
	    			{
	    				continue;
	    			}
	    			combination.append(nums[i]);
	    			backtrack(combinations,combination,nums);
	    			combination.remove(combination.size()-1);
	    		}
	    	}
	    }
	}
		import java.util.ArrayList;  
		import java.util.List;  
		class Solution {  
		    // 访问标记数组，用于记录某个元素是否已经被访问过  
		    boolean[] vis;  
		  
		    // 主函数，用于生成不重复的全排列  
		    public List<List<Integer>> permuteUnique(int[] nums) {  
		        // 初始化结果列表  
		        List<List<Integer>> ans = new ArrayList<List<Integer>>();  
		        // 初始化当前排列列表  
		        List<Integer> perm = new ArrayList<Integer>();  
		        // 初始化访问标记数组  
		        vis = new boolean[nums.length];  
		        // 对数组进行排序，以便后续去重  
		        Arrays.sort(nums);  
		        // 调用回溯函数，生成全排列  
		        backtrack(nums, ans, 0, perm);  
		        // 返回结果  
		        return ans;  
		    }  
		  
		    // 回溯函数，用于生成全排列  
		    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {  
		        // 如果当前排列的长度等于数组长度，说明找到了一个全排列  
		        if (idx == nums.length) {  
		            // 将当前排列添加到结果列表中  
		            ans.add(new ArrayList<Integer>(perm));  
		            return;  
		        }  
		        // 遍历数组  
		        for (int i = 0; i < nums.length; ++i) {  
		            // 如果当前元素已经被访问过，或者当前元素与前一个元素相同且前一个元素未被访问过，则跳过  
		            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {  
		                continue;  
		            }  
		            // 将当前元素添加到当前排列中  
		            perm.add(nums[i]);  
		            // 标记当前元素为已访问  
		            vis[i] = true;  
		            // 递归调用，继续生成下一个位置的元素  
		            backtrack(nums, ans, idx + 1, perm);  
		            // 回溯，标记当前元素为未访问，以便生成其他排列  
		            vis[i] = false;  
		            // 从当前排列中移除最后一个元素，以便生成其他排列  
		            perm.remove(idx);  
		        }  
		    }  
		}		
		
		
		import java.util.ArrayList;  
		import java.util.List;  
		class Solution {
		    boolean[] vis;

		    public List<List<Integer>> permuteUnique(int[] nums) {
		        List<List<Integer>> ans = new ArrayList<List<Integer>>();
		        List<Integer> perm = new ArrayList<Integer>();
		        vis = new boolean[nums.length];
		        Arrays.sort(nums);
		        backtrack(nums, ans, 0, perm);
		        return ans;
		    }

		    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
		        if (idx == nums.length) {
		            ans.add(new ArrayList<Integer>(perm));
		            return;
		        }
		        for (int i = 0; i < nums.length; ++i) {
		            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
		                continue;
		            }
		            perm.add(nums[i]);
		            vis[i] = true;
		            backtrack(nums, ans, idx + 1, perm);
		            vis[i] = false;
		            perm.remove(idx);
		        }
		    }
		}
//999_48:旋转图像
		import java.util.ArrayList;  
		import java.util.List;  
		class Solution {
		    public void rotate(int[][] matrix) {
		        int row=matrix.length;
		        int col=matrix[0].length;
		        int[][] a=new int[row][col];
		        for(int i=0;i<row;i++)
		        {
		            for(int j=0;j<col;j++)
		            {
		                a[i][j]=matrix[i][j];
		            }
		        }
		        for(int m=0;m<row;m++)
		        {
		            for(int n=0;n<col;n++)
		            {
		                matrix[n][row-1-m]=a[m][n];
		            }
		        }
		    }
		}
		
		/////////////24.10.31重做
		class Solution {
		    public void rotate(int[][] matrix) {
		    	int n=matrix.length;
		    	int[][] dp=new int[n][n];
		    	for(int i=0;i<n;i++)
		    	{
		    		for(int j=0;j<n;j++)
		    		{
		    			dp[i][j]=matrix[i][j];
		    		}
		    	}
		    	for(int i=0;i<n;i++)
		    	{
		    		for(int j=0;j<n;j++)
		    		{
		    			matrix[j][n-i-1]=dp[i][j];
		    		}
		    	}
		    	
		    }
		}
		
//999_49:字母异位词分组
		import java.util.ArrayList;  
		import java.util.List; 
		
		class Solution {
		    public List<List<String>> groupAnagrams(String[] strs) {
		    	Map<String,List<String>> map=new HashMap<String,List<String>>();
		    	for(String str:strs)
		    	{
		    		char[] arr=str.toCharArray();
		    		Arrays.sort(arr);
		    		String m=new String(arr);
		    		if(!map.containsKey(m))
		    		{
                        List<String> list=new ArrayList<String>();
                        list.add(str);
		    			map.put(m,list);
		    		}
		    		else
		    		{
		    			List<String> list=new ArrayList<String>(map.get(m));
		    			list.add(str);
		    			map.put(m,list);
		    		}		    		
		    	}
		    	return new ArrayList<List<String>>(map.values());
		    }
		}
		
		
/////////////////////////////////////////////////////////		
		class Solution {
		    public List<List<String>> groupAnagrams(String[] strs) {
		        int len=strs.length;
		        int count=strs[0].length();
		        Boolean vir[]=new Boolean[len];
		        List<List<String>> a=new ArrayList<List<String>>();
		        String[] b=new String[len];
		        for(int j=0;j<len;j++)
		        {
		        	b[j]=strs[j];
		        }
		        for(int k=0;k<len;k++)
		        {
		        	Arrays.sort(b[k]);
		        }
		        for(int i=0;i<len;i++)
		        {
		        	List<String> c=new ArrayList();
		        	if(vir[i]==false)
		        	{
			        	c.add(strs[i]);
			        	vir[i]=true;
		        	}
		        	for(int t=i;t<len;t++)
		        	{
		        		if(b[t].equals(b[i])&&vir[t]==false)
		        		{
		        			c.add(strs[t]);
		        			vir[t]=true;
		        		}
		        	}
		        	a.add(c);
		        }
		        	return a;	        		        		    	      
		    }
		}		
			
		
		
		
///////////////////////////////////////////////////////////////////////////
		class Solution {
		    public List<List<String>> groupAnagrams(String[] strs) {
		        int len=strs.length;
		        int count=strs[0].length();
		        Boolean vir[]=new Boolean[len];
		        List<List<String>> a=new ArrayList<List<String>>();
		        String[] b=new String[len];
		        for(int j=0;j<len;j++)
		        {
		        	b[j]=strs[j];
		        }
		        for(int k=0;k<len;k++)
		        {
		        	Arrays.sort(b[k]);
		        }
		        for(int i=0;i<len;i++)
		        {
		        	List<String> c=new ArrayList();
		        	if(vir[i]==false)
		        	{
			        	c.add(strs[i]);
			        	vir[i]=true;
		        	}
		        	for(int t=i;t<len;t++)
		        	{
		        		if(b[t].equals(b[i])&&vir[t]==false)
		        		{
		        			c.add(strs[t]);
		        			vir[t]=true;
		        		}
		        	}
		        	a.add(c);
		        }
		        	return a;	        		        		    	      
		    }
		}		
		
		
		
		class Solution {  
		    // 定义一个公共方法，接受一个字符串数组作为参数，返回一个列表的列表，其中每个内部列表包含一组同源词  
		    public List<List<String>> groupAnagrams(String[] strs) {  
		        // 创建一个HashMap，键是排序后的字符串（作为同源词的唯一标识），值是同源词组成的列表  
		        Map<String, List<String>> map = new HashMap<String, List<String>>();  
		          
		        // 遍历输入的字符串数组  
		        for (String str : strs) {  
		            // 将当前字符串转换为字符数组  
		            char[] array = str.toCharArray();  
		              
		            // 对字符数组进行排序，排序后的字符串将作为HashMap的键  
		            Arrays.sort(array);  
		              
		            // 使用排序后的字符数组创建一个新的字符串，作为HashMap的键  
		            String key = new String(array);  
		              
		            // 从HashMap中获取与当前键关联的值列表，如果不存在则返回一个新的ArrayList  
		            List<String> list = map.getOrDefault(key, new ArrayList<String>());  
		              
		            // 将未排序的原始字符串添加到对应的列表中  
		            list.add(str);  
		              
		            // 将更新后的列表与键关联起来，并放回HashMap中  
		            // 注意：这一步实际上是可选的，因为map.getOrDefault已经返回了引用的列表，但在某些情况下明确更新它是个好习惯  
		            map.put(key, list);  
		        }  
		          
		        // 将HashMap中所有的值（即所有的列表）转换为一个新的ArrayList，并返回这个列表的列表  
		        // 注意：这里使用了ArrayList的构造函数，它接受一个Collection作为参数  
		        return new ArrayList<List<String>>(map.values());  
		    }  
		}		
		
		
////////////////////////////热题100重做
		
		package 力扣热题100;

		import java.util.Arrays;
		import java.util.List;
		import java.util.Map;

		public class L49 {

			public static void main(String[] args) {
				// TODO Auto-generated method stub

			}
			
			
			public List<List<String>> groupAnagrams(String[] strs) {
				int n=strs.length;
				List<List<String>> ans=new ArrayList<List<String>>();
				boolean [] dp=new boolean[n];//标记这个位置是否已经被使用了
				for(int i=0;i<n;i++)
				{
					if(dp[i]==true)
					{
						continue;
					}
					List<String> temp=new ArrayList<String>();
					dp[i]=true;
					temp.add(strs[i]);
					for(int j=i+1;j<n;j++)			
					{
						if(dp[j]==true)
						{
							continue;
						}
						if(test(strs[i],strs[j])==true)
						{
							temp.add(strs[j]);
							dp[j]=true;
						}
					}
					ans.add(temp);
				}
				return ans;       
		    }
			
			public static boolean test(String a,String b)
			{
				int n1=a.length();
				int n2=b.length();
				if(n1!=n2)
				{
					return false;
				}
				
				char[] a1=a.toCharArray();
				char[] b1=b.toCharArray();
				Arrays.sort(a1);
				Arrays.sort(b1);
				
				for(int i=0;i<n1;i++)
				{
					if(a1[i]!=b1[i])			
					{
						return false;
					}
					
				}
				return true;
			}
			
		}

		
		
//		53：最大子数组和
		class Solution {
		    public int maxSubArray(int[] nums) {
		        int n = nums.length;
		        int pre = 0;
		        int maxValue = nums[0];
		        for (int i = 0; i < n; i++) {
		            pre = Math.max(nums[i], nums[i] + pre);
		            maxValue = Math.max(pre, maxValue);
		        }
		        return maxValue;
		    }

		}
		
//////////////////////////24.10.31重新做		
		class Solution {
		    public int maxSubArray(int[] nums) {
		        int n=nums.length;
		        int pre=0;
		        int ans=nums[0];
		        for(int i=0;i<n;i++)
		        {
		        	pre=Math.max(pre+nums[i], nums[i]);
		        	ans=Math.max(pre, ans);
		        }
		    	return ans;
		    }
		}
//		54：螺旋矩阵
		
		import java.util.ArrayList;  
		import java.util.List;  
		  
		class Solution {  
		    public List<Integer> spiralOrder(int[][] matrix) {  
		        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {  
		            return new ArrayList<>();  
		        }  
		  
		        int m = matrix.length;  
		        int n = matrix[0].length;  
		        List<Integer> result = new ArrayList<>();  
		        Boolean[][] visited = new Boolean[m][n];  
		  
		        for (int i = 0; i < m; i++) {  
		            for (int j = 0; j < n; j++) {  
		                visited[i][j] = false;  
		            }  
		        }  
		  
		        int top = 0, bottom = m - 1, left = 0, right = n - 1;  
		  
		        while (top <= bottom && left <= right) {  
		            // Traverse right  
		            for (int i = left; i <= right; i++) {  
		                result.add(matrix[top][i]);  
		                visited[top][i] = true;  
		            }  
		            top++;  
		  
		            // Traverse down  
		            for (int i = top; i <= bottom; i++) {  
		                result.add(matrix[i][right]);  
		                visited[i][right] = true;  
		            }  
		            right--;  
		  
		            if (top <= bottom) {  
		                // Traverse left  
		                for (int i = right; i >= left; i--) {  
		                    result.add(matrix[bottom][i]);  
		                    visited[bottom][i] = true;  
		                }  
		                bottom--;  
		            }  
		  
		            if (left <= right) {  
		                // Traverse up  
		                for (int i = bottom; i >= top; i--) {  
		                    result.add(matrix[i][left]);  
		                    visited[i][left] = true;  
		                }  
		                left++;  
		            }  
		        }  
		  
		        return result;  
		    }  
		}
		
		
		//24.10.31重做
		class Solution {
		    public List<Integer> spiralOrder(int[][] matrix) {
		    	int m=matrix.length;
		    	int n=matrix[0].length;
		        if(m==0||matrix==null)
		        {
		            return new ArrayList<Integer>();
		        }
		    	Boolean[][] dp=new Boolean[m][n];
		        for(Boolean a[]:dp)
		        {
		            for(int i=0;i<n;i++)
		            {
		                a[i]=false;
		            }
		        }
		    	int row=0;
		    	int col=0;
		    	int count=0;
		    	List<Integer> ans=new ArrayList<>();
		    	ans.add(matrix[row][col]);
				dp[row][col]=true;
				count++;
		    	while(count<m*n)
		    	{    		
		    		while(col+1<n&&dp[row][col+1]==false)
		    		{
		    			col++;
		    			ans.add(matrix[row][col]);
		    			dp[row][col]=true;
		    			count++;
		    		}
		    		
		    		while(row+1<m&&dp[row+1][col]==false)
		    		{
		    			row++;
		    			ans.add(matrix[row][col]);
		    			dp[row][col]=true;
		    			count++;
		    		}
		    		
		    		while(col-1>=0&&dp[row][col-1]==false)
		    		{
		    			col--;
		    			ans.add(matrix[row][col]);
		    			dp[row][col]=true;
		    			count++;
		    		}
		    		
		    		while(0<=row-1&&dp[row-1][col]==false)
		    		{
		    			row--;
		    			ans.add(matrix[row][col]);
		    			dp[row][col]=true;
		    			count++;
		    		}
		    	}
		    	return ans;
		    }
		}




		
//		55:跳跃游戏
		
		class Solution {
		    public boolean canJump(int[] nums) {
		    	int rightmost=0;
		    	int n=nums.length;
		    	for(int i=0;i<n;i++)
		    	{
		    		if(rightmost>=i)
		    		{
		    		   rightmost=Math.max(rightmost,i+nums[i]);	
		    		}
		    		
		    		if(rightmost>=n-1)
		    		{
		    			return true;
		    		}
		    	}
		    	return false;
		    }
		}
		
		
//		999_56:合并区间
		
//		class Solution {
//		    public int[][] merge(int[][] intervals) {
//		    	int m=intrevals.length;
//		    	int [][]a=new int[m][2];
//		    	Boolean[] vis=new Boolean(m);
//		    	for(int i=0;i<m;i++)
//		    	{
//		    		for(int j=i+1;j<m;j++)
//		    		{
//		    			if(intervals[i][0]<=intervals[j][0]<=intervals[i][1])
//		    			{
//		    				if(intervals[j][1]<=intervals[i][1])
//		    				{
//		    					a.add(new ArrayList<Integer>(intervals[i][0],intervals[i][1]));
//		    				}
//		    				else
//		    				{
//		    					a.add(new ArrayList<Integer>(intervals[i][0],intervals[j][1]));
//		    				}
//	    					vis[i]=true;
//	    					vis[j]=true;
//		    			}
//		    			if(intervals[i][0]<=intervals[j][0]<=intervals[i][1])
//		    			{
//		    				if(intervals[j][1]<=intervals[i][1])
//		    				{
//		    					a.add(new ArrayList<Integer>[i][0],intervals[i][1]);
//		    				}
//		    				else
//		    				{
//		    					a.add(new ArrayList<Integer>[i][0],intervals[j][1]);
//		    				}
//		    				vis[i]=true;
//		    				vis[j]=true;
//		    			}
//		    		}
//		    	}
//		    	
//		    }
//		}
		
		class Solution {
		    public int[][] merge(int[][] intervals) {
		    	int n=intervals.length;
		    	if(intervals.length==0)
		    	{
		    		return new int[0][2];
		    	}
		    	Arrays.sort(intervals,new Comparator<int[]>()
		    	{
		    		public int compare(int []interval1,int []interval2)
		    		{
		    			return interval1[0]-interval2[0];
		    		}
		    	});
		    	int L=0;
		    	int R=0;
		    	List<int[]> merged=new ArrayList<int []>();
		    	for(int i=0;i<n;i++)
		    	{
		    		 L=intervals[i][0];
		    		 R=intervals[i][1];
		    		if(merged.size()==0||merged.get(merged.size()-1)[1]<L)
		    		{
		    			merged.add(new int[] {L,R});
		    		}
		    		else
		    		{
		    			merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
		    		}
		    	}
		    	return merged.toArray(new int[merged.size()][]);
		    }
		}
		
		
		
		
/////////////////////////////////24.10.31重新做
		
		
		class Solution {
		    public int[][] merge(int[][] intervals) {
		        int n=intervals.length;
		        if(n==0)
		        {
		        	return new int[0][2];
		        }
		        List<int[]>list=new ArrayList<>();
		        Arrays.sort(intervals,new Comparator<int[]>(){
		        	public int compare(int[]interval1,int[]interval2)
		        	{
		        		return interval1[0]-interval2[0];
		        	}
		        });
		        list.add(intervals[0]);
		        for(int i=1;i<n;i++)
		        {
		        	int left=intervals[i][0];
		        	int right=intervals[i][1];
		        	if(left>list.get(list.size()-1)[1])
		        	{
		        		list.add(intervals[i]);
		        	}
		        	else
		        	{
		        		list.get(list.size()-1)[1]=Math.max(right,list.get(list.size()-1)[1]);
		        	}
		        }
		        return list.toArray(new int[list.size()][]);
		    }
		}




		
//		999_57. 插入区间
		import java.util.ArrayList;  
		import java.util.List;  
		  
		class Solution {  
		    public int[][] insert(int[][] intervals, int[] newInterval) {  
		        int n = intervals.length;  
		        int count1 = 0;  
		        int count2 = 0;  
		        int L = newInterval[0];  
		        int R = newInterval[1];  
		        List<int[]> merged = new ArrayList<>();  
		          
		        // 找到新区间应该插入的位置  
		        while (count1 < n && intervals[count1][1] < L) {  
		            count1++;  
		        }  
		          
		        // 添加插入点之前的区间  
		        for (int i = 0; i < count1; i++) {  
		            merged.add(intervals[i]);  
		        }  
		          
		        // 合并重叠的区间  
		        while (count1 < n && intervals[count1][0] <= R) {  
		            L = Math.min(L, intervals[count1][0]);  
		            R = Math.max(R, intervals[count1][1]);  
		            count1++;  
		        }  
		        merged.add(new int[]{L, R});  
		          
		        // 添加剩余的区间  
		        for (int i = count1; i < n; i++) {  
		            merged.add(intervals[i]);  
		        }  
		          
		        // 转换为数组并返回  
		        return merged.toArray(new int[merged.size()][]);  
		    }  
		}
		
//999_58:最后一个单词的长度
// 各种越界错误   麻了。。。。。。。。。。。。。。。。。。。。草
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
            return(n-1-nulList[n1-1]);//  n1为0时，会出现越界错误。
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



//999_61:旋转链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	ListNode a=head;
    	int len=0;
    	while(a.next!=null)
    	{
    		len++;
    		a=a.next;
    	}
    	ListNode tail=a;
    	int m=k%(len+1);
    	ListNode b=head;
    	int count=0;
    	while(count<m)
    	{
    		b=b.next;
    		count++;
    	}
    	ListNode newHead=b;
    	b.next=null;
    	tail.next=head;
    	return newHead;
    	
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null||k==0)
    	{
    		return head;
    	}
    	ListNode head1=head;
    	ListNode head2=head;
    	int count=0;
    	int n=1;
    	while(head1.next!=null)
    	{
    		head1=head1.next;
    		n++;          // head1此时指向末尾结点
    	}                 //n此时为链表的总长度
    	int k1=k%n;
    	int k2=n-k1;     //新的头结点之前有k2个结点
    	while(count<k2-1)
    	{
    		head2=head2.next;
    		count++;
    	}                  //此时的head2指向第k2个结点
    	ListNode newHead=head2.next;
    	head2.next=null;
    	head1.next=head;
    	return newHead;
    	
    }
}



//999_62:不同路径

class Solution {
    public int uniquePaths(int m, int n) {
    	int [][]dp=new int[m][n];
    	dp[0][0]=1;
    	for(int i=1;i<n;i++)
    	{
    		dp[0][i]=dp[0][i-1];
    	}
    	for(int j=1;j<m;j++)
    	{
    		dp[j][0]=dp[j-1][0];
    	}
    	for(int i=1;i<m;i++)
    	{
    		for(int j=1;j<n;j++)
    		{
    			dp[i][j]=dp[i][j-1]+dp[i-1][j];
    		}
    	}
    	return dp[m-1][n-1];
    }
}


//999_63:不同路径


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] db=new int[m][n];
        if(obstacleGrid[0][0]==1)
        {
            return 0;
        }
        else
        {
            db[0][0]=1;
        }
        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0]==1)
            {
                for(int k=i;k<m;k++)
                {
                	db[k][0]=0;
                }
            	break;
            }
            else
            {
                db[i][0]=1;
            }
        }
        for(int j=0;j<n;j++)
        {
        	if(obstacleGrid[0][j]==1)
        	{
                for(int k=j;k<n;k++)
                {
                	db[0][k]=0;
                }
            	break;
        	}
        	else
        	{
        		db[0][j]=1;
        	}
        }
        for(int i=1;i<m;i++)
        {
        	for(int j=1;j<n;j++)
        	{
        		if(obstacleGrid[i][j]==1)
        		{
        			db[i][j]=0;
        		}
        		else
        		{
            		db[i][j]=db[i-1][j]+db[i][j-1];	
        		}
        	}
        }
        return db[m-1][n-1];
    }
}

//999_64. 最小路径和

class Solution {
    public int minPathSum(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
        int[][] minPath=new int[m][n];
        minPath[0][0]=grid[0][0];
        for(int i=1;i<m;i++)
        {
        	minPath[i][0]=minPath[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++)
        {
        	minPath[0][j]=minPath[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++)
        {
        	for(int j=1;j<n;j++)
        	{
        		minPath[i][j]=Math.min(minPath[i-1][j],minPath[i][j-1])+grid[i][j];
        	}
        }
        return minPath[m-1][n-1];
    }
}



//999_66:加一
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int [] arr=new int[n+1];
        if(n==0)
        {
            return new int[0];
        }
        if(digits[n-1]!=9)
        {
            digits[n-1]++;
            return digits;
        }
        else
        {
            int j=0;
            while(n-1-j>=0&&digits[n-1-j]==9)
            {
                digits[n-1-j]=0;
                j++;
            }
            if(n-1-j>=0)
            {
                digits[n-1-j]+=1;
                return digits;
            }
            else{
                arr[0]=1;
                for(int i=1;i<n+1;i++)
                {
                    arr[i]=0;
                }
                return arr;
            }
            
        }
    }
}

//999_67:二进制求和

//class Solution {
//    public String addBinary(String a, String b) {
//        int n1=a.length();
//        int n2=b.length();
//        int sum=0;
//        int jinwei=0;
//        int i=0;
//        if(n1>n2)
//        {
//            for(;i<n2;i++)
//            {
//                sum=a.charAt(n1-1-i)+b.charAt(n2-1-i)+jinwei;
//                a.charAt(n1-1-i)=sum%2;
//                jinwei=sum/2;
//            }
//            if(a.charAt(n1-n2-1)+jinwei<2)
//            {
//                a.charAt(n1-n2-1)+=jinwei;
//                return a;
//            }
//            else
//            {
//                int j=0;
//                while(n1-n2-1-j>=0)
//                {
//                    sum=jinwei+a[n1-n2-j-1];
//                    a[n1-n2-j-1]=sum%2;
//                    jinwei=sum/2;
//                    j++;
//                }
//                if(jinwei==0)
//                {
//                    return a;
//                }
//                else{
//                    int []arr1=new int[n1+1];
//                    for(int k=0;k<n1;k++)
//                    {
//                        arr1.charAt(0)=1;
//                        arr1.charAt(k+1)=a.charAt(k);
//                    }
//                    return arr1;
//                }
//            }
//
//        }
//        else
//        {
//            for(i=0;i<n1;i++)
//            {
//                sum=a.charAt(n1-1-i)+b.charAt(n2-1-i)+jinwei;
//                b.charAt(n2-1-i)=sum%2;
//                jinwei=sum/2;
//            }
//            if(b.charAt(n2-n1-1)+jinwei<2)
//            {
//                a.charAt(n2-n1-1)+=jinwei;
//                return b;
//            }
//            else
//            {
//            	int j=0;
//                while(n2-n1-1-j>=0)
//                {
//                    sum=jinwei+B[n2-n1-j-1];
//                    B[n2-n1-j-1]=sum%2;
//                    jinwei=sum/2;
//                    j++;
//                }
//                if(jinwei==0)
//                {
//                    return b;
//                }
//                else{
//                    int []arr1=new int[n2+1];
//                    for(int k=0;k<n1;k++)
//                    {
//                        arr1.charAt(0)=1;
//                        arr1.charAt(k+1)=b.charAt(k);
//                    }
//                    return arr1;
//                }
//            }
//
//        }
//    }
//}
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        int n1 = a.length();
        int n2 = b.length();
        int n = Math.max(n1, n2);
        int i = 0;
        while (i < n) {
            carry += (i < n1) ? (a.charAt(n1 - 1 - i) - '0') : 0;
            carry += (i < n2) ? (b.charAt(n2 - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
            i++;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
//999_69:x的平方根
class Solution {
    public int mySqrt(int x) {
        if(x==0)
        {
            return 0;
        }
    	int count=(int)Math.exp(0.5*Math.log(x));
    	return (long)(count+1)*(1+count)>x?count:count+1;
    }
}
//999_70:爬楼梯
class Solution {
    public int climbStairs(int n) {
        int p=0;
        int q=0;
        int r=1;
        for(int i=1;i<=n;i++)
        {
            p=q;
            q=r;
            r=p+q;
        }return r;
    }
}


//999_73. 矩阵置零


class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public void setZeroes(int[][] matrix) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	Boolean[][] db=new Boolean[m][n];
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                db[i][j] = false; // 初始化为false  
                if (matrix[i][j] == 0) {  
                    db[i][j] = true;  
                } 
            }
        }
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			if(matrix[i][j]==0)
    			{
    				db[i][j]=true;
    			}
    		}
    	}
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			if(db[i][j]==true)
    			{
    				for(int k=0;k<n;k++)
    				{
    					matrix[i][k]=0;
    				}
    				for(int k=0;k<m;k++)
    				{
    					matrix[k][j]=0;
    				}
    			}
    		}
    	}
    	return;
    }
}

//24.10.31重做


class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] testrow=new boolean[m];
        boolean[] testcol=new boolean[n];
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(matrix[i][j]==0)
        		{
        			testrow[i]=true;
        			testcol[j]=true;
        		}
        	}
        }
        
        for(int i=0;i<m;i++)
        {
        	if(testrow[i]==true)
        	{
        		for(int j=0;j<n;j++)
        		{
        			matrix[i][j]=0;
        		}
        	}
        }
        
        for(int j=0;j<n;j++)
        {
        	if(testcol[j]==true)
        	{
        		for(int i=0;i<m;i++)
        		{
        			matrix[i][j]=0;
        		}
        	}
        }
        
    }
}

//999_74. 搜索二维矩阵

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	if(target<matrix[0][0]||target>matrix[m-1][n-1])
    	{
    		return false;
    	}
    	int row1=0;
    	int col1=0;
    	while(row1<m&&matrix[row1][n-1]<target)
    	{
    		row1++;
    	}
    	for(int i=0;i<n;i++)
    	{
    		if(matrix[row1][i]==target)
    		{
    			return true;
    		}
    	}
    	return false;
    	
    }
}



//999_75:颜色分类


class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int pivot=0;
        for(int i=0;i<n;i++)
        {
        	if(nums[i]==0)
        	{
        		int temp=nums[i];
        		nums[i]=nums[pivot];
        		nums[pivot]=temp;
        		pivot++;
        	}
        }
        for(int i=pivot;i<n;i++)
        {
        	if(nums[i]==1)
        	{
        		int temp=nums[i];
        		nums[i]=nums[pivot];
        		nums[pivot]=temp;
        		pivot++;
        	}
        }
    }
}



//999_76:最小覆盖子串
	
	
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








//999_77. 组合

class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	backtrack(res,new ArrayList<Integer>(),1,n,k);
    	return res;
    }
    public void backtrack(List<List<Integer>>combinations,List<Integer>combination,int start,int length,int k)
    {
    	if(k==0)
    	{
    		combinations.add(new ArrayList<Integer>(combination));
    		return;
    	}
    	for(int i=start;i<=length;i++)
    	{
    		combination.add(i);
    		backtrack(combinations,combination,i+1,length,k-1);
    		combination.remove(combination.size()-1);
    	}
    }
}



//999_78:子集




class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int n=nums.length;
        backtrack(res,new ArrayList<Integer>(),nums,0,n);
        return res;
    }
    public void backtrack(List<List<Integer>>combinations,List<Integer>combination,int []nums,int start,int n)
    { 
    		combinations.add(new ArrayList<Integer>(combination));
    		for(int j=start;j<n;j++)
    		{
    			combination.add(nums[j]);
    			backtrack(combinations,combination,nums,j+1,n);
    			combination.remove(combination.size()-1);
    		}   	
    }
}


//999_79. 单词搜索
import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/word-search/solutions/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
import java.util.ArrayList;  
import java.util.List;  

class Solution {
    public boolean exist(char[][] board, String word) {

    }
}



//999——80. 删除有序数组中的重复项 II

class Solution {
    public int removeDuplicates(int[] nums) {
    	int n=nums.length;
    	if(n<=2)
    	{
    		return n;
    	}
    	int slow=2;
    	int fast=2;
    	while(fast<n)
    	{
    		if(nums[slow-2]!=nums[fast])
    		{
    			nums[slow]=nums[fast];
    			slow++;
    		}
            fast++;
    	}
    	return slow;
    }
}






//999_81:搜索旋转排序数组 II


class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==0||nums==null)
        {
            return false;
        }
        int low=0;
        int high=n-1;
    }
}

//999_83:删除排序链表中的重复元素
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	ListNode a=head;
    	a=head;
    	if(a==null)
    	{
    		return null;
    	}
    	while(a.next!=null)
    	{
    		if(!map.containsKey(a.val))
    		{
    			map.put(a.val,1);    			
    		}
    		else
    		{
    			a=a.next;
    		}
    	}
    	if(map.containsKey(a.val))
    	{
    		a=null;
    	}
    	else
    	{
    		map.put(a.val,1);
    	}
    }
}



//999_86. 分隔链表
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(0);
        ListNode head2=new ListNode(0);
        ListNode cur1=head1;
        ListNode cur2=head2;
        ListNode cur=head;
        while(cur!=null)
        {
            if(cur.val<x)
            {
                cur1.next=cur;
                cur1=cur1.next;
                cur=cur.next;
            }
            else
            {
                cur2.next=cur;
                cur2=cur2.next;
                cur=cur.next;
            }
        }
        cur2.next=null;
        cur1.next=head2.next;
        return head1.next;
    }
}



//999_88:合并两个有序数组
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums3=new int[m+n];
        int i=0,j=0,count=0;
        while(i<m&&j<n)
        {      
            if(nums1[i]<nums2[j])
            {
                nums3[count++]=nums1[i++];
            }
            else
            {
                nums3[count++]=nums2[j++];
            }
            
        }
        if(i==m)
            {
                while(j<n)
                {
                    nums3[count++]=nums2[j++];
                }
            }
            if(j==n)
            {
                while(i<m)
                {
                    nums3[count++]=nums1[i++];
                }
            }
        for(int k=0;k<m+n;k++)
        {
            nums1[k]=nums3[k];
        }
        
    }
}、


//999_93:复原ip地址





//999_94:二叉树的中序遍历
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> arr=new ArrayList<Integer>();
    	inorder(root,arr);
    	return arr;
    }
    
    public void inorder(TreeNode root,List<Integer> arr) {
    	if(root==null)
    	{
    		return;
    	}
    	inorder(root.left,arr);
    	arr.add(root.val);
    	inorder(root.right,arr);
    }
}
    


////24.11.1重刷


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        test(root,ans);
        return ans;
    }	
    
    public static void test(TreeNode root,List<Integer> ans)
    {
    	if(root==null)
    	{
    		return;
    	}
    	test(root.left, ans);
    	ans.add(root.val);    	
    	test(root.right,ans);    	    
    }
}

//999_95:不同的二叉搜索树



class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/unique-binary-search-trees-ii/solutions/339143/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




//999_101:对称二叉树

    
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root,root);
	}
    public boolean isSymmetric(TreeNode root1,TreeNode root2) {
        if(root1==null&&root2==null)
        return true;
        if(root1==null||root2==null)
        return false;
        if(root1.left.val!=root2.right.val||root2.left.val!=root1.right.val)
        {
            return false;
        }
        else
        {
        	return isSymmetric(root.left,root.right);       	
        }        
      
    }

}



//24.11.4重刷


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p,TreeNode q)
    {
    	if(p==null&&q==null)
    	{
    		return true;
    	}
    	if(p==null||q==null)
    	{
    		return false;
    	}
    	return(p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left));
    }
}

//999_102:二叉树的层序遍历


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null)
        {
        	return ans;
        }
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
        	List<Integer> floor=new ArrayList<Integer>();
            int length=queue.size();
        	for(int i=1;i<=length;i++)
        	{
        		TreeNode a=queue.poll();
        		floor.add(a.val);
        		if(a.left!=null)
        		{
        			queue.offer(a.left);
        		}
        		if(a.right!=null)
        		{
        			queue.offer(a.right);
        		}
        	}
        	ans.add(floor);
        }
        return ans;
    }
}


//999_104:二叉树的最大深度
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)+1);
    }
}
//////////////////////////24.11.4重做


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxdep(root,0);
        
    }
    public int maxdep(TreeNode root,int depth)
    {
    	if(root==null)
    	{
    		return depth;
    	}
    	return Math.max(maxdep(root.left,depth+1), maxdep(root.right,depth+1));
    }
}




//105. 从前序与中序遍历序列构造二叉树


//999_108:将有序数组转换为二叉搜索树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
} 

//////////////////////////////24.11.5重刷

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return test(0,nums.length-1,nums);
    }
    public TreeNode test(int left,int right,int nums[])
    {
    	if(left>right)
    	{
    		return null;
    	}
    	int mid=(left+right)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	root.left=test(left,mid-1,nums);
    	root.right=test(mid+1,right,nums);
    	return root;
    }
}

//999_110:平衡二叉树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(root==null)
    	{
    		return true;
    	}
    	return (Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right));

    }
    public int maxDepth(TreeNode root)
    {
    	if(root==null)
    	{
    		return 0;
    	}
    	return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
    
//999_111:二叉树的最小深度
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null&&root.right==null)
        {
            return 1;
        }
        if(root.left==null)
        {
            return minDepth(root.right)+1;
        }
          if(root.right==null)
        {
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}  

//999_112:路径总和

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return false;
        }
        if(root.left==null&&root.right==null)
        {
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}

//999_113:路径总和II


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	backtrack(res,new ArrayList<Integer>(),targetSum,0,root);
    	return res;
    }
    public void backtrack(List<List<Integer>> combinations,List<Integer>combination,int target,int sum,TreeNode root)
    {
    	if(root==null)
    	{
    		return;
    	}
    	combination.add(root.val);
    	sum+=root.val;
    	if(root.left==null&&root.right==null&&sum==target)
    	{
    		combinations.add(new ArrayList<Integer>(combination));
    	}
    	
    	backtrack(combinations,combination,target,sum,root.left);
    	backtrack(combinations,combination,target,sum,root.right);
    	combination.remove(combination.size()-1);
    	
    }
}


//999_118:杨辉三角

//999_121:买卖股票的最佳时机
class Solution {
    public int maxProfit(int[] prices) {
    	int minPrice=Integer.MAX_VALUE;
    	int maxProfit=0;
    	for(int i=0;i<prices.length;i++)
    	{
    		if(prices[i]<minPrice)
    		{
    			minPrice=prices[i];
    		}
    		if(prices[i]-minPrice>maxProfit)
    		{
    			maxProfit=prices[i]-minPrice;
    		}
    	}
    	return maxProfit;
    }
}












class Solution {  
    // 主函数，用于找到两个有序数组的中位数  
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {  
        int length1 = nums1.length, length2 = nums2.length; // 获取两个数组的长度  
        int totalLength = length1 + length2; // 计算两个数组的总长度  
        if (totalLength % 2 == 1) { // 如果总长度是奇数  
            int midIndex = totalLength / 2; // 找到中间索引  
            double median = getKthElement(nums1, nums2, midIndex + 1); // 获取第midIndex+1小的元素作为中位数  
            return median; // 返回中位数  
        } else { // 如果总长度是偶数  
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2; // 找到中间两个索引  
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0; // 获取第midIndex1+1和第midIndex2+1小的元素，计算平均值作为中位数  
            return median; // 返回中位数  
        }  
    }  
  
    // 辅助函数，用于找到两个有序数组中第k小的元素  
    public int getKthElement(int[] nums1, int[] nums2, int k) {  
        int length1 = nums1.length, length2 = nums2.length; // 获取两个数组的长度  
        int index1 = 0, index2 = 0; // 初始化两个数组的索引  
        int kthElement = 0; // 初始化第k小的元素  
  
        while (true) {  
            // 边界情况：如果nums1数组已经遍历完，直接从nums2数组中返回第k小的元素  
            if (index1 == length1) {  
                return nums2[index2 + k - 1];  
            }  
            // 边界情况：如果nums2数组已经遍历完，直接从nums1数组中返回第k小的元素  
            if (index2 == length2) {  
                return nums1[index1 + k - 1];  
            }  
            // 边界情况：如果k=1，直接返回两个数组当前索引对应元素的最小值  
            if (k == 1) {  
                return Math.min(nums1[index1], nums2[index2]);  
            }  
              
            // 正常情况：进行二分查找  
            int half = k / 2; // 计算二分查找的中间索引  
            int newIndex1 = Math.min(index1 + half, length1) - 1; // 计算nums1数组新的索引，确保不会越界  
            int newIndex2 = Math.min(index2 + half, length2) - 1; // 计算nums2数组新的索引，确保不会越界  
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2]; // 获取两个数组对应索引的元素作为基准值  
            // 根据基准值的大小关系，更新k和索引，缩小查找范围  
            if (pivot1 <= pivot2) {  
                k -= (newIndex1 - index1 + 1);  
                index1 = newIndex1 + 1;  
            } else {  
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;  
            }  
        }  
    }  
}


//999_113:路径总和 II

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	backtrack(res,new ArrayList<Integer>(),targetSum,0,root);
    	return res;
    }
    public void backtrack(List<List<Integer>> combinations,List<Integer>combination,int target,int sum,TreeNode root)
    {
    	if(root==null)
    	{
    		return;
    	}
    	combination.add(root.val);
    	sum+=root.val;
    	if(root.left==null&&root.right==null&&sum==target)
    	{
    		combinations.add(combination);
    	}    	
    	backtrack(combinations,combination,target,sum,root.left);
    	backtrack(combinations,combination,target,sum,root.right);
    	combination.remove(combination.size()-1);	
    }
}



//999_128:最长连续序列
package 力扣热题100;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L128 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			System.out.println(longestConsecutive(a));
		}

	}	
	
	public static int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        Arrays.sort(nums);
        int maxLen=1;
        int[]dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
        	if(nums[i]==nums[i-1]+1)
        	{
        		dp[i]=dp[i-1]+1;
        	}
        	if(nums[i]==nums[i-1])
        	{
        		dp[i]=dp[i-1];
        	}
        	else
        	{
        		dp[i]=1;
        	}
        	maxLen=Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}


///////////////////////////////////


class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],false);
        }
        int maxLen=1;
        for(int i=0;i<n;i++)
        {
            if(map.get(nums[i])==true)
            {
                continue;
            }
            else
            {
                maxLen=Math.max(maxLen,test(map,nums[i]));
            }
        }
        return maxLen;
    }

    public static int test(Map<Integer,Boolean> map,int target)
    {
            int count=1;
            int left=target-1;
            while(map.containsKey(left))
            {
                map.put(left,true);
                count++;
                left--;
            }
            int right=target+1;
            while(map.containsKey(right))
            {
                map.put(right,true);
                count++;
                right++;
            }
        return count;
    }
}

////////////////////////////////////////



class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        int maxLen=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
        	set.add(nums[i]);
        }
        
        for(int i=0;i<n;i++)
        {
        	if(set.contains(nums[i]-1))
        	{
        		continue;
        	}
        	else
        	{
        		int count=1;
        		int temp=nums[i]+1;
        		while(set.contains(temp))
        		{
        			count++;
        			temp++;
        		}
        		maxLen=Math.max(maxLen,count);
        	}
        }
        return maxLen;
    }
}







//999_136:只出现一次的数字

class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}

//999_141:环形链表



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode>set=new HashSet<>();
        while(head!=null)
        {
        	if(set.contains(head))
        	{
        		return true;
        	}
        	set.add(head);
        	head=head.next;
        }
        return false;
    }
}




//999_138:随机链表的复制
	
	/*
	//Definition for a Node.
	class Node {
	 int val;
	 Node next;
	 Node random;

	 public Node(int val) {-
	     this.val = val;
	     this.next = null;
	     this.random = null;
	 }
	}
	*/

	class Solution {
		Map<Node,Node>map=new HashMap<>();
	 public Node copyRandomList(Node head) {
	     
	    	 if(head==null)
	    	 {
	    		 return null;
	    	 }
	    	 if(!map.containsKey(head))
	    	 {
	    		 Node newhead=new Node(head.val);
	    		 map.put(head, newhead);
	    		 newhead.next=copyRandomList(head.next);
	    		 newhead.random=copyRandomList(head.random);
	    	 }
	    	 return map.get(head);
	 }
	}
	
//999:142 环形链表 II  
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        Set<ListNode>set=new HashSet<>();
	        while(head!=null)
	        {
	        	if(set.contains(head))
	        	{
	        		return head;
	        	}
	        	set.add(head);
	        	head=head.next;
	        }
	        return null;
	    }
	}



//999_144:二叉树的环形遍历
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();\
        preOrder(root,res);
        return res;
    }
    public List<Integer> preOrder(TreeNode root,List res)
    {
        if(root==null)
        {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}

//999_145:二叉树的后序遍历
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res)
    {
        if(root==null)
        {
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}



//999_151:反转字符串中的单词


class Solution {
    public String reverseWords(String s) {
    	StringBuffer ans=new StringBuffer();
    	int n=s.length();
    	int i=n-1;
    	while(i>=0)
    	{
    		while(i>=0&&s.charAt(i)==' ')
    		{
    			i--;
    		}
    		if(i>=0)
    		{
    			StringBuffer temp=new StringBuffer();
    			while(i>=0&&s.charAt(i)!=' ')
    			{
    				temp.append(s.charAt(i));
    				i--;
    			}  
        		temp.reverse();
        		ans.append(temp.toString());
        		ans.append(' ');
    		}
    	}
    	int len=ans.length();
    	if(ans.charAt(len-1)==' ')
    	{
    		ans.delete(len-1,len);
    	}
    	return ans.toString();
    }
}


///////////////////////////////
class Solution {
    public String reverseWords(String s) {
        StringBuffer a = new StringBuffer();
        int n = s.length();
        int[] b = new int[n]; // 记录每个单词首字母位置
        int[] c = new int[n]; // 记录每个单词末字母位置
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(0) == ' ') {
                if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                    b[count1++] = i + 1;// b记录了每一个单词首字母的位置 }
                } else {
                    b[0] = 0;
                    if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                        b[++count1] = i + 1;// b记录了每一个单词首字母的位置
                    }
                }
            }
            if (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ') {
                c[count2++] = i;// c记录了每一个单词末字母的位置
            }       
            }
        if(s.charAt(0)!=' ')
        {
        	count1++;
        }
        if (s.charAt(n - 1) != ' ') {
            c[count2++] = n - 1;
        }
        while (count2>0) {
            a.append(s.substring(b[--count1], c[--count2] + 1));
            if(count2>1)
            {
            	a.append(' ');
            }
        }
        return a.toString();
    }
}


//999_153. 寻找旋转排序数组中的最小值

class Solution {
    public int findMin(int[] nums) {
    	int n=nums.length;
    	if(n==0||nums==null)
    	{
    		return -1;
    	}
    	int low=0;
    	int high=n-1;
    	int mid;
    	while(low<high)
    	{
    		mid=(high+low)/2;
    		if(nums[mid]<nums[high])
    		{
    			high=mid;
    		}
    		if(nums[mid]>nums[high])
    		{
    			low=mid+1;
    		}
    	}
    	return nums[low];
    }
}

//999_160:相交链表
public class Solution {  
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {  
        // 如果两个链表都为空，或者其中一个为空，则它们没有交点  
        if (headA == null || headB == null) {  
            return null;  
        }  
  
        ListNode pA = headA;  
        ListNode pB = headB;  
  
        // 如果有交点，pA 和 pB 最终会相等，且指向交点；如果没有交点，它们最终都会变成 null  
        while (pA != pB) {  
            // pA 到达末尾时，转到 headB  
            pA = pA == null ? headB : pA.next;  
            // pB 到达末尾时，转到 headA  
            pB = pB == null ? headA : pB.next;  
        }  
  
        // 返回交点或 null  
        return pA;  
    }  
}



//24.10.31重做



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Map <ListNode,Boolean> map=new HashMap<>();
    ListNode p1=headA;
    while(p1!=null)
    {
    	map.put(p1,true);
    	p1=p1.next;
    }
    ListNode p2=headB;
    while(p2!=null)
    {
    	if(map.containsKey(p2))
    	{
    		return p2;
    	}
    	p2=p2.next;
    }
    return null;    
    }
    
}

//999_162:寻找峰值

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0)
        return -1;
        if(nums.length==1)
        return 0;
        if(nums.length==2&&nums[0]>nums[1])
        {
            return 0;
        }
        if(nums.length==2&&nums[0]<nums[1])
        {
            return 1;
        }
         if(nums.length==2&&nums[0]==nums[1])
        {
            return -1;
        }
        if(nums[0]>nums[1])
        {
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2])
        {
            return nums.length-1;
        }
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
            {
                return i;
            }
        }
        return -1;
    }
}

//999_164:最大间距

class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2)
        {
            return 0;
        }
        Arrays.sort(nums);
        int maxValue=Math.max(nums[0],nums[1])-Math.min(nums[0],nums[1]);
        for(int i=1;i<n;i++)
        {
            maxValue=Math.max(Math.max(maxValue,nums[i-1]-nums[i]),nums[i]-nums[i-1]);
        }
        return maxValue;
    }
}

//999_168:Excle表列名称
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder a=new StringBuilder();
        while(columnNumber>0)
        {
            columnNumber--;
            a.append((char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        a.reverse();
        return a.toString();
    }
}
//999_169多数元素
class Solution {
    public int majorityElement(int[] nums) {
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int n=nums.length;
    	for(int i=0;i<n;i++)
    	{
    		if(map.containsKey(nums[i]))
    		{
    			map.put(nums[i],map.get(nums[i])+1);
    		}
    		else
    		{
    			map.put(nums[i],1);
    		}
    	}
        // 查找出现次数大于 n/2 的元素  
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {  
            if (entry.getValue() > n / 2) {  
                return entry.getKey();  
            }  
        }  
    }
}

//999_171:Excel表序列号
class Solution {
    public int titleToNumber(String columnTitle) {
        int n=columnTitle.length();
        int sum=0;
        int suspend=1;
        for(int i=n-1;i>=0;i--)
        {
            sum+=((int)(columnTitle.charAt(i)-'A')+1)*suspend;
            suspend*=26;
        }
        return sum;
    }
}


//999_175:组合两个表

//999_187:重复的DNA序列

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String>res=new ArrayList<String>();
    	Map<String,Integer> map=new HashMap<String,Integer>();
    	int n=s.length();
    	for(int i=0;i<=n-10;i++)
    	{
    		String t=s.substring(i,i+10);
    		if(!map.containsKey(t))
    		{
    			map.put(t,1);
    		}
    		else
    		{
    			map.put(t,map.get(t)+1);
    			if(map.get(t)==2)
    			{
    				res.add(t);
    			}
    		}
    	}
    	return res;
    	
    }
}


//999_189:轮转数组


class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int t=n-(k%n);
        if(k==0)
        {
            return;
        }
        int[]nums1=new int[k];
        for(int i=0;i<k%n;i++)
        {
            nums1[i]=nums[t+i];
        }
        for(int i=t-1;i>=0;i--)
        {
            nums[i+k%n]=nums[i];
        }
        for(int i=0;i<k%n;i++)
        {
            nums[i]=nums1[i];
        }
        return;
    }
}

////////////////////24.10.31重新做;



class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k%n==0)
        {
        	return;
        }
        else
        {
        	int[] lowtemp=new int[n-k%n]; //保存前半部分
        	int[] hightemp=new int[k];  //保存最后k位
        	for(int i=n-k%n;i<n;i++)
        	{
        		hightemp[i-(n-k%n)]=nums[i];
        	}
        	for(int i=0;i<n-k%n;i++)
        	{
        		lowtemp[i]=nums[i];
        	}
        	
        	for(int i=0;i<n-k%n;i++)
        	{
        		nums[i+k%n]=lowtemp[i];        		
        	}
        	for(int i=0;i<k%n;i++)
        	{
        		nums[i]=hightemp[i];
        	}   	       	
        }
    }
}



//999_190：颠倒二进制位
public class Solution {
    public int reverseBits(int n) {
        int rev=0;
        for(int i=0;i<32;i++)
        {
        	res|=(n&1)<<(31-i);
        	n>>>=1;
        }
        return rev;
    }
}

//999_191：位1的个数

class Solution {
    public int hammingWeight(int n) {
    	StringBuilder a=new StringBuilder();
    	int count=0;
    	while(n>0)
    	{
    		a.append((char)(n%2+'0'));
    		n/=2;
    	}
    	a.reverse();
    	int len=a.length();
    	for(int i=0;i<len;i++)
    	{
    		if(a.charAt(i)=='1')
    		{
    			count++;
    		}
    	}
    	return count;
    }
}

//999_198:打家劫舍


class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int maxV=0;
        if(n==0||nums==null)
        {
            return 0;
        }
        if(n==1)
        {
            return nums[0];
        }
        if(n==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        else
        {
            int []maxValue=new int[n];
            maxValue[0]=nums[0];
            maxValue[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<n;i++)
            {
                maxValue[i]=Math.max(maxValue[i-2]+nums[i],maxValue[i-1]);
                maxV=Math.max(maxValue[i],maxV);
            }
        }
        return maxV;
    }
}

//999_202. 快乐数
class Solution {
    public boolean isHappy(int n) {
    	Set<Integer> set=new HashSet<Integer>();
    	while(n!=1&&!set.contains(n))
    	{
    		set.add(n);
    		n=nextNum(n);
    	}
    	return n==1;
    }
    public int nextNum(int n)
    {
    	int sum=0;
    	while(n!=0)
    	{
    		int digit=n%10;
    		sum+=digit*digit;
    		n/=10;
    	}
    	return sum;
    }
}

//999_203. 移除链表元素


class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	ListNode head1=new ListNode(0);
    	head1.next=head;
        ListNode prev=head1;
    	ListNode current=head;
    	while(head!=null)
    	{
    		if(head.val==val)
    		{
    			prev.next=head.next;
    		}
            else
            {
    	    	prev=head;
            }
    		head=head.next;    			
    	}
        return head1.next;
    }
}



//999_204. 计数质数

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime=new boolean[n];
    	Arrays.fill(isPrime,true);
    	int count=0;
    	for(int i=2;i<n;i++)
    	{
    		if(isPrime[i]==true)
    		{
    			count++;
    			if((long)i*i<n)
    			{
    				for(int j=i*i;j<n;j+=i)
    				{
    					isPrime[j]=false;
    				}
    			}
    		}
    	}
    	return count;
    }    
}

//以下解法超出时间限制//////////////////////////////////////////
class Solution {
    public int countPrimes(int n) {
    	boolean[] notPrime=new boolean[n];
    	int count=0;
    	for (int i = 0; i < n; i++) {  
    	    notPrime[i] = false;  
    	}
    	for(int i=1;i<n;i++)
    	{
    		if(notPrime[i]==true)
    		{
    			continue;
    		}
    		if(notPrime[i]==false&&isPrimes(i)==true)
    		{
    			count++;
    			if((long)i*i<n)
    			{
    				for(int j=i*i;j<n;j+=i)
        			{
        				notPrime[j]=true;
        			}
    			}    		
    		}
    	}
    	return count;
    }
    public boolean isPrimes(int n)
    {
    	if(n==1)
    	{
    		return false;
    	}
    	if(n==2||n==3)
    	{
    		return true;
    	}
    	for(int i=2;i<=Math.sqrt(n);i++)
    	{
    		if(n%i==0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
}


//以下解法超出时间限制//////////////////////////////////////////
class Solution {
    public int countPrimes(int n) {
    	if(n<=1)
    	{
    		return 0;
    	}
    	Boolean[] a=new Boolean[n];
        for(int i=0;i<n;i++)
        {
            a[i]=false;
        }
    	a[0]=false;
    	a[1]=false;
    	int count=0;
    	for(int i=2;i<n;i++)
    	{
    		if(a[i-1]==true)
    		{
    			continue;
    		}
    		if(isPrime(i)==true)
    		{
    			int k=2;
    			while(k*i<n)
    			{
    				a[k*i-1]=true;
    				k++;
    			}
    			count++;
    		}
    		else
    		{
    			int k=2;
    			while(k*i<n)
    			{
    				a[k*i-1]=true;
    				k++;
    			}
    		}
    	}
    	return count;
    }
    public Boolean isPrime(int n)
    {
    	if(n==1)
    	{
    		return false;
    	}  		
    	for(int i=2;i<=Math.sqrt(n);i++)
    	{
    		if(n%i==0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
}

///999_206:反转链表


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {     
        ListNode pre=null;
        ListNode cur=head;
        
        while(cur!=null)
        {
        	ListNode temp=cur.next;
        	cur.next=pre;
        	pre=cur;
        	cur=temp;
        	
        }
        return pre;
    }
}


//999_209:长度最小的子数组


class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int begin=0;
        int end=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        while(end<nums.length)
        {
            sum+=nums[end];
            while(sum>=target)
            {
                minLen = Math.min(minLen,end-begin+1);
                sum-=nums[begin];
                begin++;
            }
            end++;
            {

            }
        }
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}


//999_213. 打家劫舍 II
class Solution {
    public int rob(int[] nums) {
    	int n=nums.length;
    	if(n==0)
    	{
    		return 0;
    	}
    	if(n==1)
    	{
    		return nums[0];
    	}
    	if(n==2)
    	{
    		return Math.max(nums[0],nums[1]);
    	}
    	int[] max1Value=new int[n];
    	max1Value[0]=nums[0];
    	max1Value[1]=Math.max(nums[0],nums[1]);
    	for(int i=2;i<n-1;i++)
    	{
    		max1Value[i]=Math.max(max1Value[i-1],max1Value[i-2]+nums[i]);
    	}
    	max1Value[n-1]=max1Value[n-2];
    	int[] max2Value=new int[nums.length];
    	max2Value[0]=0;
    	max2Value[1]=nums[1];
    	for(int i=2;i<n;i++)
    	{
    		max2Value[i]=Math.max(max2Value[i-1],max2Value[i-2]+nums[i]);    		
    	}
    	return Math.max(max1Value[n-1],max2Value[n-1]);
    }
}


//999_:215. 数组中的第K个最大元素
	class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

//999_216：组合总和III
	class Solution {
	    public List<List<Integer>> combinationSum3(int k, int n) {
	    	List<List<Integer>> res=new ArrayList<List<Integer>>();
	    	backtrack(res,new ArrayList<Integer>(),k,1,n,0);
	    	return res;
	    }
	    public void backtrack(List<List<Integer>> combinations,List<Integer>combination,int k,int start,int target,int sum)
	    {
	    	if(sum==target&&combination.size()==k)
	    	{
	    		combinations.add(new ArrayList<Integer>(combination)); 
	    	}
	    	if(sum>=target||combination.size()==k)
	    	{
	    		return;
	    	}
	    	for(int i=start;i<10;i++)
	    	{
	    		combination.add(i);
	    		backtrack(combinations,combination,k,i+1,target,sum+i);
	    		combination.remove(combination.size()-1);
	    	}
	    }
	}

//999_217:存在重复元素
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                return true;
            }
        }
        if(map.size()==n)
        {
            return false;
        }

        return true;
    }
}


//999_219. 存在重复元素 II


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],i);
            }
            else
            {
                if(i-map.get(nums[i])<=k)
                {
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
}


//999_221. 最大正方形

class Solution {
    public int maximalSquare(char[][] matrix) {
    	int h=matrix.length;
    	int w=matrix[0].length;
    	int [][]dp=new int[h][w];
    	int maxSide=0;
    	if(matrix[0][0]=='0')
    	{
    		dp[0][0]=0;
    	}
    	else
    	{
    		dp[0][0]=1;
    		maxSide=1;
    	}
    	for(int i=0;i<h;i++)
    	{
    		for(int j=0;j<w;j++)
    		{
    			if(matrix[i][j]=='1')
    			{
    				if(i==0||j==0)
    				{
    					dp[i][j]=1;
    				}
    				else
    				{
        				dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;    					
    				}
    				maxSide=Math.max(maxSide,dp[i][j]);
    			}
    			else
    			{
    				dp[i][j]=0;
    			}
    		}
    	}
    	return maxSide*maxSide;
    }
}

//以下不对/////////////////////
class Solution {
    public int maximalSquare(char[][] matrix) {
    	int h=matrix.length;
    	int w=matrix[0].length;
    	int maxSize=0;
    	for(int i=0;i<h;i++)
    	{
    		for(int j=0;j<w;j++)
    		{
    			if(matrix[i][j]==1)
    			{
    				int length=Math.min(h-i,w-j);
    				int num=0;
        			while(isSquare(matrix,i,i+length-1-num,j,j+length-1-num)==false)
        			{
        				num++;
        			}
        			maxSize=Math.max(maxSize,(length-num)*(length-num));
    			}    			
    		}
    	}
    	return maxSize;
    }
    public boolean isSquare(char[][] matrix,int x1,int x2,int y1,int y2)
    {
    	for(int i=x1;i<=x2;i++)
    	{
    		for(int j=y1;j<=y2;j++)
    		{
    			if(matrix[i][j]==0)
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}


//以下超出时间限制////////////////////////////////////////
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int maxSize=0;
        for(int i=0;i<rows;i++)
        {
        	for(int j=0;j<cols;j++)
        	{
        		if(matrix[i][j]=='1')
        		{
        			int len=Math.min(rows-i,cols-j);   //边长可能的最大值
        			for(int k=len;k>=0;k--)            //以i，j为左上顶点的最大正方形
        			{
        				int count=0;
        				for(int m=0;m<k;m++)
        				{
        					for(int n=0;n<k;n++)
        					{
        						if(matrix[i+m][j+n]=='1')
        						{
        							count++;
        						}
        					}
        				}
        				if(count==k*k)
        				{
            				maxSize=Math.max(maxSize,k);
            				break;        					
        				}
        			}
        		}
        	}
        }
        return maxSize*maxSize;
    }
}

//999_223. 矩形面积

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    	int area1=(ay2-ay1)*(ax2-ax1);
    	int area2=(by2-by1)*(bx2-bx1);
    	int len=(Math.min(ax2,bx2)-Math.max(ax1,bx1));
    	int wed=(Math.min(ay2,by2)-Math.max(ay1,by1));
    	return len<=0||wed<=0?area1+area2:area1+area2-(len*wed);
    }
}

//999_226. 翻转二叉树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root==null)
    		return null;
    	TreeNode left=invertTree(root.left);
    	TreeNode right=invertTree(root.right);
    	root.left=right;
    	root.right=left;
        return root;
    }
}
//999_229. 多数元素 II
class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	int n=nums.length;
        List<Integer> res=new ArrayList();
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0;i<n;i++)
    	{
    		if(!map.containsKey(nums[i]))
    		{
    			map.put(nums[i],1);
    		}
    		else
    		{
    			map.put(nums[i],map.get(nums[i])+1);     	
    		}
    		if(map.get(nums[i])==n/3+1)
    		{
                res.add(nums[i]);
    		}
    	}
    	return res;
    }
}

//999_234. 回文链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    	ListNode head1=head;
    	while(head1!=null)
    	{
    		head1=head1.next;
    		count++;   //count即为链表总长度
    	}
    	if(count%2==1)
    	{
    		int count1=count/2;
    		ListNode head2=head;
    		while(count1>0)
    		{
    			head2=head2.next;
    			count1--;
    		}              //此时head21指向正中间元素
    	}
    }
}


//24.11.3重做

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null)
        {
        	list.add(head.val);
        	head=head.next;
        }
        int n=list.size();
        if(n%2==0)
        {
        	int low=n/2-1;
        	int high=n/2;
        	while(0<=low&&high<n&&list.get(low)==list.get(high))
        	{
        		low--;
        		high++;
        	}
        	if(low==-1)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        else
        {
        	int p=n/2;
        	int count=1;
        	while(0<=p-count&&list.get(p-count)==list.get(p+count))
        	{
        		count++;
        	}
        	if(p-count==-1)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
    }
}










//999_237. 删除链表中的节点


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}


//999_238. 除自身以外数组的乘积
//方法1：

class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int n=nums.length;
    	int[]left=new int[n];
    	int[]right=new int[n];
    	int[]answer=new int[n];
    	left[0]=1;
    	right[n-1]=1;
    	for(int i=1;i<n;i++)
    	{
    		left[i]=left[i-1]*nums[i-1];
    		right[n-1-i]=right[n-i]*nums[n-i];
    	}
    	for(int i=0;i<n;i++)
    	{
    		answer[i]=left[i]*right[i];
    	}
    	return answer;
    }
}

//方法2：
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        int num=1;
        for(int i=0;i<n;i++)
        {
            num*=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                answer[i]=num/nums[i];
            }
            else
            {
                int num1=1;
                int j=0;
                while(j<n&&j!=i)
                {
                    num1*=nums[j];
                    j++;
                }
                for(j=i+1;j<n;j++)
                {
                    num1*=nums[j];
                }
                answer[i]=num1;
            }
        }return answer;
    }
}

//24.10.31重做


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++)
        {
        	left[i]=left[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
        	right[i]=right[i+1]*nums[i+1];
        }
        int[]ans =new int[n];
        for(int i=0;i<n;i++)
        {
        	if(i==0)
        	{
        		ans[i]=right[0];
        	}
        	if(i==n-1)
        	{
        		ans[i]=left[n-1];
        	}
        	else
        	{
        		ans[i]=right[i]*left[i];	
        	}
        	
        }return ans;
    }
}

//999_240. 搜索二维矩阵 II

//官方给出的牛逼的算法/////////////////已经手搓一遍


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int x=0;
    	int y=n-1;
    	while(x<m&&y>=0)
    	{
        	if(matrix[x][y]==target)
        	{
        		return true;
        	}
    		if(matrix[x][y]>target)
    		{
    			y--;
    		}
    		else
    		{
    			x++;
    		}
    	}
    		return false;
    }
}


//  以下算法原创 正确

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w=matrix[0].length;
        if(h==0||w==0)
        {
        	return false;
        }
        if(target<matrix[0][0]||target>matrix[h-1][w-1])
        {
        	return false;
        }
        int temp=0;
        while(temp<Math.min(h,w)&&matrix[temp][temp]<target)
        {
        	temp++;
        }
        for(int i=0;i<h;i++)
        {
        	for(int j=temp;j<w;j++)
        	{
        		if(matrix[i][j]==target)
        		{
        			return true;
        		}
        	}
        }
        for(int i=temp;i<h;i++)
        {
        	for(int j=0;j<w;j++)
        	{
        		if(matrix[i][j]==target)
        		{
        			return true;
        		}
        	}
        }
        return false;
    }
}









//方法1：（解答错误 116 / 130 个通过的测试用例）
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	if(n<1&&m<1)
    	{
    		return false;
    	}
    	if(m==1)          //只有一行
    	{
    		for(int i=0;i<n;i++)
    		{
    			if(matrix[0][i]==target)
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	if(n==1)         //只有一列
    	{ 
    		for(int i=0;i<m;i++)
    		{
    			if(matrix[i][0]==target)
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	int k;
    	int min=Math.min(m,n);
        if(matrix[min-1][min-1]>=target)
        {
        	 for(k=0;k<min;k++)
             {
             	if(matrix[k][k]>=target)
             	{
             		break;
             	}
             }            //此时matrix[k][k]大于等于target
             if(k==0)
             {
             	if(matrix[0][0]==target)
             	{
             		return true;
             	}
             	else
             	{
             		return false;
             	}
             }            
             if(matrix[k][k]==target)
                 {
                 	return true;
                 }
              for(int i=0;i<=k;i++)
                 {
                 	if(matrix[k-i][k]==target||matrix[k][k-i]==target)
                 	{
                 		return true;
                 	}
                 }
              return false;
        }
        if(Math.min(m,n)==m)
        {
        	int t=Math.max(m,n)-Math.min(m,n);
        	for(int i=0;i<m;i++)
        	{
        		for(int j=0;j<t;j++)
        		{
        			if(matrix[i][j+min]==target)
        			{
        				return true;
        			}
        		}
        	}
        		return false;
        }
        if(Math.min(m,n)==n)
        {
        	int t=Math.max(m,n)-Math.min(m,n);
        	for(int i=0;i<t;i++)
        	{
        		for(int j=0;j<n;j++)
        		{
        			if(matrix[i+min][j]==target)
        			{
        				return true;
        			}
        		}
        	}
        	return false;
        }
        return false;
    }
}


//方法2：（解答错误 116 / 130 个通过的测试用例）

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	if(n<1&&m<1)
    	{
    		return false;
    	}
    	if(m==1)          //只有一行
    	{
    		for(int i=0;i<n;i++)
    		{
    			if(matrix[0][i]==target)
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	if(n==1)         //只有一列
    	{ 
    		for(int i=0;i<m;i++)
    		{
    			if(matrix[i][0]==target)
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	int min=Math.min(m,n);
    	int k=0;
    	if(matrix[min-1][min-1]<target)
    	{
            if(Math.min(m,n)==m)
            {
            	int t=Math.max(m,n)-Math.min(m,n);
            	for(int i=0;i<m;i++)
            	{
            		for(int j=0;j<t;j++)
            		{
            			if(matrix[i][j+min]==target)
            			{
            				return true;
            			}
            		}
            	}
            		return false;
            }
            if(Math.min(m,n)==n)
            {
            	int t=Math.max(m,n)-Math.min(m,n);
            	for(int i=0;i<t;i++)
            	{
            		for(int j=0;j<n;j++)
            		{
            			if(matrix[i+min][j]==target)
            			{
            				return true;
            			}
            		}
            	}
            	return false;
            }    		
    	}
    	else
    	{
    		while(matrix[k][k]<target)
    		{
    			k++;         //此时matrix[k][k]大于等于target
    		}
    		for(int i=0;i<=k;i++)
    		{
    			if(matrix[k][k-i]==target||matrix[k-i][k]==target)
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;

    }
}

//////////////////////////24.10.31重做


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int row=0;
    	int col=n-1;
    	while(row<m&&col>=0)
    	{
    		if(target==matrix[row][col])
    		{
    			return true;
    		}
    		if(target>matrix[row][col])
    		{
    			row++;
    		}
    		else
    		{
    			col--;
    		}
    	}
    	return false;
    	
    }
}




//999_242. 有效的字母异位词

class Solution {
    public boolean isAnagram(String s, String t) {
    	Map<Character,Integer> map1=new HashMap<Character,Integer>();
    	Map<Character,Integer> map2=new HashMap<Character,Integer>();
    	int n1=s.length();
    	int n2=t.length();
    	if(n1!=n2)
    	{
    		return false;
    	}
    	for(int i=0;i<n1;i++)
    	{
    		if(!map1.containsKey(s.charAt(i)))
    		{
    			map1.put(s.charAt(i),1);
    		}
    		else
    		{
    			map1.put(s.charAt(i),map1.get(charAt(i))+1);
    		}
    		
    		if(!map2.containsKey(t.charAt(i)))
    		{
    			map2.put(t.charAt(i),1);
    		}
    		else
    		{
    			map2.put(t.charAt(i),map2.get(charAt(i))+1);
    		}
    	}
    	for(int i=0;i<n1;i++)
    	{
    		if(map1.get(charAt(i))!=map2.get(map1.get(charAt(i))))
    		{
    			return false;
    		}
    		if(map2.get(charAt(i))!=map1.get(map2.get(charAt(i))))
    		{
    			return false;
    		}
    	}
    	return true;
    }
}



//999_257:二叉树的所有路径

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
    	if(root==null)
    	{
    		return new ArrayList<String>('');
    	}
    	List<String> res=new ArrayList<String>();
    	StringBuffer a=new StringBuffer();
    	constructTree(root,a,res);
    	return res;
    }
    public void constructTree(TreeNode root,StringBuffer a,List<String> res)
    {
    	if(root==null)
    	{
    		res.add(a.toString());
    	}
    	a.append("->");
    	a.append(Integer.toString(root.val));
    	constructTree(root.left,a,res);
    	constructTree(root.right,a,res);    	
    }
}

//999_263. 丑数
class Solution {
    public boolean isUgly(int n) {
        if(n<=0)
        {
            return false;
        }
        while(n%2==0)
        {
            n/=2;
        }
        while(n%3==0)
        {
            n/=3;
        }
        while(n%5==0)
        {
            n/=5;
        }
        return n==1;
    }
}



//999_264. 丑数 II

class Solution {
    public int nthUglyNumber(int n) {
    	int []dp=new int[n+1];
    	dp[1]=1;
    	int p1=1;
    	int p2=1;
    	int p3=1;
    	for(int i=2;i<n+1;i++)
    	{
    		int num1=dp[p1]*2;
    		int num2=dp[p2]*3;
    		int num3=dp[p3]*5;
    		dp[i]=Math.min(num1,Math.min(num2,num3));
    		if(dp[i]==num1)
    		{
    			p1++;
    		}
    		if(dp[i]==num2)
    		{
    			p2++;
    		}
    		if(dp[i]==num3)
    		{
    			p3++;
    		}
    	}
    	return dp[n];
    }
}


// 以下超出时间限制/////////////////////////

class Solution {
    public int nthUglyNumber(int n) {
        int num=1;
        int count=0;
        while(count<n)
        {
            if(isUgly(num)==true)
            {
                count++;
            }
            num++;
        }
        return --num;
    }
    public boolean isUgly(int n)
    {
        if(n<1)
        {
            return false;
        }
        if(n==1)
        {
            return true;
        }
        while(n%2==0)
        {
            n/=2;
        }
        while(n%3==0)
        {
            n/=3;
        }
        while(n%5==0)
        {
            n/=5;
        }
        return n==1;
    }
}



//999_268. 丢失的数字
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        for(int i=0;i<=n;i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return -1;
    }
}



//999_274. H 指数


class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int h=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(citations[0],n);
        h=Math.max(h,Math.min(citations[0],n-0));
        for(int i=1;i<n;i++)
        {
            if(citations[i]!=citations[i-1])
            {
                map.put(citations[i],n-i);
                if(n-i>=citations[i])
                {
                    h=Math.max(h,Math.min(citations[i],n-i));
                }
                else
                {
                	h=Math.max(h,n-i);
                }
            }
        }
        return h;
    }
}



//999_275. H 指数 II

class Solution {
    public int hIndex(int[] citations) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int n=citations.length;    
        map.put(citations[0],n);
        int h=Math.min(citations[0],n);
        for(int i=1;i<n;i++)
        {
            if(citations[i]!=citations[i-1])
            {
                map.put(citations[i],n-i);
                h=Math.max(h,Math.min(citations[i],n-i));
            }
        }
        return h;
    }
}



//999_279. 完全平方数

//以下为官方标准算法//////////////////
class Solution {
    public int numSquares(int n) {
    	int[] f=new int[n+1];
    	for(int i=1;i<=n;i++)
    	{
    		int minn=Integer.MAX_VALUE;
    		for(int j=1;j*j<=i;j++)
    		{
    			minn=Math.min(minn,f[i-j*j]);
    		}
    		f[i]=minn+1;
    	}
    	return f[n];
    }
}

//下面的算法是错误的//////////////////////////////////////////
class Solution {
    public int numSquares(int n) {
    	int m=Math.sqrt(n);
    	int[] a=new int[m+1];
    	for(int i=1;i<m+1;i++)
    	{
    		a[i]=i*i;
    	}
    	int count=0;
    	while(n-m*m>=0)
    	{
    		n-=m*m;
    		count++;
    		while(n-m*m<0)
    		{
        		m--;
        		if(m<=0)
        		{
        			break;
        		}
    		}    		
    	}
    	return count;
    }
}


//  下面的做法是不对的///////////////////////
class Solution {
    public int numSquares(int n) {
        int n1;
        int count=0;
        while(Math.sqrt(n1)>1)
        {
        	n1=n1-Math.sqrt(n1)*Math.sqrt(n1);
        	count++;        	
        }
        return count+n1;
    }
}



//999——283：移动零


package 力扣热题100;

public class L283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        if(nums[0]==0)
        {
        	dp[0]=1;
        }
        else
        {
        	dp[0]=0;
        }
        int count=dp[0];
        for(int i=1;i<n;i++)
        {
        	if(nums[i]==0)
        	{
        		count++;
        		dp[i]=count;
        	}
        	else
        	{
        		dp[i]=dp[i-1];
        	}
        }
        
        for(int i=0;i<n;i++)
        {
        	if(nums[i]!=0)
        	{
        		nums[i-dp[i]]=nums[i];
        	}
        }
        for(int i=n-count;i<n;i++)
        {
        	nums[i]=0;
        }

    }
	


}



//999_289. 生命游戏

class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                /////////////////////// 左上角
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (board[i - 1][j - 1] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i >= 0 && j - 1 >= 0) {
                    if (board[i][j - 1] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i + 1 < m && j - 1 >= 0) {
                    if (board[i + 1][j - 1] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i - 1 >= 0 && j >= 0) {
                    if (board[i - 1][j] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i + 1 < m && j >= 0) {
                    if (board[i + 1][j] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i - 1 >= 0 && j + 1 < n) {
                    if (board[i - 1][j + 1] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i >= 0 && j + 1 < n) {
                    if (board[i][j + 1] == 1) {
                        count++;
                    }
                }
                ///////////////////////
                if (i + 1 < m && j + 1 < n) {
                    if (board[i + 1][j + 1] == 1) {
                        count++;
                    }
                }
                if (board[i][j] == 1) {
                    if (!(count == 2 || count == 3)) {
                        next[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        next[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

}


//999_300. 最长递增子序列

class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n=nums.length;
    	if(n==0)
    	{
    		return 0;
    	}
    	int[] dp=new int[n];
    	dp[0]=1;
    	for(int i=1;i<n;i++)
    	{
    		dp[i]=1;
    		for(int j=0;j<i;j++)
    		{
    			if(nums[j]<nums[i])
    			{
        			dp[i]=Math.max(dp[i],dp[j]+1);    				
    			}
    		}
    	}
    	Arrays.sort(dp);
    	return dp[n-1];
    }
}

//以下算法有BUG尚待解决/////////////////////
class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n=nums.length;
    	int maxLen=0;
    	int p=fun(nums);
    	while(p<n)
    	{
    		if(p<n-1&&nums[p]<nums[p+1])
    		{
        		int before=p;
    			while(p<n-1&&nums[p]<nums[p+1])
    			{
        			p++;
    			}
        		maxLen=Math.max(maxLen,p-before+1);
    		}
    		else
    		{
    			p++;
    		}
    	}
    	return maxLen;
    }
    public int fun(int[]nums)
	{
		int n=nums.length;
		StringBuffer ans=new StringBuffer();
		for(int i=0;i<n-1;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(nums[i]<nums[j])
				{
					ans.append(j+'0');
					break;
				}
			}
		}
		if(ans.length()!=0)
		{
			char Ans=ans.charAt(0);
			return Ans-'0';
		}
		else
		{
			return -1;
		}
	}
}
//以下算法实现功能：最长连续递增子序列
class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n=nums.length;
    	int maxLen=0;
    	int p=0;
    	while(p<n)
    	{
    		if(p<n-1&&nums[p]<nums[p+1])
    		{
        		int before=p;
    			while(p<n-1&&nums[p]<nums[p+1])
    			{
        			p++;
    			}
        		maxLen=Math.max(maxLen,p-before+1);
    		}
    		else
    		{
    			p++;
    		}
    	}
    	return maxLen;
    }
    public int fun(int[]nums)
	{
		int n=nums.length;
		StringBuffer ans=new StringBuffer();
		for(int i=0;i<n-1;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(nums[i]<nums[j])
				{
					ans.append(j+'0');
					break;
				}
			}
		}
		if(ans.charAt(0)!=null)
		{
			char Ans=ans.charAt(0);
			return Ans-'0';
		}
		else
		{
			return -1;
		}
	}
}


//999_316. 去除重复字母


// 官方答案
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/remove-duplicate-letters/solutions/527359/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public String removeDuplicateLetters(String s) {
    	public boolean[] ifExist=new boolean[26];
    	public int[] leftnum=new int[26];
    	StringBuffer exist=new StringBuffer();
    	int n=s.length();
    	for(int i=0;i<26;i++)
    	{
    		ifExist[i]=false;
    		leftnum[i]=0;
    	}
    	for(int i=0;i<n;i++)
    	{
    		leftnum[s.charAt(i)-'a']++;
    	}
    	for(int i=0;i<n;i++)
    	{
    		while(!ifExist(s.charAt(i)-'a'))
    		{
    			if(exist.length()>0&&leftnum[exist.charAt(exist.length()-1)-'a']>0)
    			{
    				exist.delete(exist.length()-1);
    				leftnum[exist.charAt(exist.length()-1)-'a']--;
    				ifExist[exist.charAt(exist.length()-1)-'a']=false;
    			}
    			else
    			{
    				break;
    			}
    		}
    		exist[exist.length()]=s.charAt(i);
    	}
    	return exist.toString();
    }
}
//999_318. 最大单词长度乘积
class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int maxLen=0;
        for(int i=0;i<n-1;i++)
        {
        	for(int j=i+1;j<n;j++)
        	{
        		if(!(isOverlap(words[i],words[j])))
        		{
        			maxLen=Math.max(maxLen,words[i].length()*words[j].length());
        		}
        	}
        }
        return maxLen;
    }
    public boolean isOverlap(String words1,String words2)
    {
    	int n1=words1.length();
    	int n2=words2.length();
    	if(n1==0||n2==0)
    	{
    		return false;
    	}
    	Set<Character> set=new HashSet<Character>();
    	for(int i=0;i<n1;i++)
    	{
    		set.add(words1.charAt(i));
    	}
    	for(int i=0;i<n2;i++)
    	{
    		if(set.contains(words2.charAt(i)))
    		{
    			return true;
    		}
    	}
    	return false;
    }
}


//999_319. 灯泡开关


class Solution {
    public int bulbSwitch(int n) {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((j+1)%(i+1)==0)
                {
                    if(a[j]==1)
                    {
                        a[j]=0;
                    }
                    else
                    {
                        a[j]=1;
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
        	if(a[i]==0)
        	{
        		count++;
        	}
        }
        return count;
    }
}


//999_322. 零钱兑换

class Solution {
    public int coinChange(int[] coins, int amount) {
    	int[]  dp = new int[amount+1];
    	dp[0] = 0;
    	for(int i=1;i<amount;i++)
    	{
    		dp[i]=Integer.MAX_VALUE;
    	}
    	for(int i=1;i<amount+1;i++)
    	{
    		for(int j=0;j<coins.length;j++)
    		{
    			if(i-coins[j]>=0)
    			{
        			dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);    				
    			}
    		}
    	}
    	return dp[amount]>amount?-1:dp[amount];
    }
}
//////////////////////////////
class Solution {
    public int coinChange(int[] coins, int amount) {
    	int[]  dp = new int[amount+1];
    	//如果下面要用Integer.MAX_VALUE初始化，应该注意防止底下溢出
        Arrays.fill(dp,Integer.MAX_VALUE-1);
            	dp[0] = 0;
    	for(int i=1;i<amount+1;i++)
    	{
    		for(int j=0;j<coins.length;j++)
    		{
    			if(i-coins[j]>=0)
    			{
        			dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);    				
    			}
    		}
    	}
    	return dp[amount]>amount?-1:dp[amount];
    }
}

//以下算法大概率是错的//////////////////////////
class Solution {
    public int coinChange(int[] coins, int amount) {
        int count=0;
        int n=coins.length;
        Arrays.sort(coins);
        for(int i=0;i<n;i++)
        {
            while(amount-coins[n-1-i]>=0)
            {
          		amount-=coins[n-1-i];
          		count++;
            }        	
        }
        if(amount>0)
        {
        	return -1;
        }
        return count;
    }
}


//999_324. 摆动排序 II

//下面的方法是不对的，因为前一半升序排列在偶数位置，后一半升序排列在奇数位置，最后初始数列中间附件的元素可能相等
//所以要前一半倒序插入，后一半也倒序插入，让可能相等的分开在新数列的开头和结尾
class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[]num=new int[n];
        for(int i=0;i<n;i++)
        {
            num[i]=nums[i];
        }
        if(n%2==0)
        {
            for(int i=0,j=0;i<n/2;i++,j+=2)
            {
                nums[j]=num[i];
            }
            for(int i=n/2,j=1;i<n;i++,j+=2)
            {
                nums[j]=num[i];
            }
        }
        else
        {
        	for(int i=0,j=0;i<=n/2;i++,j+=2)
        	{
        		nums[j]=num[i];
        	}
        	for(int i=n/2+1,j=1;i<n;i++,j+=2)
        	{
        		nums[j]=num[i];
        	}
        }
    }
}

//这个方法是对的

class Solution {
    public void wiggleSort(int[] nums) {
    	int n=nums.length;
    	int[]num=new int[n];
    	for(int i=0;i<n;i++)
    	{
    		num[i]=nums[i];
    	}
    	Arrays.sort(num);
    	for(int i=0,mid=(n+1)/2-1,end=n-1;i<n;i+=2,mid--,end--)
    	{
    		nums[i]=num[mid];
    		if(i+1<n)
    		{
    			nums[i+1]=num[end];
    		}
    		
    	}
    }
}


//999_328. 奇偶链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
    	if(head==null||head.next==null)
    	{
    		return head;
    	}
    	ListNode headOdd=head;
    	ListNode headEven=head.next;
    	ListNode p=headOdd;
    	ListNode q=headEven;
    	head=head.next;
    	head=head.next;//此时的head指向初始链表第三个节点
    	while(head!=null)
    	{
    		p.next=head;
    		p=p.next;
    		head=head.next;
    		if(head==null)
    		{
    			break;
    		}
    		q.next=head;
    		q=q.next;
    		head=head.next;
    	}
        q.next=null;
    	p.next=headEven;
    	return headOdd;
    }
}

//一下算法大概率是错的、、、、、、、、、、、、、
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
    	ListNode oddbegin=new ListNode(0);
    	ListNode evenbegin=new ListNode(0);    	
    	ListNode p=head;
    	oddbegin.next=head;
    	evenbegin.next=head.next;
    	ListNode o=oddbegin;           // o指向奇数结点链表
    	ListNode e=evenbegin;          // e指向偶数结点链表
    	while(p!=null)
    	{
    		if(p.next!=null)
    		{
        		o.next=p;
        		o=o.next;
        		evenbegin.next=p.next;
        		e=e.next;
        		p=p.next.next;    			
    		}
    		else
    		{
        		o.next=p;
        		o=o.next;    
        		o.next=null;
    		}
    	}
    	o.next=evenbegin.next;
    	return oddbegin.next;
    }
}

//999_334. 递增的三元子序列

//下面的做法超出时间限制
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                if(nums[i]>=nums[j])
                {
                    continue;
                }
                for(int k=j+1;k<n;k++)
                {
                    if(nums[j]<nums[k])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

//下面的做法是对的

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    } 
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/increasing-triplet-subsequence/solutions/1204375/di-zeng-de-san-yuan-zi-xu-lie-by-leetcod-dp2r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//999_337. 打家劫舍 III
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
    	Map<TreeNode,Integer> f=new HashMap<TreeNode,Integer>();  //f代表选择此结点
    	Map<TreeNode,Integer> g=new HashMap<TreeNode,Integer>();
    	dfs(root,f,g);
    	return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }
    
    public void dfs(TreeNode root,Map<TreeNode,Integer> f,Map<TreeNode,Integer> g)
    {
    	if(root==null)
    	{
    		return ;
    	}
    	dfs(root.left,f,g);
    	dfs(root.right,f,g);
    	f.put(root,root.val+g.getOrDefault(root.left,0)+g.getOrDefault(root.right,0));
    	g.put(root,Math.max(f.getOrDefault(root.left,0),g.getOrDefault(root.left,0))+Math.max(f.getOrDefault(root.right,0),g.getOrDefault(root.right,0)));   	
    }
}




/////////////////////////////////////////////////大概率是错的下面

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	int maxMoney=0;
    public int rob(TreeNode root) {
    	int a=0;
    	a=maxMoney(root,0);
    	return a;
    }
    public int maxMoney(TreeNode root,int max)
    {
    	if(root==null)
    	{
    		return 0;
    	}
    	max=Math.max(maxMoney(root.right)+maxMoney(root.left),root.val+maxMoney(root.left.left)+maxMoney(root.left.right)+maxMoney(root.right.left)+maxMoney(root.right.right));
    	return max;
    }
}


//一种超时的算法：
class Solution {  
    int maxMoney = 0;  
  
    public int rob(TreeNode root) {  
        maxMoney(root, 0);  
        return maxMoney;  
    }  
  
    public int maxMoney(TreeNode root, int currentMax) {  
        if (root == null) {  
            return 0;  
        }  
        int moneyWithoutRoot = maxMoney(root.left, currentMax) + maxMoney(root.right, currentMax);  
        int moneyWithRoot = root.val;  
        if (root.left != null) {  
            moneyWithRoot += maxMoney(root.left.left, currentMax) + maxMoney(root.left.right, currentMax);  
        }  
        if (root.right != null) {  
            moneyWithRoot += maxMoney(root.right.left, currentMax) + maxMoney(root.right.right, currentMax);  
        }  
        int max = Math.max(moneyWithoutRoot, moneyWithRoot);  
        maxMoney = Math.max(maxMoney, max);  
        return max;  
    }  
}


//999_338. 比特位计数
class Solution {
    public int[] countBits(int n) {
    	int[] res=new int[n+1];
    	for(int i=0;i<=n;i++)
    	{
    		res[i]=numOf1(i);
    	}
    	return res;
    }

    public int numOf1(int n)
    {
    	int x=0;           
        int count=0;
        while(Math.pow(2,x)<=n)
        {
        	x++;   //2的x次方刚好大于n
        }
        x--;     //此时2的x次方刚好小于等于n
        for(int i=x;i>=0;i--)
        {
            if(n-Math.pow(2,i)>=0)
            {
            	n-=Math.pow(2,i);
            	count++;
            }        	
        }
        return count;
    }
}

//999_343. 整数拆分

class Solution {
    public int integerBreak(int n) {
    	int count=0;
    	int maxM=0;
    	int left=n%3;     //余数
    	int n1=n-n%3;     //去掉余数的大部分
    	if(n==2)
    	{
    		return 1;
    	}
    	if(n==3)
    	{
    		return 2;
    	}
    	while(n1>=3)
    	{
    		n1-=3;
    		count++;       //一共有count个3相乘
    	}
    	if(left==0)
    	{
    		maxM=power(3,count);
    	}
    	if(left==1)
    	{
    		if(count>0)
    		{
        		maxM=power(3,count-1)*4;    			
    		}
    		else
    		{
    			maxM=n;
    		}
    	}
    	if(left==2)
    	{
    		maxM=power(3,count)*2;
    	}
    	return maxM;
    }
    public int power(int x,int y)
    {
    	int num=1;
    	while(y>0)
    	{
    		num*=x;
    		y--;
    	}
    	return num;
    }
}


//999_344. 反转字符串


class Solution {
    public void reverseString(char[] s) {
    	int n=s.length;
    	for(int i=0;i<(1+n)/2;i++)
    	{
    		swap(s,i,n-1-i);
    	}
    	
    }
    public void swap(char[]s,int i,int j)
    {
    	char c;
    	c=s[i];
    	s[i]=s[j];
    	s[j]=c;
    }
}

//999_347. 前 K 个高频元素

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int n=nums.length;
    	for(int i=0;i<n;i++)
    	{
    		if(!map.containsKey(nums[i]))
    		{
    			map.put(nums[i],1);
    		}
    		else
    		{
    			map.put(nums[i],map.get(nums[i])+1);
    		}
    	}
    	int len=map.length;
    	int[] res=new int[len];
    	for(int i=0;i<len;i++)
    	{
    		res[i]=map.get(i);
    	}
    	Arrays.sort(res);
    	int dig=res[len-k];
    	int[]ans=new int[k];
    	int j=0;
    	for(int i=0;i<n;i++)
    	{
    		if(map.get(i)>=dig)
    		{
    			ans[j]=nums[i];
    			j++;
    		}
    	}
    }
}


//999_349. 两个数组的交集

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	int n1=nums1.length;
    	int n2=nums2.length;
    	Arrays.sort(nums2);
    	Set<Integer> set=new HashSet<Integer>();
    	for(int i=0;i<n1;i++)
    	{
    		if(!set.contains(nums1[i]))
    		{
    			set.add(nums1[i]);
    		}
    	}
    	int length=0;
    	int count=0;
    	if(set.contains(nums2[0]))
    	{
    		length++;
    	}
    	for(int i=1;i<n2;i++)
    	{
    		if(set.contains(nums2[i])&&nums2[i]!=nums2[i-1])
    		{
    			length++;
    		}
    	}
    	int[]ans=new int[length];
		if(set.contains(nums2[0]))
		{
			ans[0]=nums2[0];
			count++;
		}
    	for(int i=1;i<n2;i++)
    	{
    		if(set.contains(nums2[i])&&nums2[i]!=nums2[i-1])
    		{
    			ans[count]=nums2[i];
    			count++;
    		}
    	}
    	return ans;
    }
}

//999_367. 有效的完全平方数



class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1;
        int high=num;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(mid*mid==num)
            {
                return true;
            }
            if(mid*mid<num)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }if(high*high==num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

//999_368:最大整除子集

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> ans=new ArrayList<Integer>();
    	int n=nums.length;
    	Arrays.sort(nums);
    	int maxSize=0;
    	for(int i=0;i<n-1;i++)
    	{
    		int count=0;
    		for(int j=i+1;j<n;j++)
    		{
    			if(nums[j]%nums[i]==0)
    			{
    				List<Integer> res=new ArrayList<Integer>(); 
    				res.add(nums[i]);
    				res.add(nums[j]);
    					count+=2;
    					int p=j;     // 前指针
    					int q=j+1;   // 后指针
    					while(q<n)
    					{
    						if(q<n&&nums[q]%nums[p]!=0)
    						{
        						q++;
    						}
    						if(q<n&&nums[q]%nums[p]==0)
    						{
    							count++;
    							res.add(nums[q]);
    							p=q;
    							q++;
    						}
    					}
    					if(count>maxSize)
    					{
    						maxSize=count;
    						ans=res;
    					}
    			}
    		}
    	}
    	return ans;
    }
}



//以下解法存在问题///////////////////////////
import java.util.*;  

public class Solution {  
    public List<Integer> largestDivisibleSubset(int[] nums) {  
        List<Integer> ans = new ArrayList<>();  
        int maxLen = 0;  
        int n = nums.length;  
        Arrays.sort(nums);  
  
        if (n == 0) {  
            return ans;  
        }  
  
        // 初始化ans为包含第一个元素的列表  
        ans.add(nums[0]);  
        maxLen = 1;  
  
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                if (nums[j] % nums[i] == 0) {  
                    List<Integer> res = new ArrayList<>();  
                    res.add(nums[i]);  
                    res.add(nums[j]);  
                    int temp = nums[j];  
                    for (int k = j + 1; k < n; k++) {  
                        if (nums[k] % temp == 0) {  
                            res.add(nums[k]);  
                            temp = nums[k];  
                        }  
                    }  
                    if (res.size() > maxLen) {  
                        maxLen = res.size();  
                        ans = res;  
                    }  
                }  
            }  
        }  
        return ans;  
    }  
}


//999_392. 判断子序列
class Solution {
    public boolean isSubsequence(String s, String t) {
        int count=0;
        int n1=s.length();
        int n2=t.length();
        if(n1==0&&n2!=0)
        {
            return true;
        }
        if(n1!=0&&n2==0)
        {
            return false;
        }
        if(n1==0&&n2==0)
        {
            return true;
        }
        for(int i=0;i<n2;i++)
        {
            if(t.charAt(i)==s.charAt(count))
            {
                count++;
            }
            if(count==n1)
            {
                return true;
            }
        }
        return false;
    }
}

//999_395. 至少有 K 个重复字符的最长子串
class Solution {
    public int longestSubstring(String s, int k) {
    	int n=s.length();
    	int maxLen=0;
    	Map<Character,Integer> map1=new HashMap<Character,Integer>();
    	for(int i=0;i<n;i++)
    	{
    		if(!(map1.containsKey(s.charAt(i))))
    		{
    			map1.put(s.charAt(i),1);
    		}
    		else
    		{
    			map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
    		}
    	}   
    	int[] nums=new int[n];
    	for(int i=0;i<n;i++)
    	{
    		nums[i]=map1.get(s.charAt(i));
    	}
    	for(int i=0;i<n;i++)
    	{
    		int count=0;
    		int j=i;
    		while(j<n&&nums[j]>=k)
    		{
    			j++;
    		}
    		int len=j-i;
    		maxLen=Math.max(maxLen,len);
    	}
    	return maxLen;
//    	for(int i=0;i<n;i++)
//    	{
//    		int len=0;
//    		while(i+len<n&&map1.get(s.charAt(i+len))>=k)
//    		{
//    			len++;
//    		}
//    		maxLen=Math.max(len,maxLen);
//    	}    	
//    	return maxLen;
    }
}





//999_400. 第 N 位数字
//  9*1+(99-10+1)*2+(999-100+1)*3+(9999-1000+1)*4+......
//  9*1+90*2+900*3+9000*4+......
class Solution {
    public int findNthDigit(int n) {
    	int count=0;
    	int ten=1;
    	int mult=1;
    	int num=1;
    	while(n>0)
    	{
    		n=n-9*ten*mult;
    		ten=ten*10;
    		mult=mult+1;
    	}
    	int sum=n+9*(ten/10)*(mult-1);
    	ten/=10;    	
    	while(ten>0)
    	{
    		count++;
    		num*=10;
    		ten/=10;
    	}
    	num-=1;
    	num=num+(sum/mult);
    	return num;
    }
}



//999_416. 分割等和子集

import java.util.*;  

public class Solution {  
    public List<Integer> largestDivisibleSubset(int[] nums) {  
        List<Integer> ans = new ArrayList<>();  
        int maxLen = 0;  
        int n = nums.length;  
        Arrays.sort(nums);  
  
        if (n == 0) {  
            return ans;  
        }  
  
        // 初始化ans为包含第一个元素的列表  
        ans.add(nums[0]);  
        maxLen = 1;  
  
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                if (nums[j] % nums[i] == 0) {  
                    List<Integer> res = new ArrayList<>();  
                    res.add(nums[i]);  
                    res.add(nums[j]);  
                    int temp = nums[j];  
                    for (int k = j + 1; k < n; k++) {  
                        if (nums[k] % temp == 0) {  
                            res.add(nums[k]);  
                            temp = nums[k];  
                        }  
                    }  
                    if (res.size() > maxLen) {  
                        maxLen = res.size();  
                        ans = res;  
                    }  
                }  
            }  
        }  
        return ans;  
    }  
}




//999_438:找到字符串中所有字母异位词



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        if(n<m)
        {
        	return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<>();
        int[]scount=new int[26];
        int[]pcount=new int[26];
        for(int i=0;i<m;i++)
        {
        	scount[s.charAt(i)-'a']++;
        	pcount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(scount, pcount))
        {
        	ans.add(0);
        }
        for(int i=m;i<n;i++)
        {
        	scount[s.charAt(i-m)-'a']--;
        	scount[s.charAt(i)-'a']++;
        	if(Arrays.equals(scount, pcount))
        	{
        		ans.add(i-m+1);
        	}
        }
        return ans;
    }
}
//999_442. 数组中重复的数据

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int count=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!map.containsKey(nums[i]))
    		{
    			map.put(nums[i],1);
    		}
    		if(map.containsKey(nums[i])&&map.get(nums[i])==1)
    		{
    			map.put(nums[i],2);
    			count++;
    		}
    	}
    	List<Integer> ans=new ArrayList<Integer>();
    	int j=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		if(map.containsKey(nums[i])&&map.get(nums[i])==2)
    		{
    			ans.add(nums[i]);
    			map.put(nums[i],3);
    			j++;
    		}
    	}
    	return ans;
    }
}

//999——445. 两数相加 II







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Deque<Integer> stack1=new ArrayDeque<Integer>();
    	Deque<Integer> stack2=new ArrayDeque<Integer>();
    	while(l1!=null)
    	{
    		stack1.push(l1.val); 
            l1=l1.next;   	
    	}
    	while(l2!=null)
    	{
    		stack2.push(l2.val);    
            l2=l2.next;	
    	}
    	ListNode ans=null;
    	int carry=0;
    	while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0)
    	{
    		int a=stack1.isEmpty()?0:stack1.pop();
    		int b=stack2.isEmpty()?0:stack2.pop();
    		int val=a+b+carry;
    		carry=val/10;
    		val%=10;
    		ListNode cur=new ListNode(val);
    		cur.next=ans;
    		ans=cur;
    	}
    	return ans;
    }
}


//999_451. 根据字符出现频率排序

class Solution {
    public String frequencySort(String s) {
    	Map<Character,Integer> map =new HashMap<Character,Integer>();
    	int n=s.length();
		for(int i=0;i<n;i++)
    		{
    			if(!map.containsKey(s.charAt(i)))
    			{
    				map.put(s.charAt(i),1);
    			}
    			else
    			{
    				map.put(s.charAt(i),map.get(s.charAt(i))+1);
    			}
    		}
		List<Character> list=new ArrayList<Character>(map.keySet());
		Collections.sort(list,(a,b)->(map.get(b)-map.get(a)));
		StringBuffer ans=new StringBuffer();
		for(int i=0;i<list.size();i++)
		{
			char c=list.get(i);
			{
				for(int j=0;j<map.get(c);j++)
				{
					ans.append(c);
				}
			}
		}
		return ans.toString();
    }
}



//999_452. 用最少数量的箭引爆气球

class Solution {
    public int findMinArrowShots(int[][] points) {
    	if(points.length==0)
    	{
    		return 0;
    	}
        Arrays.sort(points,new Comparator<int[]>()
        {
        	public int compare(int[]point1,int[]point2)
        	{
        		if(point1[1]>point2[2])
        		{
        			return 1;
        		}
        		if(point1[1]<point2[2])
        		{
        			return -1;
        		}
        		else
        		{
        			return 0;
        		}
        	}
        };
        int pos=points[0][1];
        int ans=1;
        for(int[]ballon:points)
        {
        	if(ballon[0]>pos)
        	{
        		pos=ballon[1];
        		ans++;
        	}
        }
        return ans;
    }
}


//999——470. 用 Rand7() 实现 Rand10()
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while(true)
        {
            int num=rand7()+7*(rand7()-1);
            if(num<=40)
            {
                return 1+(num-1)%10;
            }
        }
    }
}

//999——503. 下一个更大元素 II
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int [] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            int cur=(i+1)%n;
            while(nums[cur]<=nums[i])
            {
                cur++;
                if(cur==(i+1)%n)
                {
                    ans[i]=-1;
                }
            }
            ans[i]=nums[cur];
        }
        return ans;
    }
}


//999_543：二叉树的直径


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	int maxLen=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    	test(root);
        return maxLen;

    }
    
	public int test(TreeNode root)
    {
    	
    	if(root ==null)
        {
        	return 0;
        }
        int L=test(root.left);
        int R=test(root.right);
        maxLen=Math.max(maxLen, L+R);
        return Math.max(L, R)+1;
    }
}
///////////////////////



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	
    public int diameterOfBinaryTree(TreeNode root) {
    	int[] maxLen=new int[1];
    	maxLen[0]=Integer.MIN_VALUE; 
    	test(root,maxLen);
        return maxLen[0];

    }
    
	public int test(TreeNode root,int maxLen[])
    {   	
    	if(root ==null)
        {
        	return 0;
        }
        int L=test(root.left,maxLen);
        int R=test(root.right,maxLen);
        maxLen[0]=Math.max(maxLen[0], L+R);
        return Math.max(L, R)+1;
    }
}

//999_560:和为k的子数组

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
        	int sum=0;
        	for(int j=i;j<n;j++)
        	{
        		sum+=nums[j];
        		if(sum==k)
        		{
        			count++;
        		}
        	}
        }
        return count;
    }
}



//999——556. 下一个更大元素 III

12496     12649
123534    123543
54356     54365    	
2346      2364
8769432   8792346
8769732   8772369

class Solution {
    public int nextGreaterElement(int n) {
    	int temp=n;
    	int len=0;
    	while(temp>0)
    	{
    		temp/=10;
    		count++;        //count即为n的长度
    	}
    	while(n%10<=n%100)
    }
}


//999_567. 字符串的排列

class Solution {
    public boolean checkInclusion(String s1, String s2) {
    	int n1=s1.length();
    	int n2=s2.length();
    	if(n1>n2)
    	{
    		return false;
    	}
    	for(int i=0;i<n2-n1+1;i++)
    	{
    		if(isok(s1,s2.substring(i,i+n1))==true)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    public boolean isok(String a,String b)
    {
    	int[] numa=new int[26];
    	int[] numb=new int[26];
    	Arrays.fill(numa,0);
    	Arrays.fill(numb,0);
    	{
    		for(int i=0;i<a.length();i++)
    		{
    			numa[a.charAt(i)-'a']++;
    			numb[b.charAt(i)-'a']++;
    		}
    	}
    	for(int i=0;i<26;i++)
    	{
    		if(numa[i]!=numb[i])
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
}



//999——611. 有效三角形的个数

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        if(n<3)
        {
        	return 0;
        }
        for(int i=0;i<n-2;i++)
        {
        	for(int j=i+1;j<n-1;j++)
        	{
        		int low=j+1;
        		int high=n-1;
        		while(low<=high)
        		{
        		    int mid=(low+high)/2;                    
        			if(nums[mid]<nums[i]+nums[j])
        			{
        				low=mid+1;
        			}
        			else
        			{
        				high=mid-1;
        			}
        		}
        		count+=(high-j);
        	}
        }
        return count;
    }
}




//999_1000：
import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		for(int i=0;i<num;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			System.out.println(a+b);
		}
	}
}




//999_1001:

import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int rows=s.nextInt();
		s.nextLine();
		String row1=s.nextLine();
		String row2=s.nextLine();
		String row3=s.nextLine();
		int num1=row1.length();
		int num2=row2.length();
		int num3=row3.length();
		int count1=0;
		int count2=0;
		int count3=0;
		for(int i=0;i<num1;i++)
		{
			if(row1.charAt(i)-'0'>=0&&row1.charAt(i)-'0'<=9)
			{
				count1++;
			}
		}
		for(int i=0;i<num2;i++)
		{
			if(row2.charAt(i)-'0'>=0&&row2.charAt(i)-'0'<=9)
			{
				count2++;
			}
		}
		for(int i=0;i<num3;i++)
		{
			if(row3.charAt(i)-'0'>=0&&row3.charAt(i)-'0'<=9)
			{
				count3++;
			}
		}
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
	}
}

//999——1002


import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();   //表示有m行输入
		s.nextLine();
		String line1=s.nextLine();    
		String line2=s.nextLine();
		int len1=line1.length();
		int len2=line2.length();
		int[] row1=new int[len1];
		int[] row2=new int[len2];
		for(int i=0;i<len1;i++)
		{
			row1[i]=line1.charAt(i)-'0';
		}
		Arrays.sort(row1);
		for(int i=0;i<len2;i++)
		{
			row2[i]=line2.charAt(i)-'0';
		}
		Arrays.sort(row2);
		System.out.println(row1[len1-2]);
		System.out.println(row2[len2-2]);
	}
}




import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();  
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();  
			int[] row=new int[n];
			for(int j=0;j<n;j++)
			{
				row[j]=s.nextInt();
			}
			Arrays.sort(row);
			if(n<2)
			{
				System.out.println(row[0]); 
			}
			else
			{
				System.out.println(row[n-2]);
			}
			if(s.hasNextLine())
			{
				s.nextLine();
			}
		}
		s.close();
	}
}




//999-1003

import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			bubbleSort1(a);
			for(int j=0;j<n;j++)
			{
				if(j!=n-1)
				{
					System.out.print(a[j]);
					System.out.print(' ');
				}
				else
				{
					System.out.println(a[j]);
				}
			}
		}
	}
	
	public static void bubbleSort1(int a[])
	{
		int n=a.length;
		if(n<2)
		{
			return;
		}
		for(int i=0;i<n-1;i++)
		{
			if(a[i]>a[i+1])
			{
				int temp=a[i+1];
				a[i+1]=a[i];
				a[i]=temp;
			}
		}
	}
}



//999-1005


//以下审题错误 不正确/////////////////////////////
import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
			}
			int p1=Partition(a,0,n-1);
			Partition(a,0,p1-1);
			Partition(a,p1+1,n-1);
			for(int i=0;i<n;i++)
			{
				if(i!=n-1)
				{
					System.out.print(a[i]);
					System.out.print(' ');
				}
				else
				{
					System.out.println(a[i]);
				}
				
			}
		}
	}
	public static int Partition(int a[],int low,int high,int res[1000])
	{
		int p=low;
		int x=a[low];
		for(int i=low+1;i<=high;i++)
		{
			if(a[i]<x)
			{
				p++;
				swap(a,p,i);
			}
		}
		swap(a,low,p);
		for(int i=0;i<a.length;i++)
		{
			res[i]=a[i];
		}
		return p;
	}
	public static void swap(int a[],int q,int w)
	{
		int temp=a[q];
		a[q]=a[w];
		a[w]=temp;
	}
}


//以下仍然不是正确做法



import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[]res=new int[n];
			int[]a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			func(a,res,n);
		}	
	}

	public static void func(int[]a,int[] res,int n)
	{		
		quickSort(a,0,n-1,1,res);
		for(int i=0;i<n;i++)
		{
			if(i!=n-1)
			{
				System.out.print(res[i]);
				System.out.print(' ');
			}
			else
			{
				System.out.println(res[i]);				
			}
		}
	}
	public static void swap(int a[],int m,int n)
	{
		int temp=a[m];
		a[m]=a[n];
		a[n]=temp;
	}
	public static void quickSort(int a[],int low,int high,int depth,int[]res)
	{
		if(low>=high)
		{
			return;
		}
		if(low+1==high)
		{
			if(a[low]>a[high])
			{
				swap(a,low,high);				
			}
			return;
		}
		int p=low;
		for(int i=low;i<=high;i++)
		{
			if(a[i]<a[low])
			{
				p++;
				swap(a,i,p);
			}
		}
		swap(a,low,p);
		if(depth==1)
		{
			res[p]=a[p];
		}
		if(depth==2)
		{
			for(int i=low;i<=high;i++)
			{
				res[i]=a[i];
			}
		}
		quickSort(a,low,p-1,depth+1,res);
		quickSort(a,p+1,high,depth+1,res);
	}
}








////////////////////////////////////

import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		
	}
}


//////////////////////////////////

import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			solve(n);
		}
		
	}
	
	public static void solve(int n)
	{
		Scanner m=new Scanner(System.in);
		int[] a=new int[n];
		int[] res=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=m.nextInt();
		}
		quickSort(a,res,0,n-1,1);
		for(int j=0;j<n;j++)
		{
			if(j!=n-1)
			{
				System.out.print(res[j]);
				System.out.print(' ');
			}
			else
			{
				System.out.println(res[j]);
			}
		}
	}
	
	public static void swap(int a[], int p, int q)
	{
		int temp=a[p];
		a[p]=a[q];
		a[q]=temp;
	}
	
	public static void quickSort(int a[],int res[],int low,int high,int depth)
	{
		int p=low;
		int numP=a[p];
		if(low>=high)
		{
			return;
		}
		if(low+1==high)
		{
			swap(a,low,high);
		}
		for(int i=low+1;i<=high;i++)
		{
			if(a[i]<numP)
			{
				p++;
				swap(a,p,i);
			}
		}
		swap(a,p,low);
		if(depth==1)
		{
			res[p]=a[p];
		}
		if(depth==2)
		{
			for(int i=low;i<high;i++)
			{
				res[i]=a[i];
			}
		}
		quickSort(a,res,low,p-1,depth+1);
		quickSort(a,res,p+1,high,depth+1);
	}
}




//快速排序
import java.util.*;
public class Main{
	public static void main(String[] args)
	{
		
	}
	public static void quickSort(int a[],int low,int high)
	{
		
		int mid=partition(a,low,high);
		quickSort(a,low,mid-1);
		quickSort(a,mid+1,high);
	}
	
	public static int partition(int a[],int low,int high)
	{
		int pivot=a[low];
		int p=low;
		for(int i=low+1;i<=high;i++)
		{
			if(a[i]<a[p])
			{				
				swap(a,i,p+1);
				p++;
			}
		}
		swap(a,p,low);
		return p;
	}
	
	public static void swap(int a[],int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}



//999_1005  
//////////////以下是正确做法


package leetcode;

import java.util.*; 
public class Jihawhd{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[] arr=new int[n];
			int[] res=new int[n];
			for(int j=0;j<n;j++)
			{
				arr[j]=s.nextInt();
			}
			s.nextLine();			
			quickSort(arr,res,0,n-1,1);
			for(int k=0;k<n;k++)
			{				
					System.out.print(res[k]);	
					if(k<n-1)
					{
						System.out.print(' ');
					}

				
			}
//			for(int k=0;k<n;k++)
//			{
//				System.out.print(res[k]+' ');
//			}
//			System.out.println(Arrays.toString(res));
//			System.out.println();
		}		
	}
	
	public static int partition(int a[],int low,int high)
	{
		int p=low;
		for(int i=low+1;i<=high;i++)
		{
			if(a[i]<a[low])
			{
				swap(a,p+1,i);
				p++;
			}
		}
		swap(a,low,p);
		return p;
	}
	
	public static void quickSort(int a[],int b[],int low,int high,int depth)
	{
		if(low>=high)
		{
			return;
		}
		if(low+1==high)
		{
			if(a[high]<a[low])
			{
				swap(a,low,high);
			}
		}
		int mid=partition(a,low,high);
		
		if(depth==1)
		{
			b[mid]=a[mid];
		}		
		if(depth==2)
		{
			for(int i=low;i<=high;i++)
			{
				b[i]=a[i];
			}
			
		}		
		quickSort(a,b,low,mid-1,depth+1);
		quickSort(a,b,mid+1,high,depth+1);
	}
	
	public static void swap(int a[],int x,int y)
	{
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
}


//999_1004 正确

package leetcode;

import java.util.Scanner;

public class L1004 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] arr=new int[n];	
			for(int j=0;j<n;j++)
			{
				arr[j]=s.nextInt();
			}
			s.nextLine();
			mergeSort(arr,0,n-1,1);
			for(int k=0;k<n;k++)
			{
				System.out.print(arr[k]);
				if(k<n-1)
				{
					System.out.print(' ');
				}
			}
			System.out.println();
		}

	}
	
	public static void mergeSort(int arr[],int low,int high,int depth)
	{
		if(low>=high)
		{
			return;
		}
		int mid=(low+high)/2;
		mergeSort(arr,low,mid,depth+1);
		mergeSort(arr,mid+1,high,depth+1);
		if(depth>=3)
		{
			merge(arr,low,high);	
		}			
	}
	
	public static void merge(int arr[],int low,int high)
	{
		int mid=(low+high)/2;
		int i=0;
		int j=0;
		int k=low;
		
		int arr1[]=new int[mid-low+1];
		for(int x=low;x<=mid;x++)
		{
			arr1[x-low]=arr[x];
		}

		int arr2[]=new int[high-mid];
		for(int x=mid+1;x<=high;x++)
		{
			arr2[x-mid-1]=arr[x];
		}
		
		while(i<mid-low+1&&j<high-mid)
		{
			if(arr1[i]<arr2[j])
			{
				arr[k]=arr1[i];
				i++;
			}
			else
			{
				arr[k]=arr2[j];
				j++;
			}
			k++;
		}
		while(i<mid-low+1)
		{
			arr[k]=arr1[i];
			i++;
			k++;
		}
		while(j<high-mid)
		{
			arr[k]=arr2[j];
			j++;
			k++;
		}
	}

}

//999_1006 正确


package clock;

import java.util.Scanner;

public class L1006 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] res=new int[n];
			for(int j=0;j<n;j++)
			{
				res[j]=s.nextInt();
			}
			heapSort(res);
			for(int k=0;k<n;k++)
			{
				System.out.print(res[k]);
				if(k<n-1)
				{
					System.out.print(' ');
				}
			}
		}

	}
	
	public static void heapSort(int a[])
	{
		int n=a.length;
		int mid=n/2-1;
		for(int i=mid;i>=0;i--)
		{
			if(2*i+1<n||2*i+2<n)
			{
				if(2*i+2<n)
				{
					if(a[i]>Math.min(a[2*i+1], a[2*i+2]))
					{
						if(a[2*i+1]<a[2*i+2])
						{
							swap(a,i,2*i+1);
						}
						else
						{
							swap(a,i,2*i+2);
						}
					}
				}
				else
				{
					if(a[i]>a[2*i+1])
					{
						swap(a,i,2*i+1);
					}
				}
			}
		}
	}
	
	public static void swap(int a[],int x,int y)
	{
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
}

//999—1007


package clock;
import java.util.*;

public class L1007
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int N=s.nextInt();
			if(!(6<=N&&N<=40))
			{
				System.out.println("Error");
			}
			int K=s.nextInt();
			if(!(1<=K&&K<=6))
			{
				System.out.println("Error");
			}
			s.nextLine();
			String a=s.nextLine();
//			s.nextLine();
			System.out.println(test(K,a));
			
		}
	}
	
	public static int test(int K,String a)
	{
		int n=a.length();
		int[][]dp=new int[n][K+1];        //前n位数字，运用k个乘号的最大乘积
		
		for(int i=0;i<n;i++)
		{
			dp[i][0]=num(a,0,i);
		}
		
		
		for(int i=0;i<n;i++)
		{
			for(int j=1;j<=K;j++)
			{
				for(int k=0;k<i;k++)
				{
					dp[i][j]=Math.max(dp[i][j],dp[k][j-1]*num(a,k+1,i));
				}
			}
		}
		
		return dp[n-1][K];
		
	}
	
	public static int num(String a,int i, int j)  //闭区间 【i,j】转化成数字
	{
		int sum=0;
		int p=i;
		while(p<=j)
		{
			sum*=10;
			int temp=a.charAt(p)-'0';
			sum+=temp;				
			p++;
		}
		return sum;
	}
}







//999_1008  正确


package clock;

import java.util.Scanner;

public class L1007 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			System.out.print(sum(a));
			System.out.print(' ');
			System.out.print(Kinds(a));
			System.out.println();
		}

	}

	public static int Kinds(int a[])  // a数组代表所有导弹高度
	{
		int n=a.length;
		int Height[]=new int[n];
		for(int i=0;i<n;i++)
		{
			Height[i]=0;        //Height数组代表每一套反导系统最后的拦截高度
		}
		Height[0]=a[0];
		int p=0;                //p指针指向数组中最后一个反导系统的位置
		for(int i=1;i<n;i++)
		{
			int q=0;            //q指针指向反导系统中刚好大于下一枚来袭导弹高度的系统位置
			int minHeight=Integer.MAX_VALUE;  //可以拦截的最小高度
			for(int j=0;j<=p;j++)   //遍历每一套反导系统最后拦截的高度
			{
				if(Height[j]<a[i])  //直接跳过无法拦截当前导弹的反导系统
				{
					continue;
				}
				if(Height[j]>=a[i])     //讨论可以拦截的情况
				{
					if(Height[j]<minHeight)  //可以拦截，且当前反导系统高度小于已经遍历过的最小的反导系统高度
					{
						q=j;
						minHeight=Height[j];
					}
				}				
			}
			if(minHeight<Integer.MAX_VALUE)
			{
				Height[q]=a[i];	
			}
			else
			{
				p++;
				Height[p]=a[i];
			}						
		}
		return p+1;
	}
	
	public static int sum(int a[])
	{
		int n=a.length;
		int[] dp=new int[n];  //dp数组记录每一个位置作为结尾，最长的可离散逆序数
		dp[0]=1;
		int maxMissiles=1;
		for(int i=1;i<n;i++)
		{
			if(a[i]<=a[i-1])
			{
				dp[i]=dp[i-1]+1;
			}
			else               //如果当前导弹比上一发导弹更高
			{
				int maxtemp=1;
				for(int j=i-1;j>=0;j--)
				{
					if(a[j]>=a[i])
					{
						maxtemp=Math.max(maxtemp, dp[j]+1);
					}
				}
				dp[i]=maxtemp;
			}
			maxMissiles=Math.max(maxMissiles, dp[i]);
		}
		return maxMissiles;
	}
	
}



//999_1009 正确


package clock;

import java.util.Scanner;

public class L1009 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[] a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}			
			System.out.print(sum(a));
			System.out.println();
		}

	}
	
	public static int sum(int a[])
	{
		int n=a.length;
		int[] dp=new int[n];  //dp数组记录每一个位置作为结尾，最长的可离散逆序数
		dp[0]=1;
		int maxMissiles=1;
		for(int i=1;i<n;i++)
		{
			if(a[i]<=a[i-1])
			{
				dp[i]=dp[i-1]+1;
			}
			else               //如果当前导弹比上一发导弹更高
			{
				int maxtemp=1;
				for(int j=i-1;j>=0;j--)
				{
					if(a[j]>=a[i])
					{
						maxtemp=Math.max(maxtemp, dp[j]+1);
					}
				}
				dp[i]=maxtemp;
			}
			maxMissiles=Math.max(maxMissiles, dp[i]);
		}
		return maxMissiles;
	}
}


//999_1010 正确


package clock;

import java.util.Scanner;

public class L1010 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[] a=new int[n];
			int target=s.nextInt();
			s.nextLine();
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			binarySearch(a,target);
		}

	}
	
	public static void binarySearch(int a[],int target)
	{
		int n=a.length;
		int low=0;
		int high=n-1;
		int lastmid=(low+high)/2;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(a[mid]==target)
			{
				System.out.print("success, father is ");
				System.out.println(lastmid);
				return;
			}
			if(a[mid]<target)
			{
				low=mid+1;
			}
			if(a[mid]>target)
			{
				high=mid-1;
			}
			lastmid=a[mid];
		}
		System.out.print("not found, father is ");
		System.out.println(lastmid);		
	}
}


//999_1013  正确



package clock;

import java.util.Scanner;

public class L1013 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int a[]=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			System.out.println(inverseNum(a));
		}
	}
	
	public static int inverseNum(int a[])
	{
		int count=0;
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[j]<a[i])
				{
					count++;
				}
			}
		}
		return count;
	}
}



//999_1014


package clock;

import java.util.Scanner;

public class L1014 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int a[]=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			System.out.println(maxSum(a));
		}
	}
	
	public static int maxSum(int a[])
	{
		int n=a.length;
		int[] dp=new int[n];
		dp[0]=a[0];
		int maxSize=a[0];
		for(int i=1;i<n;i++)
		{
			dp[i]=Math.max(dp[i-1]+a[i],a[i]);
			maxSize=Math.max(maxSize,dp[i]);
		}
		return maxSize;
	}
}


//999_1016 正确

package clock;

import java.util.Scanner;
import java.util.Arrays;

public class L1016 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int target=s.nextInt();
			s.nextLine();
			int a[]=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			test(a,target);
		}

	}
	
	public static void test(int a[],int target)
	{
		Arrays.sort(a);
		int n=a.length;
		if(a[n-2]+a[n-1]<target||a[0]+a[1]>target)
		{
			System.out.println("no");
			return;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]+a[j]==target)
				{
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}

}



//999_1018

package clock;

import java.util.*;

public class L1018 {

	public static void main(String[] args) {
		Scanner q=new Scanner(System.in);
		int m=q.nextInt();
		q.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=q.nextInt();
			int c=q.nextInt();
			int []s=new int[n];			
			int []v=new int[n];
			for(int j=0;j<n;j++)
			{
				s[j]=q.nextInt();
				v[j]=q.nextInt();
			}
			System.out.println(test(s,v,n,c));
		}

	}
	
	public static int test(int s[],int v[],int n,int c)
	{
		int size=0;
		int value=0;
		List<Integer> set=new ArrayList<Integer>();
		backtrack(s,v,n,c,size,value,0,set);
		int Vmax=0;
		for(int i=0;i<set.size();i++)
		{
			Vmax=Math.max(Vmax, set.get(i));
		}
		return Vmax;
		
		
	}
	
	public static void backtrack(int s[],int v[],int n,int c,int size,int value,int start,List<Integer> set)
	{
		if(size==c)
		{
			set.add(value);
			return;
		}
		if(size>c)
		{
			return;
		}
		
		for(int i=start;i<n;i++)
		{
			size+=s[i];
			value+=v[i];
			backtrack(s,v,n,c,size,value,i+1,set);
			size-=s[i];
			value-=v[i];
		}
	}
	
}







//999_1019


package clock;

import java.util.Arrays;
import java.util.Scanner;

public class L1019 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int c=s.nextInt();
			int[]w=new int[n];
			int[]v=new int[n];
			for(int j=0;j<n;j++)
			{
				w[j]=s.nextInt();
				v[j]=s.nextInt();
			}
			s.nextLine();
			System.out.print(test(w,v,c));
			System.out.println();
		}

	}

	public static int test(int w[],int v[],int c)
	{
		int n=w.length;
		int[][]dp=new int[n][c+1];      //代表选取前i块宝石，背包容量为j的时候最大价值
		int minWeight=w[0];
		for(int i=1;i<n;i++)
		{
			minWeight=Math.min(minWeight,w[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<c+1;j++)
			{
				if(j<minWeight)
				{
					dp[i][j]=0;
				}
				if(i==0)
				{
					if(j>=w[0])
					{
						dp[0][j]=v[0];
					}
				}
			}
		}
		
		for(int i=1;i<n;i++)
		{ 
			for(int j=0;j<c+1;j++)
			{
				if(w[i]<=j)
				{
					if(dp[i-1][j]>v[i]+dp[i-1][j-w[i]])
					{
						dp[i][j]=dp[i-1][j];
					}
					else
					{
						dp[i][j]=dp[i-1][j-w[i]]+v[i];
					}
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[n-1][c];
		
	}
}




//999_1020



package clock;

import java.util.Scanner;
import java.util.Arrays;

public class L1020 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[] row=new int[n];
			int[] col=new int[n];
			s.nextLine();
			for(int j=0;j<n;j++)
			{
				row[j]=s.nextInt();
				col[j]=s.nextInt();
			}
			s.nextLine();
			System.out.println(test(row,col));
		}

	}
	public static int test(int row[],int col[])
	{
		int n=row.length;
		int[][]dp=new int[n][n];
		
		for(int[]a:dp)
		{
			Arrays.fill(a,Integer.MAX_VALUE);
		}
		for(int i=0;i<n;i++)
		{
			dp[i][i]=0; 
		}
		
		for(int len=2;len<=n;len++)
		{
			for(int i=0;i<n;i++)
			{
				int j=i+len-1;
				if(j>n-1)
				{
					break;
				}
				for(int k=i;k<j;k++)
				{
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+row[i]*col[k]*col[j]);
				}
			}
		}
		return dp[0][n-1];
	}
	
}



//999_1021


package clock;

import java.util.Scanner;
import java.util.Set;

import 力扣热题100.HashSet;
import 力扣热题100.ListNode;
import 力扣热题100.TreeNode;

import java.util.ArrayList;
import java.util.Collections; 

public class L1021 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int allLength=s.nextInt();
			int n=s.nextInt();
			s.nextLine();
			int[]len=new int[n];
			int[]v=new int[n];
			for(int j=0;j<n;j++)
			{
				len[j]=s.nextInt();
				v[j]=s.nextInt();
			}
			
			int min=len[0];
			for(int j=0;j<n;j++)
			{
				min=Math.min(len[j], min);
			}
			if(allLength<min)
			{
				System.out.println(0);
			}
			else
			{
				ArrayList<Integer>list =new ArrayList<Integer>();
				int lastMoney=v[0];
				backtrack(len,v,allLength,min,0,list,lastMoney);
				System.out.println(Collections.max(list));
			}
			
		}

	}
	
	public static void backtrack(int len[],int v[],int leftLength,int minLen,int money,ArrayList<Integer> list,int lastMoney)
	{	
		if(leftLength<minLen)
		{
			if(leftLength>=0)
			{
				list.add(money);
				return;	
			}
			else
			{
				list.add(money-lastMoney);
				return;
			}
			
		}
		for(int i=0;i<v.length;i++)
		{
			leftLength-=len[i];
			money+=v[i];
			lastMoney=v[i];
			backtrack(len,v,leftLength,minLen,money,list,lastMoney);
			leftLength+=len[i];
			money-=v[i];
		}
		
	}
}


//999_1022


package clock;

import java.util.Scanner;

public class L1022 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
//			StringBuffer a=new StringBuffer();
//			StringBuffer b=new StringBuffer();
			String a=s.nextLine();
			String b=s.nextLine();
			System.out.println(maxSharedCharacters(a,b));			
		}

	}
	
	public static int maxSharedCharacters(String a, String b)
	{
		int n1=a.length();
		int n2=b.length();
		int[][] dp=new int[n1][n2];
		int p1=-1;
		int p2=-1;
		
		
		for(int i=0;i<n1;i++)
		{
			if(a.charAt(i)==b.charAt(0))
			{
				p1=i;
				break;
			}
			else
			{
				dp[i][0]=0;	
			}			
		}
		if(p1!=-1)
		{
			for(int i=p1;i<n1;i++)
			{
				dp[i][0]=1;
			}
		} 
		
		
		
		for(int i=0;i<n2;i++)
		{
			if(b.charAt(i)==a.charAt(0))
			{
				p2=i;
				break;
			}
			else
			{
				dp[0][i]=0;
			}
		}
		if(p2!=-1)
		{
			for(int i=p2;i<n2;i++)
			{
				dp[0][i]=1;
			}
		} 
		

		
		
		for(int i=1;i<n1;i++)
		{
			for(int j=1;j<n2;j++)
			{
				if(a.charAt(i)==b.charAt(j))
				{
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[n1-1][n2-1];
	}
}


//999_1025


package clock;

import java.util.Scanner;

public class L1025 {
	public static void main(String [] args)
	{
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int a[]=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			System.out.println(test(a));
		}
	}
	
	public static int test(int a[])
	{
		int n=a.length;
		int dp[]=new int[n];
		dp[0]=1;
		for(int i=1;i<n;i++)
		{
			dp[i]=1;
			for(int j=i-1;j>=0;j--)
			{
				if(a[j]<=a[i])
				{
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
		}
		return dp[n-1];
	}
}



//999_1030



package clock;
import java.util.*;

public class L1030 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			s.nextLine();
			int[] a=new int[2*n];
			for(int j=0;j<2*n;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			System.out.println(test(a));
		}

	} 
	
	public static int test(int a[])
	{
		int length=0;
		int[] lastSite=new int[a.length+1];
		Stack<Integer> stack=new Stack<>();
		stack.push(a[0]);
		int k=0;
		lastSite[k++]=0;
		for(int i=1;i<a.length;i++)
		{
			if(!stack.isEmpty()&&stack.peek()+a[i]==1)
			{
				stack.pop();
				length+=(i-lastSite[--k]);				
			}
						
			else
			{
				stack.push(a[i]);
				lastSite[k++]=i;     
			}			
		}
		return length;
	}

}



//999——1040


1  4  7  11 15
2  5  8  12 19
3  6  9  16 22
10 13 14 17 24 
18 21 23 26 30


package clock;

import java.util.Scanner;

public class L1040 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int nums=s.nextInt();
		s.nextLine();
		for(int i=0;i<nums;i++)
		{			
			int m=s.nextInt();
			int n=s.nextInt();			
			int target=s.nextInt();
			int[][] a=new int[m][n];
			s.nextLine();
			for(int j=0;j<m;j++)
			{
				for(int k=0;k<n;k++)
				{
					a[j][k]=s.nextInt();
				}
			}
			s.nextLine();
			System.out.println(test(a,target)==true?"true":false);
		}

	}

	public static boolean test(int a[][],int target)
	{
		int m=a.length;
		int n=a[0].length;
		int i=0;
		int j=n-1;
		while(i<=m-1&&j>=0&&a[i][j]!=target)
		{
			if(a[i][j]<target)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		if(i<m&&j>=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}



//999——1041


package clock;

import java.util.Arrays;
import java.util.Scanner;

public class L1041 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{
			int n1=s.nextInt();
			int n2=s.nextInt();
			s.nextLine();
			float[] a=new float[n1];
			float[] b=new float[n2];
			for(int j=0;j<n1;j++)
			{
				a[j]=s.nextInt();
			}
			s.nextLine();
			
			for(int j=0;j<n2;j++)
			{
				b[j]=s.nextInt();
			}
			s.nextLine();
			
			System.out.println(test(a,b));
		}

	}
	
	public static float test(float[] a,float[] b)
	{
		int n1=a.length;
		int n2=b.length;
		float[] arr=new float[n1+n2];
		for(int i=0;i<n1;i++)
		{
			arr[i]=a[i];
		}
		for(int i=0;i<n2;i++)
		{
			arr[i+n1]=b[i];
		}
		Arrays.sort(arr);
		if((n1+n2)%2==1)
		{
			return arr[(n1+n2)/2];
		}
		else
		{
			return (arr[(n1+n2)/2-1]+arr[(n1+n2)/2])/2;
		}
	}

}



//999_1043


package clock;
import java.util.*;
public class L1043 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int nums=s.nextInt();
		s.nextLine();
		for(int i=0;i<nums;i++)
		{			
			int K=s.nextInt();
			int N=s.nextInt();			
			s.nextLine();
			System.out.println(test(K,N));
		}
	}
	public static int test(int K, int N)
	{
		int count=0;
		int low=1;
		int high=N;
		int mid=0;

		while(low<=high)
		{
				mid=(low+high)/2;
				count++;
				if(high-mid>mid-low)
				{
					low=mid+1;
				}
				else
				{
					high=mid-1;
				}
		}
		return count;
	}
}








#include <iostream>
#include <cstring>
using namespace std;
 
const int N = 510, M = 10010, INF = 0x3f3f3f3f;
 
int n, m, s, t;
int h[N], e[M], w[M], ne[M], idx; // 邻接表存储图
int dist[N]; // dist[i] 表示起点到 i 的最短距离
bool st[N]; // st[i] 表示 i 是否已经确定了最短路
 
void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++; // 添加一条从 a 到 b 权值为 c 的边
}
 
int dijkstra() {
    memset(dist, 0x3f, sizeof dist); // 将 dist 数组全部初始化为 INF，表示起点到所有点的距离都未知
    dist[s] = 0; // 起点到自身的距离为 0
    for (int i = 0; i < n; i++) { // 迭代 n 次，每次确定一个最短路
        int t = -1; // t 记录还未确定最短路的点中，离起点最近的点
        for (int j = 1; j <= n; j++) // 找离起点最近的点
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;
        st[t] = true; // 标记 t 已经确定了最短路
        for (int j = h[t]; ~j; j = ne[j]) { // 用 t 更新其他点的距离
            int k = e[j];
            if (dist[k] > dist[t] + w[j])
                dist[k] = dist[t] + w[j];
        }
    }
    if (dist[t] == INF) return -1; // t 不可达，返回 -1
    else return dist[t]; // 返回起点到 t 的最短距离
}
 
int main() {
    int T;
    cin >> T;
    while (T--) {
        cin >> n >> m >> s >> t;
        memset(h, -1, sizeof h);
        idx = 0;
        for (int i = 0; i < m; i++) {
            int a, b, c;
            cin >> a >> b >> c;
            add(a, b, c), add(b, a, c); // 添加一条无向边
        }
        cout << dijkstra() << endl;
    }
    return 0;
}
