import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>()
        		{
        	public int compare(int p1[],int p2[])
        	{
        		return p1[0]==p2[0]?p2[1]-p1[1]:p2[0]-p1[0];
        	}
        		});
        for(int i=0;i<k;i++)
        {
        	pq.offer(new int[] {nums[i],i});
        }
        int count=1;
        ans[0]=pq.peek()[0];
        for(int i=k;i<n;i++)
        {
        	pq.offer(new int[] {nums[i],i});
        	while(pq.peek()[1]<=i-k)
        	{
        		pq.poll();
        	}
        	ans[count]=pq.peek()[0];
        	count++;
        }
        return ans;
    }
}


































//超出时间限制，但是正确
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[]ans=new int[n-k+1];
        int p=0;
        for(int i=0;i<n-k+1;i++)
        {
            int maxValue=nums[i];
            for(int j=i+1;j<i+k;j++)
            {
                maxValue=Math.max(maxValue,nums[j]);
            }
            ans[p]=maxValue;
            p++;
        }
        return ans;
    }
}

///////////////正确但是超时

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int []ans=new int[n-k+1];
        int temp=Integer.MIN_VALUE;
        for(int i=1;i<k;i++)
        {
        	temp=Math.max(temp,nums[i]);      	
        }
        ans[0]=Math.max(temp,nums[0]);
        //i为第一个数,temp为[i+1,i+k-1]中的最大值
        for(int i=1;i<=n-k;i++)
        {                    
        	if(nums[i+k-1]>temp)
        	{
        		ans[i]=nums[i+k-1];
        		temp=ans[i];
        	}
        	else
        	{
        		ans[i]=temp;
        		if(temp==nums[i])
        		{
        			temp=Integer.MIN_VALUE;
        			for(int j=i+1;j<=i+k-1;j++)
        			{
        				temp=Math.max(temp,nums[j]);
        			}
        		}
        	}
        }
        return ans;
    }
}


/////////////
//定义解决方案类  
class Solution {  
 // 定义方法，输入为整数数组nums和窗口大小k，输出为整数数组  
 public int[] maxSlidingWindow(int[] nums, int k) {  
     // 获取数组的长度  
     int n = nums.length;  
     // 创建一个优先队列，队列中存储的是整数数组，每个数组包含两个元素：元素值和元素在nums中的索引  
     // 使用自定义的比较器，首先根据元素值降序排列，如果元素值相同，则根据索引降序排列  
     PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {  
         public int compare(int[] pair1, int[] pair2) {  
             // 如果两个元素的元素值不相等，则按照元素值降序排列  
             return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];  
         }  
     });  
     // 初始化优先队列，将前k个元素及其索引加入队列  
     for (int i = 0; i < k; ++i) {  
         pq.offer(new int[]{nums[i], i});  
     }  
     // 创建结果数组，长度为n-k+1，因为滑动窗口的数量是n-k+1  
     int[] ans = new int[n - k + 1];  
     // 将第一个窗口的最大值（即优先队列的顶部元素）存入结果数组的第一个位置  
     ans[0] = pq.peek()[0];  
     // 遍历数组剩余的元素  
     for (int i = k; i < n; ++i)
     {  
         // 将当前元素及其索引加入优先队列  
         pq.offer(new int[]{nums[i], i});  
         // 如果优先队列的顶部元素的索引已经不在当前窗口内，则将其从队列中移除  
         while (pq.peek()[1] <= i - k)
         {  
             pq.poll();  
         }  
         // 将当前窗口的最大值（即优先队列的顶部元素）存入结果数组的对应位置  
         ans[i - k + 1] = pq.peek()[0];  
     }  
     // 返回结果数组  
     return ans;  
 }  
}
这段代码实现了一个滑动窗口最大值的问题。给定一个数组nums和一个整数k，该方法返回一个新数组，其中每个元素是nums中长度为k的子数组的最大值。
通过维护一个优先队列（最大堆）来实现，其中队列的每个元素是一个包含元素值和元素索引的数组。这样可以在每次滑动窗口时，快速找到窗口内的最大值，并随着窗口的滑动更新队列。