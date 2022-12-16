
class Node{
    
    Node next;
    Node prev;
    int value;
    int state;
    
    
    public Node(int value, int state){
        this.value = value;
        this.state = state;
    }
}
class LRUCache {
    Node front,back;
    int size,capacity;
    Map<Integer,Node> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        front = back = null;
        hm = new HashMap();
    }
    
    private void moveToFront(Node app){
        if(app == front)return;
        if(app == back)back = back.next;
        
        Node nextApp = app.next;
        Node prevApp = app.prev;
        
        if(nextApp != null)nextApp.prev = prevApp;
        if(prevApp != null)prevApp.next = nextApp;
        
        front.next = app;
        app.prev = front;
        app.next = null;
        front = app;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node app = hm.get(key);
            moveToFront(app);
            return app.state;
        }
        return -1;
    }
    
    private void addAtFront(Node app){
        if(front == null){
            front = back = app;
            return;
        }
        
        front.next = app;
        app.prev = front;
        app.next = null;
        front = app;
    }
    
    private int removeBack(){
        if(back == null) return -1;
        int backAppName = back.value;
        Node nextApp = back.next;
        if(nextApp != null)nextApp.prev = null;
        back.next = null;
        back = nextApp;
        
        return backAppName;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node app = hm.get(key);
            moveToFront(app);
            app.state = value;
        }else{
            Node app = new Node(key,value);
            hm.put(key,app);
            addAtFront(app);
            size++;
        }
        if(size > capacity){
            int backApp = removeBack();
            size--;
            hm.remove(backApp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */