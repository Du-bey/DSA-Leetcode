class MyCircularDeque {

    int[] a;
    int front =0, rear = 1, len =0;
    public MyCircularDeque(int k) {
        a = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = ++front % a.length;
        a[front] = value;
        len++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        rear = (--rear + a.length) % a.length;
        a[rear] = value;
        len++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (--front + a.length) % a.length;
        len--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = ++rear % a.length;
        len--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : a[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : a[rear];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == a.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */