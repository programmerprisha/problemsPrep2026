class MinStack {
    // bruh I thought we have to use another data structure like not stack allowed to use
    private Stack<Integer> mainStack; 
    private Stack<Integer> minStack; 

    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<Integer>(); 
    }
    
    public void push(int val) {
        mainStack.push(val); 
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        int top = mainStack.pop(); 
        if (top == minStack.peek()) {
            minStack.pop(); 
        }

    }
    
    public int top() {
        return mainStack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek(); 
    }
}
