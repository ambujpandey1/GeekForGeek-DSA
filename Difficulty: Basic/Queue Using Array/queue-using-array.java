class myQueue {

  int[] QueueA;
  int currSize;
  int maxSize;
  int start;
  int end;
    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        this.QueueA=new int[n];
        this.currSize=0;
        this.maxSize=n;
        this.start=-1;
        this.end=-1;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return currSize==0;
        
    }

    public boolean isFull() {
        // Check if queue is full
        return currSize==maxSize;
        
    }

    public void enqueue(int x) {
        // Enqueue
        if(isFull()) return;
        if(start==-1) start=0;
        QueueA[++end]=x;
        currSize++;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()) return;
        start++;
        currSize--;
        
        if(currSize==0){
            start=-1;
            end=-1;
        }
    }

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return QueueA[start];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()) return -1;
        return QueueA[end];
    }
}
