class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {this.key = key; this.value = value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    //头指针 尾指针
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       DLinkedNode node =  cache.get(key);
       if(node == null){
           return -1;
       }
       //移动至头节点
       moveToHand(node);
       return node.value;
    }

    
    public void put(int key, int value) {
        DLinkedNode node =  cache.get(key);
        if(node == null){
            //不存在，创建个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key,newNode);
            size++;
            //添加至头节点
            addToHand(newNode);

            //存不下了 就删除最后一个元素
            if(size > capacity){
                //删除最后一个元素
                DLinkedNode res = tail.prev;
                removeNode(res);
                //清除key
                cache.remove(res.key);
                --size;
                //长度-1
            }

        }else{
            //存在就修改，挪动至头部
            node.value = value;
            moveToHand(node);
        }


    }
    //将当前节点添加到头节点
    public void addToHand(DLinkedNode node){
        //当前元素前指针指向头节点
        node.prev = head;
        //当前元素后指针指向头节点的下一节点
        node.next = head.next;
        //头节点的下一节点的 前指针 指向 当前元素
        head.next.prev = node;
        //头节点的下一节点指向node
        head.next = node;
    }

    //删除元素
    public void removeNode(DLinkedNode node){
         //删除当前元素
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //将当前节点移动到头节点
    public void moveToHand(DLinkedNode node){
        removeNode(node);
        //当前元素前指针指向头节点
        node.prev = head;
        //当前元素后指针指向头节点的下一节点
        node.next = head.next;
        //头节点的下一节点的 前指针 指向 当前元素
        head.next.prev = node;
        //头节点的下一节点指向node
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */