/*
   Input: push(4)
       push(14)
       push(24)
       push(34)
       top()
       size()
       pop()

   Output: 
   
   The element pushed is 4
   The element pushed is 14
   The element pushed is 24
   The element pushed is 34
   The peek of the queue before deleting any element 4
   The size of the queue before deletion 4
   The first element to be deleted 4
   The peek of the queue after deleting an element 14
   The size of the queue after deleting an element 3
*/


class Queue{
    int front, rear;
    int[] arr = new int[1000];
    Queue(){
        rear = -1;
    }
    
    // isEmpty
    boolean isEmpty(){
        return rear == -1;
    }

    // enqueue
    void add(int value){
        if(rear == arr.length - 1){
            System.out.println("Queue Full!");
            return;
        }
        rear++;
        arr[rear] = value;
    }

    // dequeue
    int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return -1;
        }
        int front = arr[0];
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    // peak
    int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
}

public class Implement_Queue_Using_Array {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(11);
        q.add(12);
        q.add(13);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
