class Stack {
    
    Queue q1;
    Queue q2;

    public Stack() { // Default constructor
        this.q1 = new Queue();
        this.q2 = new Queue();
    }

    public void push(Node node) {
        // If queue is empty, just push it into queue
        if (q1.getHead() == null) {
            q1.enqueue(node);
        } else { // For when queue already contains values
            q2.enqueue(node);
            while (q1.getHead() != null) { // Copies everything from q1 to q2
                q2.enqueue(q1.dequeue());
            }
            while (q2.getHead() != null) { // Copies everything back from q2 to q1
                q1.enqueue(q2.dequeue());
            }
        }
    }

    public Node pop() { // Pops the top item from the stack
        return this.q1.dequeue();
    }

    public boolean isEmpty() { // Returns boolean of whether the stack is empty or not
        if (this.q1.getHead() == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
