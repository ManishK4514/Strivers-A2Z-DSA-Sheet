class LRUCache {
    class Node{
        int key, val;
        Node next, prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    int capacity = 0, size = 0;

    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
    
        // Initial configuration of doubly linkedlist
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            // update value of the node
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);            
        }
        else if(size < capacity){
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
            size++;
        }
        else{
            // create space by deleting one node from the prev of tail
            Node lastNode = tail.prev;
            deleteNode(lastNode);
            map.remove(lastNode.key);

            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
        }
    }

    private void insertAfterHead(Node node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print("(" + current.key + "," + current.val + "), ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
