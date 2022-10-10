// Implement Circular Queue using Arrays

class CircularQueue{
    int front, rear;
    int[] arr = new int[1000];
    CircularQueue(){
        front = -1;
        rear = -1;
    }
    
    // isEmpty
    boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    // isFull
    boolean isFull(){
        return (rear + 1) % arr.length == front;
    }

    // enqueue
    void add(int value){
        if(isFull()){
            System.out.println("Queue Full!");
            return;
        }

        // Adding first element
        if(front == -1){
            front = 0;
        }

        rear = (rear + 1) % arr.length;
        arr[rear] = value;
    }

    // dequeue
    int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return -1;
        }

        // if there is only one element in the Queue
        int result = arr[front];
        if(rear == front){
            rear = -1;
            front = -1;
        }
        else{
            front = (front + 1) % arr.length;
        }
        return result;
    }

    // peak
    int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }
}

public class Implement_Circular_Queue_using_Arrays {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
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
