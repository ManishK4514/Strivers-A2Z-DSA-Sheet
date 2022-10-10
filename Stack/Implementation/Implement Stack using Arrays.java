/*
   Q. Implement Stack using Array
   Problem statement: Implement a stack using an array.
   
   Note: Stack is a data structure that follows the Last In First Out (LIFO) rule.
   
   Example:  
   
   Explanation: 
   push(): Insert the element in the stack.   
   pop(): Remove and return the topmost element of the stack.   
   top(): Return the topmost element of the stack.   
   size(): Return the number of remaining elements in the stack.
*/


class MyStack
{
    int top;
	int arr[] = new int[1000];

    MyStack()
	{
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a)
	{
	    top = top + 1;
	    arr[top] = a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
	    if(top == -1){
	        return -1;
	    }
        int last = arr[top];
        top = top - 1;
        return last;
	}
    
    // pick
    int pick(){
        if(top == -1){
	        return -1;
	    }
        
        return arr[top];
    }
    
    // Check isEmpty
    boolean isEmpty(){
        return top == -1;
    }
}

public class Implementation_Of_Stack_By_Array {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        
        while(!s.isEmpty()){
            System.out.println(s.pick());
            s.pop();
        }
    }
}
