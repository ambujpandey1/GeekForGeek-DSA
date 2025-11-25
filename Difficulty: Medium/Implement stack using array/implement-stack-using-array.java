class myStack {
        int capacity;
        int[] stackA;
        int peekIdx;
    public myStack(int n) {
        // Define Data Structures
        this.capacity=n;
        this.stackA=new int[n];
        this.peekIdx=-1;
    }

    public boolean isEmpty() {
        // check if the stack is empty
 
        return peekIdx==-1;
    }

    public boolean isFull() {
        // check if the stack is full
    
        return peekIdx==capacity-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()) return;
        stackA[++peekIdx]=x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()) return;
        --peekIdx;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()) return -1;
        return stackA[peekIdx];
    }
}