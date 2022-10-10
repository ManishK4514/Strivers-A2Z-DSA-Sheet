/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


// Solution 1

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int front =  s2.pop();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return front;
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int front =  s2.peek();
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        return front;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

// Solution 2

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        
        s1.push(x);
        
        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        return s1.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }        
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

// Solution 3

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(!s2.empty()){
            return s2.pop();
        }
        else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
