import java.util.Deque;

class MinStack {
	Deque<Integer> xstack;
	Deque<Integer> minstack;
    public MinStack() {
        xstack=new LinkedList<Integer>();
        minstack=new LinkedList<Integer>();
        minstack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xstack.push(val);
        minstack.push(Math.min(minstack.peek(),val));
    }
    
    public void pop() {
        xstack.pop();
        minstack.pop();
    }
    
    public int top() {
        return xstack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */