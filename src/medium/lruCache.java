public class Node {
    int key; 
    int val; 
    Node prev; 
    Node next; 

    public Node (int key, int val) {
        this.key = key; 
        this.val = val; 
        this.prev = null; 
        this.next = null; 
    }
}

public class LRUCache {

    private int cap; 
    private HashMap<Integer, Node> cache; 
    private Node head; 
    private Node tail; 


    public LRUCache(int capacity) {
        this.cap = capacity; 
        this.cache = new HashMap<>(); 
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        head.next = tail; 
        tail.prev = head; 
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1; 
        }

        remove(node);
        addToFront(node); 

        return node.val; 
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value; 

            // updating key also means it has been accessed or recently used
            remove(node); 
            addToFront(node); 
            return; 
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToFront(newNode);

        if (cache.size() > cap) {
            Node lru = tail.prev; 
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void addToFront(Node node) {
        node.prev = head; 
        node.next = head.next; 

        head.next.prev = node;
        head.next = node; 
    }

    private void remove(Node node) {
        node.prev.next = node.next; 
        node.next.prev = node.prev;
    }
}