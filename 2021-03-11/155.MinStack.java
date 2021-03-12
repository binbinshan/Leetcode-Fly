//最小栈
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> mStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        mStack = new Stack();
        mStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        mStack.push(mStack.peek()< x?mStack.peek():x );
    }
    
    public void pop() {
        if(stack.empty() != true){
            stack.pop();
            mStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
      return  mStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */