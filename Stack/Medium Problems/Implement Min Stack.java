/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Soltion 1:

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(st.empty()){
            min = val;
        }
        else{
            min = Math.min(st.peek().y, val);
        }
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}

// Solution 2:

class MinStack {
    static Long min;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.empty()) {
            min = val;
            st.push(val);
        } else {
            if (val < min) {
                st.push(2 * val - min);
                min = val;
            } else {
                st.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.empty()) return;
        
        Long val = st.pop();
        if(val < min){
            min = (2 * min) - val;
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val < min){
            return min.intValue();
        }
        else{
            return val.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}
