

class MyCircularQueue {

    private int[] items;
    private int head = 0;
    private int tail = 0;
    private int size;
    private int count;

    public MyCircularQueue(int k) {
        items = new int[k];
        size = k;
    }
    //时间复杂度O(n)  在插入进行删除后的队列空间 进行复制处理
    public boolean enQueue(int value) {

        //tail == size表示队列末尾没有空间了
        if(tail == size){
            //tail == size && head ==0  表示队列满了 返回false
            if(head == 0){
                return false;
            }

            //tail == n && head !=0 表示可以通过挪动数据来腾出空间

            for(int i = head; i < tail; i++){
                items[i - head] = items[i];
            }

            tail -= head;
            head = 0;
        }

        items[tail] = value;
        tail++; 
        count++;
        return true;
    }
    //O(1)
    public boolean deQueue() {
        if(tail == head){
            return false;
        }
        head++;
        count--;
        return true;
    }
    
    //O(1)
    public int Front() {
        if(count == 0){
            return -1;
        }else{
            if(head == 0){
                return items[0];
            }else{
              return items[head];
            }
        }
    }
    //O(1)
    public int Rear() {
      if(count == 0){return -1;}
       return items[tail-1];
    }
    
    //O(1)
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }

        return false;
    }
    
    //O(1)
    public boolean isFull() {
        if(count == size){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */