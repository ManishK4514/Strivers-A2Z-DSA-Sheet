import java.util.ArrayList;

/*
 *  Fully Implementation of Stack Using LinkedList.
 *  Code Written by: Manish Kumar
 *  Date: 10-10-2022
 */

class Stack {
    static ArrayList<Integer> list = new ArrayList<>();

    // Check isEmpty
    public boolean isEmpty(){
        return list.size() == 0;
    }

    // push
    public void push(int value){        
        list.add(value);
    }
    
    // pop
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    // peek
    public int pick(){
        if(isEmpty()){
            return -1;
        }
        return list.get(list.size() - 1);
    }
}

public class Implementation_Of_Stack_By_ArrayList {
    public static void main(String[] args) {
        Stack s = new Stack();
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
