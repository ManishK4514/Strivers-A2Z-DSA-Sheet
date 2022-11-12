/*
 * Implementation Of Heap Data Structure
 * Written by: Manish Kumar
 * Date: 12-11-2022
 */


class Heap{
    private int[] heap;
    private int size;

    // Constructor to initialize the Heap
    public Heap(int capacity){
        heap = new int[capacity];
    }

    // Insert Method
    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is Full!");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }
    
    // Delete Method
    public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty!");
        }
        int parent = getParent(index);
        // Stroing deleted Value to return at the end
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if(index == 0 || heap[index] < heap[parent]){
            // if Above Heap is Violated
            fixHeapBelow(index, size - 1);
        }
        else{
            // if Below Heap is Violated
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    // Get peek Element Method
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty!");
        }
        return heap[0];
    }

    // Fix Heap Below Method for Deleting an Item & Maintaing the Structure.
    public void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    // if Right Child Does not Exist
                    childToSwap = leftChild;
                }
                else{
                    // if Left and Right Child both exist then Finding the maximum among them to replace with.
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                if(heap[index] < heap[childToSwap]){
                    // swaping the Values
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else{
                    break;
                }

                index = childToSwap;
            }
            else{
                break;
            }
        }
    }

    // Method to Fix Heap Above by Swapping the Values;
    public void fixHeapAbove(int index){
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    // Method to Print Heap
    public void printHeap(){
        for(int i = 0; i < size; i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    // Method to Check heap is full or not.
    public boolean isFull(){
        return size == heap.length;
    }

    // Method to get the parent for a element or node
    public int getParent(int index){
        return (index - 1)/2;
    }

    // Method to check heap is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    // Method to get child of a node or element
    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }
}

public class Implementation_Of_Heap {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        heap.delete(0);
        heap.printHeap();
        System.out.println(heap.peek());
    }
}
